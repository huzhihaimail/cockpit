package cn.com.njdhy.muscle.triceps.dao;



import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/13.
 */
public interface CommandCenterDao {
    
    SixRateIndex getSixRateIndex(Map<String, Object> map);

    BudgetRevenue getBudgetRevenue(ConcurrentHashMap map);

    CarryOverProfit getCarryOverProfit(ConcurrentHashMap map);

    TaxSection getTaxSection(ConcurrentHashMap map);

    CurrentSaleXS getCurrentSaleForSaleFinish(ConcurrentHashMap map);

    CurrentSaleHK getCurrentSaleForHK(ConcurrentHashMap map);

    FirstGradePlan getFirstGradePlan(ConcurrentHashMap map);

    KeyWork getKeyWork(ConcurrentHashMap map);

    List<MonCityCompanyDis> getMonCityCompanyDis(ConcurrentHashMap map);

    KeyWorkLand getKeyWorkLand(ConcurrentHashMap map);

    List<KeyWorkLand> getInventory(ConcurrentHashMap map);

    List<AllDataDetails> getAllData();

    /**
     * 根据城市id查询该城市所有项目
     *
     * @param map
     * @return
     */
    List<AllDataDetails> getProjectByAreaCode(ConcurrentHashMap map);


}
