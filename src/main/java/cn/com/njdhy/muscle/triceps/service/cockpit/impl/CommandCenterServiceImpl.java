package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import cn.com.njdhy.muscle.triceps.dao.CommandCenterDao;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ICommandCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/13.
 */
@Service
public class CommandCenterServiceImpl extends BaseServiceImpl implements ICommandCenterService {

    @Autowired
    private CommandCenterDao commandCenterDao;

    /**
     * 获取城市集团所有信息
     *
     * @return
     */
    @Override
    public List<AllDataDetails> getAllData() {
        return commandCenterDao.getAllData();
    }

    /**
     * 六率指标模块
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public SixRateIndex getSixRateIndex(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getSixRateIndex(map);
    }

    /**
     * 收入利润模块 -预算收入
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public BudgetRevenue getBudgetRevenue(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getBudgetRevenue(map);
    }

    /**
     * 收入利润模块 -结转利润
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public CarryOverProfit getCarryOverProfit(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getCarryOverProfit(map);
    }

    /**
     * 收入利润模块 -节税
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public TaxSection getTaxSection(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getTaxSection(map);
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
    public CurrentSaleXS getCurrentSaleForSaleFinish(String yearCode, String monthCode, String type, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (type != null) {
            map.put("type", type);
        }
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getCurrentSaleForSaleFinish(map);
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
    public CurrentSaleHK getCurrentSaleForHK(String yearCode, String monthCode, String type, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (type != null) {
            map.put("type", type);
        }
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getCurrentSaleForHK(map);
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
    public FirstGradePlan getFirstGradePlan(String yearCode, String monthCode, String type, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (type != null) {
            map.put("type", type);
        }
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getFirstGradePlan(map);
    }

    /**
     * 重点工作模块 --重点工作完成率
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public KeyWork getKeyWork(String yearCode, String monthCode, String areaCode, String choose) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        if (areaCode != null) {
            map.put("choose", choose);
        }
        return commandCenterDao.getKeyWork(map);
    }

    /**
     * 重点工作模块 --土地扩展
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public KeyWorkLand getKeyWorkLand(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return commandCenterDao.getKeyWorkLand(map);
    }

    /**
     * 中间月收入模块 --月收入城市公司分布
     *
     * @param yearCode
     * @param monthCode
     * @return
     */
    @Override
    public List<MonCityCompanyDis> getMonCityCompanyDis(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return commandCenterDao.getMonCityCompanyDis(map);
    }

    @Override
    public List<KeyWorkLand> getInventory(String yearCode, String monthCode, String areaCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("areaCode", areaCode);
        return commandCenterDao.getInventory(map);
    }

    @Override
    public List<AllDataDetails> getProjectByAreaCode(String areaCode) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        if (areaCode != null && !areaCode.equals("")) {
            map.put("areaCode", areaCode);
        }
        return commandCenterDao.getProjectByAreaCode(map);
    }

}
