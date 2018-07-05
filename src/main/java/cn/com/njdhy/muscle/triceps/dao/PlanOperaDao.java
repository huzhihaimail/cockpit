package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/15.
 */
public interface PlanOperaDao {

    FourRate getFourRate(ConcurrentHashMap map);

    /**
     * 明细页面-月度
     *
     * @param map 查询参数
     * @return 查询结果
     */
    List<DetailPlan> getMonthDetailPlan(ConcurrentHashMap map);

    /**
     * 明细页面-年度
     *
     * @param map 查询参数
     * @return 查询结果
     */
    List<DetailPlan> getYearDetailPlan(ConcurrentHashMap map);

    /**
     * 二层-明细页面-月度
     *
     * @param map 查询参数
     * @return 查询结果
     */
    List<DetailPlan> getSecLayerMonthDetailPlan(ConcurrentHashMap map);

    /**
     * 二层-明细页面-年度
     *
     * @param map 查询参数
     * @return 查询结果
     */
    List<DetailPlan> getSecLayerYearDetailPlan(ConcurrentHashMap map);

    /**
     * 三层-里程碑预警
     *
     * @param map 查询参数
     * @return 查询结果
     */
    List<MilestoneWarning> getMilestoneWarning(ConcurrentHashMap map);

    /**
     * 计划运营-三层-一级计划
     *
     * @param map 查询参数
     * @return 查询结果
     */
    OneLevelPlan getOneLevelPlan(ConcurrentHashMap map);

    /**
     * 计划运营-三层-二级计划
     *
     * @param map 查询参数
     * @return 查询结果
     */
    TwoLevelPlan getTwoLevelPlan(ConcurrentHashMap map);

    /**
     * 计划运营-三层-二级计划
     *
     * @param map 查询参数
     * @return 查询结果
     */
    List<ProfessionalLinePlan> getProfessionalLinePlan(ConcurrentHashMap map);


    /**
     * 计划运营-三层-明细页面
     *
     * @param map 查询参数
     * @return 查询结果
     */
    List<ThirdLayerDetailPlan> getTrdLayerDetailPlan(ConcurrentHashMap map);

    /**
     * 查询所有等级值
     *
     * @return
     */
    List<SysDomain> getAllLevel();

    /**
     * 查询所有专业线
     *
     * @return
     */
    List<SysDomain> getAllLine();

}
