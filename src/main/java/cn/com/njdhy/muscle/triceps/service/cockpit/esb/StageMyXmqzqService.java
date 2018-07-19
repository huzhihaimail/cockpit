package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageMyXmqzqDao;
import cn.com.njdhy.muscle.triceps.model.database.EsbExceuteLog;
import cn.com.njdhy.muscle.triceps.model.database.StageMyXmqzq;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opendata.api.ODPRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Richard.li
 * @Description 项目全周期
 * @Date 2018/7/18
 **/
@Service
public class StageMyXmqzqService {

    private static final Logger logger = LoggerFactory.getLogger(StageMyHtService.class);

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyXmqzq}")
    private String method ;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据

    @Autowired
    private StageMyXmqzqDao stageMyXmqzqDao;
    @Autowired
    private EsbExceuteLogService esbExceuteLogService;

    public void getStageMyXmqzq(){

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
                esbExceuteLog.setEsbName("项目全周期");
                esbExceuteLog.setEsbCnt(0);
                esbExceuteLog.setEtlStatus("失败");
                esbExceuteLog.setEtlFeadbak(errorCode + errorInfo);
                esbExceuteLogService.insert(esbExceuteLog);
                break;

            case "0":
                logger.info("调用ESB接口没有数据返回");
                EsbExceuteLog esbExceuteLog1 = new EsbExceuteLog();
                esbExceuteLog1.setEsbName("项目全周期");
                esbExceuteLog1.setEsbCnt(0);
                esbExceuteLog1.setEtlStatus("成功");
                esbExceuteLog1.setEtlFeadbak("调用ESB接口没有数据返回");
                esbExceuteLogService.insert(esbExceuteLog1);
                break;

            case "1":
                JSONArray jsonArray = (JSONArray) msgResponse.get("Data");
                List<StageMyXmqzq> list = new ArrayList<StageMyXmqzq>();
                for (int i = 0;i<jsonArray.size();i++) {
                    JSONObject stageMyXmqzqJson = (JSONObject) jsonArray.get(i);
                    String projCode = (String) stageMyXmqzqJson.get("projguid");//项目编码
                    String projName = (String) stageMyXmqzqJson.get("projname");//项目名称
                    String prodCode = (String) stageMyXmqzqJson.get("FirstCode");//一级业态编码
                    String prodName = (String) stageMyXmqzqJson.get("FirstName");//一级业态名称
                    String subProdCode = (String) stageMyXmqzqJson.get("BProductTypeShortCode");//二级业态编码
                    String subProdName = (String) stageMyXmqzqJson.get("BProductTypeShortName");//二级业态名称
                    String areaAll = (String) stageMyXmqzqJson.get("TotalAera");//面积总数
                    String ysArea = (String) stageMyXmqzqJson.get("SoldAera");//已售面积
                    String syArea = (String) stageMyXmqzqJson.get("UnsoldAera");//剩余面积
                    String yshzjrgAmt = (String) stageMyXmqzqJson.get("SubscriptionOfSoldValue");//已售货值净认购
                    String yshzjqyAmt = (String) stageMyXmqzqJson.get("SignOfSoldValue");//已售货值净签约
                    String syhzjrgAmt = (String) stageMyXmqzqJson.get("SubscriptionOfUnsoldValue");//剩余货值净认购
                    String syhzjqyAmt = (String) stageMyXmqzqJson.get("SignOfUnsoldValue");//剩余货值净签约
                    String yhkAmt = (String) stageMyXmqzqJson.get("GetInAmount");//已回款总额

                    StageMyXmqzq stageMyXmqzq = new StageMyXmqzq();
                    stageMyXmqzq.setProjCode(projCode);
                    stageMyXmqzq.setProjName(projName);
                    stageMyXmqzq.setProdCode(prodCode);
                    stageMyXmqzq.setProdName(prodName);
                    stageMyXmqzq.setSubProdCode(subProdCode);
                    stageMyXmqzq.setSubProdName(subProdName);
                    stageMyXmqzq.setAreaAll(areaAll);
                    stageMyXmqzq.setSyArea(ysArea);
                    stageMyXmqzq.setYsArea(syArea);
                    stageMyXmqzq.setYshzjrgAmt(yshzjrgAmt);
                    stageMyXmqzq.setYshzjqyAmt(yshzjqyAmt);
                    stageMyXmqzq.setSyhzjrgAmt(syhzjrgAmt);
                    stageMyXmqzq.setSyhzjqyAmt(syhzjqyAmt);
                    stageMyXmqzq.setYhkAmt(yhkAmt);
                    list.add(stageMyXmqzq);
                }
                list.forEach( stageMyHt -> this.insert(stageMyHt) );
                EsbExceuteLog esbExceuteLog2 = new EsbExceuteLog();
                esbExceuteLog2.setEsbName("项目全周期");
                esbExceuteLog2.setEsbCnt(jsonArray.size());
                esbExceuteLog2.setEtlStatus("完成");
                esbExceuteLogService.insert(esbExceuteLog2);
                break;

            default:
                break;

        }


    }


    public int insert(StageMyXmqzq stageMyXmqzq) {
        return stageMyXmqzqDao.insert(stageMyXmqzq);
    }


}
