package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageMyQyyqwhkDao;
import cn.com.njdhy.muscle.triceps.model.database.StageMyQyyqwhk;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opendata.api.ODPRequest;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Richard.li
 * @Description 签约逾期未回款
 * @Date 2018/7/16
 **/
@Service
public class StageMyQyyqwhkService {

    private static final Logger logger = LoggerFactory.getLogger(StageMyQyyqwhkService.class);

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyQyyqwhk}")
    private String method ;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据


    @Autowired
    private StageMyQyyqwhkDao stageMyQyyqwhkDao;


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
                List<StageMyQyyqwhk> list = new ArrayList<StageMyQyyqwhk>();
                for (int i = 0;i<jsonArray.size();i++) {
                    JSONObject stageMyQyyqwhkJson = (JSONObject) jsonArray.get(i);
                    String projectName = (String) stageMyQyyqwhkJson.get("ProjName");
                    String dataDate = (String) stageMyQyyqwhkJson.get("lastDate");
                    String oweType = (String) stageMyQyyqwhkJson.get("ItemType");//未收款项
                    String oweAmt = (String) stageMyQyyqwhkJson.get("RmbAmount");

                    StageMyQyyqwhk stageMyQyyqwhk = new StageMyQyyqwhk();
                    stageMyQyyqwhk.setProjectName(projectName);
                    stageMyQyyqwhk.setDataDate(dataDate);
                    stageMyQyyqwhk.setOweType(oweType);
                    stageMyQyyqwhk.setOweAmt(oweAmt);
                    list.add(stageMyQyyqwhk);
                }
                list.forEach( stageMyQyyqwhk -> this.insert(stageMyQyyqwhk) );
                break;

            default:
                break;

        }


    }



    public int insert(StageMyQyyqwhk stageMyQyyqwhk) {
        return stageMyQyyqwhkDao.insert(stageMyQyyqwhk);
    }


}
