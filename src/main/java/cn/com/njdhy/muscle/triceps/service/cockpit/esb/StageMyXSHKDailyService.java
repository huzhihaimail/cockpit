package cn.com.njdhy.muscle.triceps.service.cockpit.esb;


import cn.com.njdhy.muscle.triceps.dao.StageMyXSHKDailyDao;
import cn.com.njdhy.muscle.triceps.model.database.EsbExceuteLog;
import cn.com.njdhy.muscle.triceps.model.database.StageMyXSHKDaily;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opendata.api.ODPRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StageMyXSHKDailyService {

    private static final Logger logger = LoggerFactory.getLogger(StageMyXSHKYearService.class);

    @Value("${haihang.esb.mingyuan.url}")
    private String URL;//API服务接口请求调用地址

    @Value("${haihang.esb.mingyuan.method.stageMyXSHKDaily}")
    private String method ;//API接口名称

    @Value("${haihang.esb.mingyuan.appsecret}")
    private String Appsecret;//app密钥

    @Value("${haihang.esb.mingyuan.accessToken}")
    private String AccessToken;///应用票据

    @Autowired
    private StageMyXSHKDailyDao stageMyXSHKDailyDao;
    @Autowired
    private EsbExceuteLogService esbExceuteLogService;


    public void getStageMyXSHKDaily() {

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
                esbExceuteLog.setEsbName("当天签约回款");
                esbExceuteLog.setEsbCnt(0);
                esbExceuteLog.setEtlStatus("失败");
                esbExceuteLog.setEtlFeadbak(errorCode + errorInfo);
                esbExceuteLogService.insert(esbExceuteLog);
                break;

            case "0":
                logger.info("调用ESB接口没有数据返回");
                EsbExceuteLog esbExceuteLog1 = new EsbExceuteLog();
                esbExceuteLog1.setEsbName("当天签约回款");
                esbExceuteLog1.setEsbCnt(0);
                esbExceuteLog1.setEtlStatus("成功");
                esbExceuteLog1.setEtlFeadbak("调用ESB接口没有数据返回");
                esbExceuteLogService.insert(esbExceuteLog1);
                break;

            case "1":
                JSONArray jsonArray = (JSONArray) msgResponse.get("Data");
                List<StageMyXSHKDaily> list = new ArrayList<StageMyXSHKDaily>();
                for (int i = 0;i<jsonArray.size();i++) {
                    JSONObject stageMyXSHKDailyJson = (JSONObject) jsonArray.get(i);
                    String projectCode = (String) stageMyXSHKDailyJson.get("projguid");
                    String projectName = (String) stageMyXSHKDailyJson.get("projname");
                    String pdCode = (String) stageMyXSHKDailyJson.get("FirstCode");//一级级业态编码
                    String pdName = (String) stageMyXSHKDailyJson.get("FirstName");//一级级业态编码
                    String subpdCode = (String) stageMyXSHKDailyJson.get("BProductTypeShortCode");//二级业态编码
                    String subpdName = (String) stageMyXSHKDailyJson.get("BProductTypeShortName");//二级业态名称
                    String dataDate = (String) stageMyXSHKDailyJson.get("DateNow");
                    String rgCnt = (String) stageMyXSHKDailyJson.get("sjsp_orderts");
                    String rgArea = (String) stageMyXSHKDailyJson.get("sjsp_orderarea");
                    String rgAmt = (String) stageMyXSHKDailyJson.get("sjsp_orderamount");
                    String qyAmt = (String) stageMyXSHKDailyJson.get("sjsp_contractamount");
                    String qyCntBudget = (String) stageMyXSHKDailyJson.get("yssp_orderts");
                    String qyAreaBudget = (String) stageMyXSHKDailyJson.get("yssp_orderarea");
                    String qyAmtBudget = (String) stageMyXSHKDailyJson.get("yssp_orderamount");
                    String hkAmtBudget = (String) stageMyXSHKDailyJson.get("yssp_ordergetamount");//回款预算金额
                    String hkAmt = (String) stageMyXSHKDailyJson.get("sjsp_getinamount");

                    StageMyXSHKDaily stageMyXSHKDaily = new StageMyXSHKDaily();
                    stageMyXSHKDaily.setProjectCode(projectCode);
                    stageMyXSHKDaily.setProjectName(projectName);
                    stageMyXSHKDaily.setPdCode(pdCode);
                    stageMyXSHKDaily.setPdName(pdName);
                    stageMyXSHKDaily.setSubpdCode(subpdCode);
                    stageMyXSHKDaily.setSubpdName(subpdName);
                    stageMyXSHKDaily.setDataDate(dataDate);
                    stageMyXSHKDaily.setRgCnt(rgCnt);
                    stageMyXSHKDaily.setRgArea(rgArea);
                    stageMyXSHKDaily.setRgAmt(rgAmt);
                    stageMyXSHKDaily.setQyAmt(qyAmt);
                    stageMyXSHKDaily.setQyCntBudget(qyCntBudget);
                    stageMyXSHKDaily.setQyAreaBudget(qyAreaBudget);
                    stageMyXSHKDaily.setQyAmtBudget(qyAmtBudget);
                    stageMyXSHKDaily.setHkAmt(hkAmt);
                    stageMyXSHKDaily.setHkAmtBudget(hkAmtBudget);
                    stageMyXSHKDaily.setEtlTime(new Date());
                    list.add(stageMyXSHKDaily);
                }
                list.forEach( stageMyXSHKDaily -> this.insert(stageMyXSHKDaily) );
                EsbExceuteLog esbExceuteLog2 = new EsbExceuteLog();
                esbExceuteLog2.setEsbName("当天签约回款");
                esbExceuteLog2.setEsbCnt(jsonArray.size());
                esbExceuteLog2.setEtlStatus("完成");
                esbExceuteLogService.insert(esbExceuteLog2);
                break;

            default:
                break;

        }

    }


    public int insert(StageMyXSHKDaily stageMyXSHKDaily) {
        return stageMyXSHKDailyDao.insert(stageMyXSHKDaily);
    }

}
