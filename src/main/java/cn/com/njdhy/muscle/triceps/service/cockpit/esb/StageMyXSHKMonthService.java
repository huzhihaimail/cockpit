package cn.com.njdhy.muscle.triceps.service.cockpit.esb;


import cn.com.njdhy.muscle.triceps.dao.StageMyXSHKMonthDao;
import cn.com.njdhy.muscle.triceps.model.database.StageMyXSHKMonth;
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
public class StageMyXSHKMonthService {

    private static final Logger logger = LoggerFactory.getLogger(StageMyXSHKYearService.class);

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyXSHKYear}")
    private String method ;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private StageMyXSHKMonthDao stageMyXSHKMonthDao;

    public void getStageMyXSHKMonth() {


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
                List<StageMyXSHKMonth> list = new ArrayList<StageMyXSHKMonth>();
                for (int i = 0;i<jsonArray.size();i++) {
                    JSONObject stageMyXSHKMonthJson = (JSONObject) jsonArray.get(i);
                    String projectCode = (String) stageMyXSHKMonthJson.get("projguid");
                    String projectName = (String) stageMyXSHKMonthJson.get("projname");
                    String pdCode = (String) stageMyXSHKMonthJson.get("FirstCode");//一级级业态编码
                    String pdName = (String) stageMyXSHKMonthJson.get("FirstName");//一级级业态编码
                    String subpdCode = (String) stageMyXSHKMonthJson.get("BProductTypeShortCode");//二级业态编码
                    String subpdName = (String) stageMyXSHKMonthJson.get("BProductTypeShortName");//二级业态名称
                    String dataDate = (String) stageMyXSHKMonthJson.get("yearmonth");
                    String rgCnt = (String) stageMyXSHKMonthJson.get("sjsp_orderts");
                    String rgArea = (String) stageMyXSHKMonthJson.get("sjsp_orderarea");
                    String rgAmt = (String) stageMyXSHKMonthJson.get("sjsp_orderamount");
                    String qyAmt = (String) stageMyXSHKMonthJson.get("sjsp_contractamount");
                    String qyCntBudget = (String) stageMyXSHKMonthJson.get("yssp_orderts");
                    String qyAreaBudget = (String) stageMyXSHKMonthJson.get("yssp_orderarea");
                    String qyAmtBudget = (String) stageMyXSHKMonthJson.get("yssp_orderamount");
                    String hkAmtBudget = (String) stageMyXSHKMonthJson.get("yssp_ordergetamount");//回款预算金额
                    String hkAmt = (String) stageMyXSHKMonthJson.get("sjsp_getinamount");

                    StageMyXSHKMonth stageMyXSHKMonth = new StageMyXSHKMonth();
                    stageMyXSHKMonth.setProjectCode(projectCode);
                    stageMyXSHKMonth.setProjectName(projectName);
                    stageMyXSHKMonth.setPdCode(pdCode);
                    stageMyXSHKMonth.setPdName(pdName);
                    stageMyXSHKMonth.setSubpdCode(subpdCode);
                    stageMyXSHKMonth.setSubpdName(subpdName);
                    stageMyXSHKMonth.setDataDate(dataDate);
                    stageMyXSHKMonth.setRgCnt(rgCnt);
                    stageMyXSHKMonth.setRgArea(rgArea);
                    stageMyXSHKMonth.setRgAmt(rgAmt);
                    stageMyXSHKMonth.setQyAmt(qyAmt);
                    stageMyXSHKMonth.setQyCntBudget(qyCntBudget);
                    stageMyXSHKMonth.setQyAreaBudget(qyAreaBudget);
                    stageMyXSHKMonth.setQyAmtBudget(qyAmtBudget);
                    stageMyXSHKMonth.setHkAmtBudget(hkAmtBudget);
                    stageMyXSHKMonth.setHkAmt(hkAmt);
                    stageMyXSHKMonth.setEtlTime(new Date());
                    list.add(stageMyXSHKMonth);
                }
                list.forEach( stageMyXSHKMonth -> this.insert(stageMyXSHKMonth) );
                break;

            default:
                break;

        }

    }



    public int insert(StageMyXSHKMonth stageMyXSHKMonth) {
        return stageMyXSHKMonthDao.insert(stageMyXSHKMonth);
    }


}
