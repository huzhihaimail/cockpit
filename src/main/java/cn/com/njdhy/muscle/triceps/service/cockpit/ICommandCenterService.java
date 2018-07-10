package cn.com.njdhy.muscle.triceps.service.cockpit;


import cn.com.njdhy.muscle.triceps.model.database.AllDataDetails;
import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;

/**
 * Created by cherlin on 2018/6/13.
 */
public interface ICommandCenterService {

    List<AllDataDetails> getAllData(String yearCode,String monthCode);

    SixRateIndex getSixRateIndex(String yearCode, String monthCode, String areaCode);

    BudgetRevenue getBudgetRevenue(String yearCode, String monthCode, String areaCode);

    CarryOverProfit getCarryOverProfit(String yearCode, String monthCode, String areaCode);

    TaxSection getTaxSection(String yearCode, String monthCode, String areaCode);

    CurrentSaleXS getCurrentSaleForSaleFinish(String yearCode, String monthCode, String type, String areaCode);

    CurrentSaleHK getCurrentSaleForHK(String yearCode, String monthCode, String type, String areaCode);

    FirstGradePlan getFirstGradePlan(String yearCode, String monthCode, String type, String areaCode);

    KeyWork getKeyWork(String yearCode, String monthCode, String areaCode, String choose);

    List<MonCityCompanyDis> getMonCityCompanyDis(String yearCode, String monthCode);

    KeyWorkLand getKeyWorkLand(String yearCode, String monthCode);

    List<KeyWorkLand> getInventory(String yearCode, String monthCode, String areaCode);

    List<AllDataDetails> getProjectByAreaCode(String yearCode,String monthCode,String areaCode);
}
