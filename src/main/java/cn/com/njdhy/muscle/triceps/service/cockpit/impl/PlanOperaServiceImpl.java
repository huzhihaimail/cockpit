package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import cn.com.njdhy.muscle.triceps.dao.PlanOperaDao;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.IPlanOperaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/15.
 */
@Service
public class PlanOperaServiceImpl extends BaseServiceImpl implements IPlanOperaService {

    @Autowired
    private PlanOperaDao planOperaDao;

    @Override
    public FourRate getFourRate(String yearCode, String monthCode, String cityCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        if (cityCode != null)
            map.put("cityCode", cityCode);
        return planOperaDao.getFourRate(map);
    }


    /**
     * 一层明细页面-月度
     *
     * @param yearCode  年份
     * @param monthCode 月份
     * @return 明细查询结果
     */
    public List<DetailPlan> getMonthDetailPlan(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return planOperaDao.getMonthDetailPlan(map);
    }

    /**
     * 一层明细页面-年度
     *
     * @param yearCode  年份
     * @param monthCode 月份
     * @return 年份数据
     */

    @Override
    public List<DetailPlan> getYearDetailPlan(String yearCode, String monthCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        return planOperaDao.getYearDetailPlan(map);
    }

    @Override
    public List<DetailPlan> getSecLayerMonthDetailPlan(String yearCode, String monthCode, String cityCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("cityCode", cityCode);
        return planOperaDao.getSecLayerMonthDetailPlan(map);
    }

    @Override
    public List<DetailPlan> getSecLayerYearDetailPlan(String yearCode, String monthCode, String cityCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("cityCode", cityCode);
        return planOperaDao.getSecLayerYearDetailPlan(map);
    }

    @Override
    public List<MilestoneWarning> getMilestoneWarning(String yearCode, String monthCode, String cityCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("cityCode", cityCode);
        map.put("projectCode", projectCode);
        return planOperaDao.getMilestoneWarning(map);
    }

    @Override
    public OneLevelPlan getOneLevelPlan(String yearCode, String monthCode, String cityCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("cityCode", cityCode);
        map.put("projectCode", projectCode);
        return planOperaDao.getOneLevelPlan(map);
    }

    @Override
    public TwoLevelPlan getTwoLevelPlan(String yearCode, String monthCode, String cityCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("cityCode", cityCode);
        map.put("projectCode", projectCode);
        return planOperaDao.getTwoLevelPlan(map);
    }

    @Override
    public List<ProfessionalLinePlan> getProfessionalLinePlan(String yearCode, String monthCode, String cityCode, String projectCode) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("cityCode", cityCode);
        map.put("projectCode", projectCode);
        return planOperaDao.getProfessionalLinePlan(map);
    }

    @Override
    public List<ThirdLayerDetailPlan> getTrdLayerDetailPlan(String yearCode, String monthCode, String cityCode, String projectCode, String lineType, String nodeType) {
        ConcurrentHashMap map = getUnionMap(yearCode, monthCode);
        map.put("cityCode", cityCode);
        map.put("projectCode", projectCode);
        if (lineType != null && !lineType.equals("")) {
            map.put("lineType", lineType);
        }
        if (nodeType != null && !nodeType.equals("")) {
            map.put("nodeType", nodeType);
        }
        return planOperaDao.getTrdLayerDetailPlan(map);
    }

    @Override
    public List<SysDomain> getAllLevel() {
        return planOperaDao.getAllLevel();
    }

    @Override
    public List<SysDomain> getAllLine() {
        return planOperaDao.getAllLine();
    }

}
