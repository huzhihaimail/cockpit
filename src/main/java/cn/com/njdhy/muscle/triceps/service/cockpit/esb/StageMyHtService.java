package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageMyHtDao;
import cn.com.njdhy.muscle.triceps.dao.StageMyQyyqwhkDao;
import cn.com.njdhy.muscle.triceps.model.database.StageMyHt;
import cn.com.njdhy.muscle.triceps.model.database.StageMyQyyqwhk;
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
 * @Description 合同+变更金额、已付、应付未付
 * @Date 2018/7/18
 **/
@Service
public class StageMyHtService {


    private static final Logger logger = LoggerFactory.getLogger(StageMyHtService.class);

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyHt}")
    private String method ;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据


    @Autowired
    private StageMyHtDao stageMyHtDao;


    public void getStageMyQyyqwhk() throws IOException {

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
                break;

            case "0":
                logger.info("调用ESB接口没有数据返回");
                break;

            case "1":
                JSONArray jsonArray = (JSONArray) msgResponse.get("Data");
                List<StageMyHt> list = new ArrayList<StageMyHt>();
                for (int i = 0;i<jsonArray.size();i++) {
                    JSONObject stageMyHtJson = (JSONObject) jsonArray.get(i);
                    String projectName = (String) stageMyHtJson.get("ProjName");
                    String dataDate = (String) stageMyHtJson.get("CurrentDate");//当前年月日
                    String allAmt = (String) stageMyHtJson.get("HTAlterAmount");//合同+变更金额
                    String yzfAmt = (String) stageMyHtJson.get("PayedAmount");//已支付
                    String yfwfAmt = (String) stageMyHtJson.get("NotPayAmount");//应付未付

                    StageMyHt stageMyHt = new StageMyHt();
                    stageMyHt.setProjectName(projectName);
                    stageMyHt.setDataDate(dataDate);
                    stageMyHt.setAllAmt(allAmt);
                    stageMyHt.setYzfAmt(yzfAmt);
                    stageMyHt.setYfwfAmt(yfwfAmt);
                    list.add(stageMyHt);
                }
                list.forEach( stageMyHt -> this.insert(stageMyHt) );
                break;

            default:
                break;

        }


    }

    public int insert(StageMyHt stageMyHt) {
        return stageMyHtDao.insert(stageMyHt);
    }


}
