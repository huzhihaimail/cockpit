package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageMyCbDao;
import cn.com.njdhy.muscle.triceps.dao.StageMyHtDao;
import cn.com.njdhy.muscle.triceps.model.database.EsbExceuteLog;
import cn.com.njdhy.muscle.triceps.model.database.StageMyCb;
import cn.com.njdhy.muscle.triceps.model.database.StageMyHt;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opendata.api.ODPRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Richard.li
 * @Description 成本合同目标+调整建筑成本单方、动态建筑成本单方、偏差率
 * @Date 2018/7/23
 **/
@Service
public class StageMyCbService {

    private static final Logger logger = LoggerFactory.getLogger(StageMyHtService.class);

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyCb}")
    private String method ;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据


    @Autowired
    private StageMyCbDao stageMyCbDao;
    @Autowired
    private EsbExceuteLogService esbExceuteLogService;


    public void getStageMyCb(){

        String res = new ODPRequest(URL, Appsecret)
                //系统参数
                .addTextSysPara("Method", method)
                .addTextSysPara("AccessToken", AccessToken)//应用票据
                .addTextSysPara("Format", "json")
                .get();

        JSONObject resJson = JSONObject.parseObject(res);
        JSONObject msgResponse = (JSONObject) resJson.get("MsgResponse");
        JSONObject responseInfo = (JSONObject) msgResponse.get("ResponseInfo");
        String result = (String) responseInfo.get("Result");
        switch (result) {
            case "-1":
                String errorCode = (String) responseInfo.get("ErrorCode");
                String errorInfo = (String) responseInfo.get("ErrorInfo");
                logger.error("调用ESB接口发送异常,错误信息 : {} , 错误代码 : {}",errorInfo,errorCode);
                EsbExceuteLog esbExceuteLog = new EsbExceuteLog();
                esbExceuteLog.setEsbName("成本合同目标");
                esbExceuteLog.setEsbCnt(0);
                esbExceuteLog.setEtlStatus("失败");
                esbExceuteLog.setEtlFeadbak(errorCode + errorInfo);
                esbExceuteLogService.insert(esbExceuteLog);
                break;

            case "0":
                logger.info("调用ESB接口没有数据返回");
                EsbExceuteLog esbExceuteLog1 = new EsbExceuteLog();
                esbExceuteLog1.setEsbName("成本合同目标");
                esbExceuteLog1.setEsbCnt(0);
                esbExceuteLog1.setEtlStatus("成功");
                esbExceuteLog1.setEtlFeadbak("调用ESB接口没有数据返回");
                esbExceuteLogService.insert(esbExceuteLog1);
                break;

            case "1":
                JSONArray jsonArray = (JSONArray) msgResponse.get("Data");
                List<StageMyCb> list = new ArrayList<StageMyCb>();
                for (int i = 0;i<jsonArray.size();i++) {
                    JSONObject stageMyCbJson = (JSONObject) jsonArray.get(i);
                    String projectName = (String) stageMyCbJson.get("ProjName");
                    String itemName = (String) stageMyCbJson.get("CostName");//科目名称
                    String dataDate = (String) stageMyCbJson.get("CurrentDate");//当前年月日
                    String mbtzjzcbHj = (String) stageMyCbJson.get("TzJzcbTotalAmount");//目标+调整建筑成本合计
                    String mbtzjzdfHj = (String) stageMyCbJson.get("TzJzdfTotalAmount");//目标+调整建筑单方合计
                    String dtjzcbHj = (String) stageMyCbJson.get("DtJzcbTotalAmount");//动态建筑成本合计
                    String dtjzdfHj = (String) stageMyCbJson.get("DtJzdfTotalAmount");//动态建筑单方合计
                    String pclHj = (String) stageMyCbJson.get("DeviationRateTotal");//偏差率合计
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");
//                    String  = (String) stageMyCbJson.get("");


                    StageMyCb stageMyCb = new StageMyCb();
                    list.add(stageMyCb);
                }
                list.forEach( stageMyCb -> this.insert(stageMyCb) );
                EsbExceuteLog esbExceuteLog2 = new EsbExceuteLog();
                esbExceuteLog2.setEsbName("成本合同目标");
                esbExceuteLog2.setEsbCnt(jsonArray.size());
                esbExceuteLog2.setEtlStatus("完成");
                esbExceuteLogService.insert(esbExceuteLog2);
                break;

            default:
                break;

        }


    }



    public int insert(StageMyCb stageMyCb) {
        return stageMyCbDao.insert(stageMyCb);
    }


}
