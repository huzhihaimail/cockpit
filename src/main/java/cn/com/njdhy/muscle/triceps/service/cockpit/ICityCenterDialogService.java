package cn.com.njdhy.muscle.triceps.service.cockpit;

import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/13.
 */
public interface ICityCenterDialogService {

    /**
     * 二级首页六率指标弹框月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    List<SixRateCityIndexForDialogOfMonth> getSixRateCityIndexDialogOfMonth(String yearCode,String areaCode,String type);

    /**
     * 二级首页收入利润模块预算收入--项目分布
     *  @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityBudgetRevenue> getCityBudgetRevenueDialog(String yearCode, String monthCode, String areaCode);

    /**
     * 二级首页收入利润模块预算收入--月度趋势
     *
     * @param yearCode
     * @param areaCode
     * @return
     */
    List<CityBudgetRevenueOfMonth> getCityBudgetRevenueDialogOfMonth(String yearCode,String areaCode);

    /**
     * 二级首页收入利润模块结转利润--项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityCarryOverProfit> getCityCarryOverProfitDialog(String yearCode,String monthCode,String areaCode);

    /**
     * 二级首页收入利润模块结转利润--月度趋势
     *
     * @param yearCode
     * @param areaCode
     * @return
     */
    List<CityCarryOverProfitOfMonth> getCityCarryOverProfitDialogOfMonth(String yearCode,String areaCode);

    /**
     * 二级首页收入利润模块节税--项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityTaxSection> getCityTaxSectionDialog(String yearCode,String monthCode,String areaCode);

    /**
     * 二级首页收入利润模块节税--月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    List<CityTaxSectionOfMonth> getCityTaxSectionDialogOfMonth(String yearCode,String areaCode);

    /**
     * 二级首页销售完成模块本月销售--项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityCurrentSaleXS> getCityCurrentSaleForSaleFinishDialog(String yearCode,String monthCode,String areaCode);

    /**
     * 二级首页销售完成模块本月销售--月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    List<CityCurrentSaleXSOfMonth> getCityCurrentSaleForSaleFinishDialogOfMonth(String yearCode,String areaCode);

    /**
     * 二级首页销售完成模块本年销售--项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityCurrentYearSaleXS> getCityCurrentYearSaleForSaleFinishDialog(String yearCode,String monthCode,String areaCode);

    /**
     * 二级首页回款完成模块本月销售--项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityCurrentSaleHK> getCityCurrentSaleForHKDialog(String yearCode,String monthCode,String areaCode);

    /**
     * 二级首页回款完成模块本月销售--月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    List<CityCurrentSaleHKOfMonth> getCityCurrentSaleForHKDialogOfMonth(String yearCode,String areaCode);

    /**
     * 二级首页回款完成模块本年销售--项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityCurrentYearSaleHK> getCityCurrentYearSaleForHKDialog(String yearCode,String monthCode,String areaCode);

    /**
     * 一级计划 -本月销售 -项目分布
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityFirstGradePlan> getCityFirstGradePlanDialog(String yearCode,String monthCode,String areaCode);


    /**
     * 一级计划 -本月销售 -月度趋势
     *
     * @param yearCode
     * @param areaCode
     * @return
     */
    List<CityFirstGradePlanOfMonth> getCityFirstGradePlanDialogOfMonth(String yearCode,String areaCode);

    /**
     * 一级计划 -本年销售 -项目分布
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    List<CityFirstGradePlanYear> getCityFirstGradePlanYearDialog(String yearCode,String monthCode,String areaCode);


    /**
     * 重点工作--项目--项目分布
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @param type
     * @return
     */
    List<CityKeyWorkForDialog> getCityKeyWorkDialog(String yearCode,String monthCode,String areaCode,String type);

    /**
     * 重点工作--项目--月度趋势
     *
     * @param yearCode
     * @param areaCode
     * @param type
     * @return
     */
    List<CityKeyWorkForDialogOfMonth> getCityKeyWorkDialogOfMonth(String yearCode,String areaCode,String type);
}
