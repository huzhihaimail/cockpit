package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageUsersPostDao;
import cn.com.njdhy.muscle.triceps.model.database.StageUsersPost;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opendata.api.ODPRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author richard.li
 * @date 2018/6/25 16:57
 */
@Service
public class StageUsersPostService {

    private static final Logger logger = LoggerFactory.getLogger(StageUsersPostService.class);

    private static DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd");

    @Value("${haihang.esb.hr.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.hr.method.empPostRecord}")
    private String method;//API接口名称

    @Value("${haihang.esb.hr.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.hr.accessToken}")
    private String AccessToken;///应用票据

    @Autowired
    private StageUsersPostDao stageUsersPostDao;

    public void getEmpPostRecord() {
        String res3 = new ODPRequest(URL, Appsecret)
                .addTextSysPara("Method", method)
                .addTextSysPara("AccessToken", AccessToken)//应用票据
                .addTextSysPara("Format", "json")
                .addTextAppPara("StartDate", "2000-01-01")
                .addTextAppPara("EndDate", dateTimeformat.format(new Date()))
                .addTextAppPara("OrganID", "0-1-855579-856150-850766-")
                .get();

        JSONObject resJson = JSONObject.parseObject(res3);
        JSONObject msgResponse = (JSONObject) resJson.get("MsgResponse");
        JSONObject responseInfo = (JSONObject) msgResponse.get("ResponseInfo");
        String result = (String) responseInfo.get("Result");
        switch (result) {
            case "-1":
                String errorCode = (String) responseInfo.get("ErrorCode");
                String errorInfo = (String) responseInfo.get("ErrorInfo");
                logger.error("调用ESB接口发送异常,错误信息 : {} , 错误代码 : {}", errorInfo, errorCode);
                break;

            case "0":
                logger.info("调用ESB接口没有数据返回");
                break;

            case "1":
                JSONObject data = (JSONObject) msgResponse.get("Data");
                JSONArray jsonArray = (JSONArray) data.get("NewDataSet");
                List<StageUsersPost> list = new ArrayList<StageUsersPost>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject dimUsersPostJson = (JSONObject) jsonArray.get(i);
                    String iPostRecordID = (String) dimUsersPostJson.get("iPostRecordID");
                    String nNodeID = (String) dimUsersPostJson.get("nNodeID");
                    String vcEmployeeID = (String) dimUsersPostJson.get("vcEmployeeID");
                    String vcOrganID = (String) dimUsersPostJson.get("vcOrganID");
                    String vcPostID = (String) dimUsersPostJson.get("vcPostID");
                    String vcPostName = (String) dimUsersPostJson.get("vcPostName");
                    String cIfMorB = (String) dimUsersPostJson.get("cIfMorB");
                    String tbALnNodeID = (String) dimUsersPostJson.get("tbAL_nNodeID");
                    String vcAdminLevelName = (String) dimUsersPostJson.get("vcAdminLevelName");

                    StageUsersPost stageUsersPost = new StageUsersPost();
                    stageUsersPost.setiPostRecordID(iPostRecordID);
                    stageUsersPost.setnNodeID(nNodeID);
                    stageUsersPost.setVcEmployeeID(vcEmployeeID);
                    stageUsersPost.setVcOrganID(vcOrganID);
                    stageUsersPost.setVcPostID(vcPostID);
                    stageUsersPost.setVcPostName(vcPostName);
                    stageUsersPost.setcIfMorB(cIfMorB);
                    stageUsersPost.setTbALnNodeID(tbALnNodeID);
                    stageUsersPost.setVcAdminLevelName(vcAdminLevelName);
                    list.add(stageUsersPost);
                }
                list.forEach(stageUsersPost -> this.insert(stageUsersPost));
                break;

            default:
                break;

        }


    }

    public int insert(StageUsersPost stageUsersPost) {
        return stageUsersPostDao.insert(stageUsersPost);
    }

}
