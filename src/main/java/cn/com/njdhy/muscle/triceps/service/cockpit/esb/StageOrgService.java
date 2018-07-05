package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageOrgDao;
import cn.com.njdhy.muscle.triceps.model.database.StageOrg;
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
 * @date 2018/6/22 16:34
 * 人事组织机构信息
 */
@Service
public class StageOrgService {

    private static final Logger logger = LoggerFactory.getLogger(StageOrgService.class);

    private static DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd");

    @Value("${haihang.esb.hr.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.hr.method.organInfo}")
    private String method;//API接口名称

    @Value("${haihang.esb.hr.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.hr.accessToken}")
    private String AccessToken;///应用票据

    @Autowired
    private StageOrgDao stageOrgDao;

    public void getOrganInfo() {

        String res2 = new ODPRequest(URL, Appsecret)
                .addTextSysPara("Method", method)
                .addTextSysPara("AccessToken", AccessToken)//应用票据
                .addTextSysPara("Format", "json")
                .addTextAppPara("StartDate", "1990-10-11")
                .addTextAppPara("EndDate", dateTimeformat.format(new Date()))
                .addTextAppPara("SingleNode", "0") //默认为1，返回单条机构信息 1：单条机构 0：包含子机构
                .get();
        JSONObject resJson = JSONObject.parseObject(res2);
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
                List<StageOrg> list = new ArrayList<StageOrg>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject sysOrgJson = (JSONObject) jsonArray.get(i);
                    String cFlag = (String) sysOrgJson.get("cFlag");
                    String hnaOrganProp = (String) sysOrgJson.get("HNA_ORGAN_PROP");
                    String nNodeId = (String) sysOrgJson.get("nNodeID");
                    String vcFullName = (String) sysOrgJson.get("vcFullName");
                    String vcName = (String) sysOrgJson.get("vcName");
                    String vcShortName = (String) sysOrgJson.get("vcShortName");
                    String cLevel = (String) sysOrgJson.get("cLevel");
                    String dOperatorDate = (String) sysOrgJson.get("dOperatorDate");
                    String vcOrganID = (String) sysOrgJson.get("vcOrganID");
                    String vcParentID = (String) sysOrgJson.get("vcParentID");

                    StageOrg stageOrg = new StageOrg();
                    stageOrg.setcFlag(cFlag);
                    stageOrg.setHnaOrganProp(hnaOrganProp);
                    stageOrg.setnNodeId(nNodeId);
                    stageOrg.setVcFullName(vcFullName);
                    stageOrg.setVcName(vcName);
                    stageOrg.setVcShortName(vcShortName);
                    stageOrg.setcLevel(cLevel);
                    stageOrg.setdOperatorDate(dOperatorDate);
                    stageOrg.setVcOrganId(vcOrganID);
                    stageOrg.setVcParentID(vcParentID);
                    list.add(stageOrg);
                }
                list.forEach(stageOrg -> this.insert(stageOrg));
                break;

            default:
                break;

        }

    }

    public int insert(StageOrg stageOrg) {
        return stageOrgDao.insert(stageOrg);
    }

}
