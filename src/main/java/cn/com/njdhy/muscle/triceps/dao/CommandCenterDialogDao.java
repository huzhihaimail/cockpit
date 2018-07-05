package cn.com.njdhy.muscle.triceps.dao;



import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/13.
 */
public interface CommandCenterDialogDao {
    List<SixRateIndexForDialog> getSixRateIndexDialog(Map<String, Object> map);

    List<BudgetRevenue> getBudgetRevenueDialog(ConcurrentHashMap map);

    /**
     * 收入利润模块预算收入--月度趋势
     *
     * @param map
     * @return
     */
    List<BudgetRevenueOfMonth> getBudgetRevenueDialogOfMonth(ConcurrentHashMap map);

    List<CarryOverProfit> getCarryOverProfitDialog(ConcurrentHashMap map);

    /**
     * 收入利润模块 -结转利润 -月度趋势
     *
     * @param map
     * @return
     */
    List<CarryOverProfitOfMonth> getCarryOverProfitDialogOfMonth(ConcurrentHashMap map);

    List<TaxSection> getTaxSectionDialog(ConcurrentHashMap map);

    /**
     * 收入利润模块 --节税--月度趋势
     *
     * @param map
     * @return
     */
    List<TaxSectionOfMonth> getTaxSectionDialogOfMonth(ConcurrentHashMap map);

    List<CurrentSaleXS> getCurrentSaleForSaleFinishDialog(ConcurrentHashMap map);

    /**
     * 销售完成模块--本月销售--月度趋势
     *
     * @param map
     * @return
     */
    List<CurrentSaleXSOfMonth> getCurrentSaleForSaleFinishDialogOfMonth(ConcurrentHashMap map);

    List<CurrentSaleHK> getCurrentSaleForHKDialog(ConcurrentHashMap map);

    /**
     * 回款完成模块--本月销售--月度趋势
     *
     * @param map
     * @return
     */
    List<CurrentSaleHKOfMonth> getCurrentSaleForHKDialogOfMonth(ConcurrentHashMap map);

    List<FirstGradePlan> getFirstGradePlanDialog(ConcurrentHashMap map);

    /**
     * 一级计划 -本月销售 -月度趋势
     *
     * @param map
     * @return
     */
    List<FirstGradePlanOfMonth> getFirstGradePlanDialogOfMonth(ConcurrentHashMap map);

    /**
     * 重点工作完成率--城市分布
     *
     * @param map
     * @return
     */
    List<KeyWorkForDialog> getKeyWorkDialog(ConcurrentHashMap map);

    /**
     * 重点工作完成率--月度趋势
     *
     * @param map
     * @return
     */
    List<KeyWorkForDialogOfMonth> getKeyWorkDialogOfMonth(ConcurrentHashMap map);

    List<KeyWorkLand> getKeyWorkLandDialog(ConcurrentHashMap map);

    /**
     * 重点工作完成率 -土地拓展完成率 -月度趋势
     *
     * @param map
     * @return
     */
    List<KeyWorkLandOfMonth> getKeyWorkLandDialogOfMonth(ConcurrentHashMap map);


    List<MonCityCompanyDis> getMonCityCompanyDisDialog(ConcurrentHashMap map);

    /**
     * 六率指标弹框趋势接口
     *
     * @param map
     * @return
     */
    List<SixRateIndexForDialogOfMonth> getSixRateIndexDialogOfMonth(ConcurrentHashMap map);
}
