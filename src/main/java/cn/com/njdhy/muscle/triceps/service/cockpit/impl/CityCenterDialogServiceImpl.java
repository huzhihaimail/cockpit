package cn.com.njdhy.muscle.triceps.service.cockpit.impl;


import cn.com.njdhy.muscle.triceps.dao.CityCenterDialogDao;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ICityCenterDialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/13.
 */
@Service
public class CityCenterDialogServiceImpl extends BaseServiceImpl implements ICityCenterDialogService {

    @Autowired
    private CityCenterDialogDao cityCenterDialogDao;

    /**
     * 二级首页六率指标弹框月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<SixRateCityIndexForDialogOfMonth> getSixRateCityIndexDialogOfMonth(String yearCode, String areaCode,String type) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        map.put("type", type);
        return cityCenterDialogDao.getSixRateCityIndexDialogOfMonth(map);
    }

    /**
     * 二级首页收入利润模块预算收入项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityBudgetRevenue> getCityBudgetRevenueDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityBudgetRevenueDialog(map);
    }

    /**
     * 二级首页收入利润模块预算收入月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityBudgetRevenueOfMonth> getCityBudgetRevenueDialogOfMonth(String yearCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityBudgetRevenueDialogOfMonth(map);
    }

    /**
     * 二级首页收入利润模块结转利润项目分布
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCarryOverProfit> getCityCarryOverProfitDialog(String yearCode,String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCarryOverProfitDialog(map);
    }

    /**
     * 二级首页收入利润模块结转利润月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCarryOverProfitOfMonth> getCityCarryOverProfitDialogOfMonth(String yearCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCarryOverProfitDialogOfMonth(map);
    }

    /**
     * 二级首页收入利润模块节税项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityTaxSection> getCityTaxSectionDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityTaxSectionDialog(map);
    }

    /**
     * 二级首页收入利润模块节税月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityTaxSectionOfMonth> getCityTaxSectionDialogOfMonth(String yearCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityTaxSectionDialogOfMonth(map);
    }

    /**
     * 二级首页销售完成模块本月销售项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCurrentSaleXS> getCityCurrentSaleForSaleFinishDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCurrentSaleForSaleFinishDialog(map);
    }

    /**
     * 二级首页销售完成模块本月销售月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCurrentSaleXSOfMonth> getCityCurrentSaleForSaleFinishDialogOfMonth(String yearCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCurrentSaleForSaleFinishDialogOfMonth(map);
    }

    /**
     * 二级首页销售完成模块本年销售项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCurrentYearSaleXS> getCityCurrentYearSaleForSaleFinishDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCurrentYearSaleForSaleFinishDialog(map);
    }

    /**
     * 二级首页回款完成模块本月销售项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCurrentSaleHK> getCityCurrentSaleForHKDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCurrentSaleForHKDialog(map);
    }

    /**
     * 二级首页回款完成模块本月销售月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCurrentSaleHKOfMonth> getCityCurrentSaleForHKDialogOfMonth(String yearCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCurrentSaleForHKDialogOfMonth(map);
    }

    /**
     * 二级首页回款完成模块本年销售项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityCurrentYearSaleHK> getCityCurrentYearSaleForHKDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityCurrentYearSaleForHKDialog(map);
    }

    /**
     * 二级首页一级计划模块本月销售项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityFirstGradePlan> getCityFirstGradePlanDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityFirstGradePlanDialog(map);
    }

    /**
     * 二级首页一级计划模块本月销售月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityFirstGradePlanOfMonth> getCityFirstGradePlanDialogOfMonth(String yearCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityFirstGradePlanDialogOfMonth(map);
    }

    /**
     * 二级首页一级计划模块本年销售项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityFirstGradePlanYear> getCityFirstGradePlanYearDialog(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        return cityCenterDialogDao.getCityFirstGradePlanYearDialog(map);
    }

    /**
     * 二级首页重点工作模块-项目-项目分布
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @param type
     * @return
     */
    @Override
    public List<CityKeyWorkForDialog> getCityKeyWorkDialog(String yearCode, String monthCode, String areaCode,String type) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("monthCode", Integer.parseInt(monthCode));
        map.put("areaCode", areaCode);
        map.put("type", type);
        return cityCenterDialogDao.getCityKeyWorkDialog(map);
    }

    /**
     * 二级首页重点工作模块-项目-月度趋势
     * @param yearCode
     * @param areaCode
     * @return
     */
    @Override
    public List<CityKeyWorkForDialogOfMonth> getCityKeyWorkDialogOfMonth(String yearCode, String areaCode,String type) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("areaCode", areaCode);
        map.put("type", type);
        return cityCenterDialogDao.getCityKeyWorkDialogOfMonth(map);
    }


}
