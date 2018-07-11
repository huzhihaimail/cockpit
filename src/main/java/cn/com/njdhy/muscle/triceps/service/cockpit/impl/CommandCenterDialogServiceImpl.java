package cn.com.njdhy.muscle.triceps.service.cockpit.impl;


import cn.com.njdhy.muscle.triceps.dao.CommandCenterDialogDao;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ICommandCenterDialogService;
import cn.com.njdhy.muscle.triceps.service.cockpit.entity.GetDimOrgOutPut;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/13.
 */
@Service
public class CommandCenterDialogServiceImpl extends BaseServiceImpl implements ICommandCenterDialogService {
    @Autowired
    private CommandCenterDialogDao commandCenterDialogDao;

    /**
     * 六率指标模块
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<SixRateIndexForDialog> getSixRateIndexDialog(String yearCode, String monthCode, String type) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("type", type);
        return commandCenterDialogDao.getSixRateIndexDialog(map);
    }

    /**
     * 六率指标弹框趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<SixRateIndexForDialogOfMonth> getSixRateIndexDialogOfMonth(String yearCode, String type) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        map.put("type", type);
        return commandCenterDialogDao.getSixRateIndexDialogOfMonth(map);
    }

    /**
     * 收入利润模块 -预算收入
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<BudgetRevenue> getBudgetRevenueDialog(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return commandCenterDialogDao.getBudgetRevenueDialog(map);
    }

    /**
     * 收入利润模块 -预算收入 -月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<BudgetRevenueOfMonth> getBudgetRevenueDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getBudgetRevenueDialogOfMonth(map);
    }

    /**
     * 收入利润模块 -结转利润
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<CarryOverProfit> getCarryOverProfitDialog(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return commandCenterDialogDao.getCarryOverProfitDialog(map);
    }

    /**
     * 收入利润模块 -结转利润 -月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<CarryOverProfitOfMonth> getCarryOverProfitDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getCarryOverProfitDialogOfMonth(map);
    }

    /**
     * 收入利润模块 -节税
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<TaxSection> getTaxSectionDialog(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return commandCenterDialogDao.getTaxSectionDialog(map);
    }

    /**
     * 收入利润模块 --节税 --月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<TaxSectionOfMonth> getTaxSectionDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getTaxSectionDialogOfMonth(map);
    }

    /**
     * 销售完成模块 --销售
     *
     * @param yearCode
     * @param monthCode
     * @param type      null 本月，!=null 本年
     * @return
     */
    @Override
    public List<CurrentSaleXS> getCurrentSaleForSaleFinishDialog(String yearCode, String monthCode, String type) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (type != null)
            map.put("type", type);
        return commandCenterDialogDao.getCurrentSaleForSaleFinishDialog(map);
    }

    /**
     * 销售完成模块--本月销售--月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<CurrentSaleXSOfMonth> getCurrentSaleForSaleFinishDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getCurrentSaleForSaleFinishDialogOfMonth(map);
    }

    /**
     * 回款完成模块 --销售
     *
     * @param yearCode
     * @param monthCode
     * @param type      null 本月，!=null 本年
     * @return
     */
    @Override
    public List<CurrentSaleHK> getCurrentSaleForHKDialog(String yearCode, String monthCode, String type) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (type != null)
            map.put("type", type);
        return commandCenterDialogDao.getCurrentSaleForHKDialog(map);
    }

    /**
     * 回款完成模块 --本月销售 --月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<CurrentSaleHKOfMonth> getCurrentSaleForHKDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getCurrentSaleForHKDialogOfMonth(map);
    }

    /**
     * 一级计划模块 --销售
     *
     * @param yearCode
     * @param monthCode
     * @param type      null 本月，!=null 本年
     * @return
     */
    @Override
    public List<FirstGradePlan> getFirstGradePlanDialog(String yearCode, String monthCode, String type) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (type != null)
            map.put("type", type);
        return commandCenterDialogDao.getFirstGradePlanDialog(map);
    }

    /**
     * 一级计划模块 -本月销售 -月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<FirstGradePlanOfMonth> getFirstGradePlanDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getFirstGradePlanDialogOfMonth(map);
    }

    /**
     * 重点工作模块 --重点工作完成率 --城市分布
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<KeyWorkForDialog> getKeyWorkDialog(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return commandCenterDialogDao.getKeyWorkDialog(map);
    }

    /**
     * 重点工作完成率 -月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<KeyWorkForDialogOfMonth> getKeyWorkDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getKeyWorkDialogOfMonth(map);
    }

    /**
     * 重点工作模块 --土地扩展完成率
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<KeyWorkLand> getKeyWorkLandDialog(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return commandCenterDialogDao.getKeyWorkLandDialog(map);
    }

    /**
     * 土地拓展完成率 -月度趋势
     *
     * @param yearCode
     * @return
     */
    @Override
    public List<KeyWorkLandOfMonth> getKeyWorkLandDialogOfMonth(String yearCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearCode", Integer.parseInt(yearCode));
        return commandCenterDialogDao.getKeyWorkLandDialogOfMonth(map);
    }

    /**
     * 查询城市公司
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<GetDimOrgOutPut> getDimOrg(String yearCode,String monthCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearMonth", yearCode+monthCode);
        List<DimOrg> list = commandCenterDialogDao.getDimOrg(map);

        List<GetDimOrgOutPut> outputList = new ArrayList<>();
        if (!EmptyUtils.isEmpty(list)){
            for (DimOrg org:list){
                GetDimOrgOutPut output = new GetDimOrgOutPut();
                output.setYearMonth(org.getYearMonth());
                output.setOrgCode(org.getOrgCode());
                output.setOrgName(org.getOrgName());
                output.setShortOrgName(org.getShortOrgName());
                outputList.add(output);
            }
        }
        return outputList;
    }

    /**
     * 查询所有分类信息
     * @return
     */
    @Override
    public List<SysDomain> getWorkInfo() {
        //不知道有没有参数，所以设置map待定
        ConcurrentHashMap map = new ConcurrentHashMap();
        return commandCenterDialogDao.getWorkInfo(map);
    }

    /**
     * 查询所有进度状态信息
     * @return
     */
    @Override
    public List<SysDomain> getScheduleStatus() {
        //不知道有没有参数，所以设置map待定
        ConcurrentHashMap map = new ConcurrentHashMap();
        return commandCenterDialogDao.getScheduleStatus(map);
    }

    /**
     * 查询明细
     * @param yearCode
     * @param monthCode
     * @param cityCode
     * @param jobType
     * @param jobProcessing
     * @return
     */
    @Override
    public List<FactHnaImportantList> getDetailByDoMain(String yearCode,String monthCode ,String cityCode, String jobType, String jobProcessing) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("yearMonth", yearCode+monthCode);
        if (!EmptyUtils.isEmpty(cityCode)){
            map.put("cityCode", cityCode);
        }
        if (!EmptyUtils.isEmpty(jobType)){
            map.put("jobType", jobType);
        }
        if (!EmptyUtils.isEmpty(jobProcessing)){
            map.put("jobProcessing", jobProcessing);
        }

        return commandCenterDialogDao.getDetailByDoMain(map);
    }


}
