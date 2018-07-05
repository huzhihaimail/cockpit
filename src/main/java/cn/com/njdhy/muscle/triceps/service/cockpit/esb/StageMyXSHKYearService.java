package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageMyXSHKYearDao;
import cn.com.njdhy.muscle.triceps.model.database.StageMyXSHKYear;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opendata.api.ODPRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StageMyXSHKYearService {

    private static final Logger logger = LoggerFactory.getLogger(StageMyXSHKYearService.class);

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyXSHKYear}")
    private String method;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private StageMyXSHKYearDao stageMyXSHKYearDao;

    public void getStageMyXSHKYear() {

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
                logger.error("调用ESB接口发送异常,错误信息 : {} , 错误代码 : {}", errorInfo, errorCode);
                break;

            case "0":
                logger.info("调用ESB接口没有数据返回");
                break;

            case "1":
                JSONArray jsonArray = (JSONArray) msgResponse.get("Data");
                List<StageMyXSHKYear> list = new ArrayList<StageMyXSHKYear>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject StageMyXSHKYearJson = (JSONObject) jsonArray.get(i);
                    String projectName = (String) StageMyXSHKYearJson.get("projname");
                    String pdName = (String) StageMyXSHKYearJson.get("BProductTypeShortName");
                    //subpdName
                    String dataDate = (String) StageMyXSHKYearJson.get("yearmonth");
                    String rgCnt = (String) StageMyXSHKYearJson.get("sjsp_orderts");
                    String rgArea = (String) StageMyXSHKYearJson.get("sjsp_orderarea");
                    String rgAmt = (String) StageMyXSHKYearJson.get("sjsp_orderamount");
                    String qyAmt = (String) StageMyXSHKYearJson.get("sjsp_contractamount");
                    String qyCntBudget = (String) StageMyXSHKYearJson.get("yssp_orderts");
                    String qyAreaBudget = (String) StageMyXSHKYearJson.get("yssp_orderarea");
                    String qyAmtBudget = (String) StageMyXSHKYearJson.get("yssp_orderamount");
                    //hkAmtBudget
                    String hkAmt = (String) StageMyXSHKYearJson.get("sjsp_getinamount");

                    StageMyXSHKYear stageMyXSHKYear = new StageMyXSHKYear();
                    stageMyXSHKYear.setProjectName(projectName);
                    stageMyXSHKYear.setPdName(pdName);
                    stageMyXSHKYear.setDataDate(dataDate);
                    stageMyXSHKYear.setRgCnt(rgCnt);
                    stageMyXSHKYear.setRgArea(rgArea);
                    stageMyXSHKYear.setRgAmt(rgAmt);
                    stageMyXSHKYear.setQyAmt(qyAmt);
                    stageMyXSHKYear.setQyCntBudget(qyCntBudget);
                    stageMyXSHKYear.setQyAreaBudget(qyAreaBudget);
                    stageMyXSHKYear.setQyAmtBudget(qyAmtBudget);
                    stageMyXSHKYear.setHkAmt(hkAmt);
                    stageMyXSHKYear.setEtlTime(new Date());
                    list.add(stageMyXSHKYear);
                }
                list.forEach(stageMyXSHKYear -> this.insert(stageMyXSHKYear));
                break;

            default:
                break;

        }

    }

    public int insert(StageMyXSHKYear stageMyXSHKYear) {
        return stageMyXSHKYearDao.insert(stageMyXSHKYear);
    }

    public int insertList(List<StageMyXSHKYear> list) {
        return stageMyXSHKYearDao.insertList(list);
    }

}
