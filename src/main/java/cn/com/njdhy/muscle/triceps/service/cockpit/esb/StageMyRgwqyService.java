package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageMyRgwqyDao;
import cn.com.njdhy.muscle.triceps.model.database.StageMyRgwqy;
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
 * @Description 已认购未签约
 * @Date 2018/7/16
 **/
@Service
public class StageMyRgwqyService {

    private static final Logger logger = LoggerFactory.getLogger(StageMyRgwqyService.class);

    @Autowired
    private StageMyRgwqyDao stageMyRgwqyDao;

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyRgwqy}")
    private String method ;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据

    public void getStageMyRgwqy() throws IOException {

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
                List<StageMyRgwqy> list = new ArrayList<StageMyRgwqy>();
                for (int i = 0;i<jsonArray.size();i++) {
                    JSONObject stageMyRgwqyJson = (JSONObject) jsonArray.get(i);
                    String projectName = (String) stageMyRgwqyJson.get("ProjName"); //项目名称
                    String pdName = (String) stageMyRgwqyJson.get("FirstLevelName");//一级业态名称
                    String subPdName = (String) stageMyRgwqyJson.get("BProductTypeShortName");//二级业态名称
                    String dataDate = (String) stageMyRgwqyJson.get("CurrentDate");//当前年月日
                    String cRgCnt = (String) stageMyRgwqyJson.get("OrderTs");//已认购未签约_套数
                    String cRgArea = (String) stageMyRgwqyJson.get("OrderArea");//已认购未签约_面积
                    String cRgAmt = (String) stageMyRgwqyJson.get("OrderAmount");//已认购未签约_成交总价
                    String cRgHk = (String) stageMyRgwqyJson.get("OrderGetAmount");//已认购未签约_已回款
                    String cRgWhk = (String) stageMyRgwqyJson.get("OrderNoGetAmount");//已认购未签约_未回款
                    String dRgCnt = (String) stageMyRgwqyJson.get("BeforeEndTimeOrderTs");//已认购未到签约日期_套数
                    String dRgArea = (String) stageMyRgwqyJson.get("BeforeEndTimeOrderArea");//已认购未到签约日期_面积
                    String dRgAmt = (String) stageMyRgwqyJson.get("BeforeEndTimeOrderAmount");//已认购未到签约日期_成交总价
                    String dRgHk = (String) stageMyRgwqyJson.get("BeforeEndTimeOrderGetAmount");//已认购未到签约日期_已回款
                    String dRgWhk = (String) stageMyRgwqyJson.get("BeforeEndTimeOrderNoGetAmount");//已认购未到签约日期_未回款
                    String eRgCnt = (String) stageMyRgwqyJson.get("AfterEndTimeOrderTs");//逾期未签约_套数
                    String eRgArea = (String) stageMyRgwqyJson.get("AfterEndTimeOrderArea");//逾期未签约_面积
                    String eRgAmt = (String) stageMyRgwqyJson.get("AfterEndTimeOrderAmount");//逾期未签约_总交总价
                    String eRgHk = (String) stageMyRgwqyJson.get("AfterEndTimeOrderGetAmount");//逾期未签约_已回款
                    String eRgWhk = (String) stageMyRgwqyJson.get("AfterEndTimeOrderNoGetAmount");//逾期未签约_未回款

                    StageMyRgwqy stageMyRgwqy = new StageMyRgwqy();
                    stageMyRgwqy.setProjectName(projectName);
                    stageMyRgwqy.setPdName(pdName);
                    stageMyRgwqy.setSubPdName(subPdName);
                    stageMyRgwqy.setDataDate(dataDate);
                    stageMyRgwqy.setcRgCnt(cRgCnt);
                    stageMyRgwqy.setcRgArea(cRgArea);
                    stageMyRgwqy.setcRgAmt(cRgAmt);
                    stageMyRgwqy.setcRgHk(cRgHk);
                    stageMyRgwqy.setcRgWhk(cRgWhk);
                    stageMyRgwqy.setdRgCnt(dRgCnt);
                    stageMyRgwqy.setdRgArea(dRgArea);
                    stageMyRgwqy.setdRgAmt(dRgAmt);
                    stageMyRgwqy.setdRgHk(dRgHk);
                    stageMyRgwqy.setdRgWhk(dRgWhk);
                    stageMyRgwqy.seteRgCnt(eRgCnt);
                    stageMyRgwqy.seteRgArea(eRgArea);
                    stageMyRgwqy.seteRgAmt(eRgAmt);
                    stageMyRgwqy.seteRgHk(eRgHk);
                    stageMyRgwqy.seteRgWhk(eRgWhk);
                    list.add(stageMyRgwqy);
                }
                list.forEach( stageMyRgwqy -> this.insert(stageMyRgwqy) );
                break;

            default:
                break;

        }


    }



    public int insert(StageMyRgwqy stageMyRgwqy) {
        return stageMyRgwqyDao.insert(stageMyRgwqy);
    }


}
