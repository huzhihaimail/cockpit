package cn.com.njdhy.muscle.triceps.dao;


import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/13.
 */
public interface CityCenterDialogDao {

    /**
     * 二级首页六率指标弹框月度趋势
     *
     * @param map
     * @return
     */
    List<SixRateCityIndexForDialogOfMonth> getSixRateCityIndexDialogOfMonth(ConcurrentHashMap map);


    /**
     * 二级首页收入利润模块预算收入--项目分布
     *
     * @param map
     * @return
     */
    List<CityBudgetRevenue> getCityBudgetRevenueDialog(ConcurrentHashMap map);

    /**
     * 二级首页收入利润模块预算收入--月度趋势
     *
     * @param map
     * @return
     */
    List<CityBudgetRevenueOfMonth> getCityBudgetRevenueDialogOfMonth(ConcurrentHashMap map);

    /**
     * 二级首页收入利润模块结转利润--项目分布
     *
     * @param map
     * @return
     */
    List<CityCarryOverProfit> getCityCarryOverProfitDialog(ConcurrentHashMap map);

    /**
     * 二级首页收入利润模块结转利润--项目分布
     *
     * @param map
     * @return
     */
    List<CityCarryOverProfitOfMonth> getCityCarryOverProfitDialogOfMonth(ConcurrentHashMap map);

    /**
     * 二级首页收入利润模块节税--项目分布
     *
     * @param map
     * @return
     */
    List<CityTaxSection> getCityTaxSectionDialog(ConcurrentHashMap map);

    /**
     * 二级首页收入利润模块节税--月度趋势
     *
     * @param map
     * @return
     */
    List<CityTaxSectionOfMonth> getCityTaxSectionDialogOfMonth(ConcurrentHashMap map);

    /**
     * 二级首页销售完成模块本月销售--项目分布
     * @param map
     * @return
     */
    List<CityCurrentSaleXS> getCityCurrentSaleForSaleFinishDialog(ConcurrentHashMap map);

    /**
     * 二级首页销售完成模块本月销售--月度趋势
     * @param map
     * @return
     */
    List<CityCurrentSaleXSOfMonth> getCityCurrentSaleForSaleFinishDialogOfMonth(ConcurrentHashMap map);

    /**
     * 二级首页销售完成模块本年销售--项目分布
     * @param map
     * @return
     */
    List<CityCurrentYearSaleXS> getCityCurrentYearSaleForSaleFinishDialog(ConcurrentHashMap map);

    /**
     * 二级首页回款完成模块本月销售--项目分布
     * @param map
     * @return
     */
    List<CityCurrentSaleHK> getCityCurrentSaleForHKDialog(ConcurrentHashMap map);

    /**
     * 二级首页回款完成模块本月销售--月度趋势
     * @param map
     * @return
     */
    List<CityCurrentSaleHKOfMonth> getCityCurrentSaleForHKDialogOfMonth(ConcurrentHashMap map);

    /**
     * 二级首页回款完成模块本年销售--项目分布
     * @param map
     * @return
     */
    List<CityCurrentYearSaleHK> getCityCurrentYearSaleForHKDialog(ConcurrentHashMap map);

    /**
     * 一级计划 -本月销售 -项目分布
     *
     * @param map
     * @return
     */
    List<CityFirstGradePlan> getCityFirstGradePlanDialog(ConcurrentHashMap map);

    /**
     * 一级计划 -本月销售 -月度趋势
     *
     * @param map
     * @return
     */
    List<CityFirstGradePlanOfMonth> getCityFirstGradePlanDialogOfMonth(ConcurrentHashMap map);

    /**
     * 一级计划 -本年销售 -项目分布
     *
     * @param map
     * @return
     */
    List<CityFirstGradePlanYear> getCityFirstGradePlanYearDialog(ConcurrentHashMap map);

    /**
     * 重点工作--项目--项目分布
     *
     * @param map
     * @return
     */
    List<CityKeyWorkForDialog> getCityKeyWorkDialog(ConcurrentHashMap map);

    /**
     * 重点工作--项目--项目分布
     *
     * @param map
     * @return
     */
    List<CityKeyWorkForDialogOfMonth> getCityKeyWorkDialogOfMonth(ConcurrentHashMap map);

}
