package cn.com.njdhy.muscle.triceps.service.cockpit.esb;

import cn.com.njdhy.muscle.triceps.dao.StageMyXSHKDailyDao;
import cn.com.njdhy.muscle.triceps.model.database.StageMyXSHKDaily;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StageMyXSHKDailyService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private StageMyXSHKDailyDao stageMyXSHKDailyDao;

    private String url = "xxxxxxxx";

    public void getStageMyXSHKDaily() {
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        JSONObject json = JSONObject.parseObject(results.getBody());
        JSONArray jsonArray = (JSONArray) json.get("Data");
        List<StageMyXSHKDaily> list = new ArrayList<StageMyXSHKDaily>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject StageMyXSHKDailyJson = (JSONObject) jsonArray.get(i);
            String projectName = (String) StageMyXSHKDailyJson.get("projname");
            String pdName = (String) StageMyXSHKDailyJson.get("BProductTypeShortName");
            //subpdName
            String dataDate = (String) StageMyXSHKDailyJson.get("yearmonth");
            String rgCnt = (String) StageMyXSHKDailyJson.get("sjsp_orderts");
            String rgArea = (String) StageMyXSHKDailyJson.get("sjsp_orderarea");
            String rgAmt = (String) StageMyXSHKDailyJson.get("sjsp_orderamount");
            String qyAmt = (String) StageMyXSHKDailyJson.get("sjsp_contractamount");
            String qyCntBudget = (String) StageMyXSHKDailyJson.get("yssp_orderts");
            String qyAreaBudget = (String) StageMyXSHKDailyJson.get("yssp_orderarea");
            String qyAmtBudget = (String) StageMyXSHKDailyJson.get("yssp_orderamount");
            //hkAmtBudget
            String hkAmt = (String) StageMyXSHKDailyJson.get("sjsp_getinamount");

            StageMyXSHKDaily stageMyXSHKDaily = new StageMyXSHKDaily();
            stageMyXSHKDaily.setProjectName(projectName);
            stageMyXSHKDaily.setPdName(pdName);
            stageMyXSHKDaily.setDataDate(dataDate);
            stageMyXSHKDaily.setRgCnt(rgCnt);
            stageMyXSHKDaily.setRgArea(rgArea);
            stageMyXSHKDaily.setRgAmt(rgAmt);
            stageMyXSHKDaily.setQyAmt(qyAmt);
            stageMyXSHKDaily.setQyCntBudget(qyCntBudget);
            stageMyXSHKDaily.setQyAreaBudget(qyAreaBudget);
            stageMyXSHKDaily.setQyAmtBudget(qyAmtBudget);
            stageMyXSHKDaily.setHkAmt(hkAmt);
            stageMyXSHKDaily.setEtlTime(new Date());
            this.insert(stageMyXSHKDaily);
        }
    }


    public int insert(StageMyXSHKDaily stageMyXSHKDaily) {
        return stageMyXSHKDailyDao.insert(stageMyXSHKDaily);
    }

}
