package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import cn.com.njdhy.muscle.triceps.dao.InvestManageDao;
import cn.com.njdhy.muscle.triceps.model.database.ContractAmount;
import cn.com.njdhy.muscle.triceps.model.database.FourTotal;
import cn.com.njdhy.muscle.triceps.model.database.ProjectCost;
import cn.com.njdhy.muscle.triceps.service.cockpit.InvestManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/15.
 */
@Service
public class InvestManageServiceImpl extends BaseServiceImpl implements InvestManageService {

    @Autowired
    private InvestManageDao investManageDao;

    /**
     * 投资管理第一块四个数据那个
     *
     * @param yearCode
     * @param monthCode
     * @param orgCode
     * @return
     */
    @Override
    public FourTotal getInvestFourTotal(String yearCode, String monthCode, String orgCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (orgCode != null)
            map.put("orgCode", orgCode);
        return investManageDao.getInvestFourTotal(map);
    }

    /**
     * 项目成本
     *
     * @param yearCode
     * @param monthCode
     * @param type      left:左边的，right:右边的
     * @param areaCode  区域码
     * @return
     */
    @Override
    public List<ProjectCost> getProjectCost(String yearCode, String monthCode, String type, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (type != null) {
            map.put("type", type);
        }
        if (areaCode != null)
            map.put("areaCode", areaCode);
        if (projectCode != null)
            map.put("projectCode", projectCode);
        return investManageDao.getProjectCost(map);
    }

    /**
     * 合同金额
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public ContractAmount getContractAmount(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        if (projectCode != null)
            map.put("projectCode", projectCode);
        return investManageDao.getContractAmount(map);
    }

    /**
     * 合同金额城市分布
     *
     * @param yearCode
     * @param monthCode
     * @param areaCode
     * @return
     */
    @Override
    public List<ContractAmount> getContractAmountOfCity(String yearCode, String monthCode, String areaCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (areaCode != null) {
            map.put("areaCode", areaCode);
        }
        if (projectCode != null)
            map.put("projectCode", projectCode);
        return investManageDao.getContractAmountOfCity(map);
    }
}
