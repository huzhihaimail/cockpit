package cn.com.njdhy.muscle.triceps.service.cockpit;

import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;

/**
 * Created by cherlin on 2018/6/13.
 */
public interface ICommandCenterDialogService {

    List<SixRateIndexForDialog> getSixRateIndexDialog(String yearCode, String monthCode, String type);

    /**
     * 六率指标弹框趋势接口
     *
     * @param yearCode
     * @return
     */
    List<SixRateIndexForDialogOfMonth> getSixRateIndexDialogOfMonth(String yearCode, String type);

    List<BudgetRevenue> getBudgetRevenueDialog(String yearCode, String monthCode);

    /**
     * 收入利润模块预算收入--月度趋势
     *
     * @param yearCode
     * @return
     */
    List<BudgetRevenueOfMonth> getBudgetRevenueDialogOfMonth(String yearCode);

    List<CarryOverProfit> getCarryOverProfitDialog(String yearCode, String monthCode);

    /**
     * 收入利润模块 -结转利润 -月度趋势
     *
     * @param yearCode
     * @return
     */
    List<CarryOverProfitOfMonth> getCarryOverProfitDialogOfMonth(String yearCode);

    List<TaxSection> getTaxSectionDialog(String yearCode, String monthCode);

    /**
     * 收入利润模块 --节税--月度趋势
     *
     * @param yearCode
     * @return
     */
    List<TaxSectionOfMonth> getTaxSectionDialogOfMonth(String yearCode);

    List<CurrentSaleXS> getCurrentSaleForSaleFinishDialog(String yearCode, String monthCode, String type);

    /**
     * 销售完成模块--本月销售--月度趋势
     *
     * @param yearCode
     * @return
     */
    List<CurrentSaleXSOfMonth> getCurrentSaleForSaleFinishDialogOfMonth(String yearCode);

    List<CurrentSaleHK> getCurrentSaleForHKDialog(String yearCode, String monthCode, String type);

    /**
     * 回款完成模块--本月销售--月度趋势
     *
     * @param yearCode
     * @return
     */
    List<CurrentSaleHKOfMonth> getCurrentSaleForHKDialogOfMonth(String yearCode);

    List<FirstGradePlan> getFirstGradePlanDialog(String yearCode, String monthCode, String type);

    /**
     * 一级计划模块 -本月销售 -月度趋势
     *
     * @param yearCode
     * @return
     */
    List<FirstGradePlanOfMonth> getFirstGradePlanDialogOfMonth(String yearCode);

    /**
     * 重点工作模块 -重点工作完成率 -城市分布
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    List<KeyWorkForDialog> getKeyWorkDialog(String yearCode, String monthCode);

    /**
     * 重点工作模块 -重点工作完成率 -月度趋势
     *
     * @param yearCode
     * @return
     */
    List<KeyWorkForDialogOfMonth> getKeyWorkDialogOfMonth(String yearCode);

    List<KeyWorkLand> getKeyWorkLandDialog(String yearCode, String monthCode);

    /**
     * 重点工作完成率 -土地拓展完成率 -月度趋势
     *
     * @param yearCode
     * @return
     */
    List<KeyWorkLandOfMonth> getKeyWorkLandDialogOfMonth(String yearCode);

}
