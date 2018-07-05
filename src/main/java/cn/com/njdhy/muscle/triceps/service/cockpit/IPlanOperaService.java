package cn.com.njdhy.muscle.triceps.service.cockpit;

import cn.com.njdhy.muscle.triceps.model.database.*;

import java.util.List;

/**
 * Created by cherlin on 2018/6/15.
 */
public interface IPlanOperaService {
    FourRate getFourRate(String yearCode, String monthCode, String cityCode);

    /**
     * 计划运营-一层-一级明细页面-月度
     *
     * @param yearCode  年份
     * @param monthCode 月份
     * @return 运营计划
     */
    List<DetailPlan> getMonthDetailPlan(String yearCode, String monthCode);

    /**
     * 计划运营-一层-一级明细页面-年度
     *
     * @param yearCode  年份
     * @param monthCode 月份
     * @return 运行计划
     */
    List<DetailPlan> getYearDetailPlan(String yearCode, String monthCode);

    /**
     * 计划运营-二层-明细页面-月度
     *
     * @param yearCode  年份
     * @param monthCode 月份
     * @param cityCode  城市代码
     * @return 运行计划
     */
    List<DetailPlan> getSecLayerMonthDetailPlan(String yearCode, String monthCode, String cityCode);

    /**
     * 计划运营-二层-明细页面-年度
     *
     * @param yearCode
     * @param monthCode
     * @param cityCode
     * @return 运营计划
     */
    List<DetailPlan> getSecLayerYearDetailPlan(String yearCode, String monthCode, String cityCode);

    /**
     * 计划运营-三层-里程碑预警
     *
     * @param yearCode    年份
     * @param monthCode   月份
     * @param cityCode    城市代码
     * @param projectCode 项目代码
     * @return 预警信息
     */
    List<MilestoneWarning> getMilestoneWarning(String yearCode, String monthCode, String cityCode, String projectCode);

    /**
     * 计划运营-三层-一级计划
     *
     * @param yearCode    年份
     * @param monthCode   月份
     * @param cityCode    城市代码
     * @param projectCode 产品代码
     * @return 一级计划信息
     */
    OneLevelPlan getOneLevelPlan(String yearCode, String monthCode, String cityCode, String projectCode);

    /**
     * 计划运营-三层-二级计划
     *
     * @param yearCode    年份
     * @param monthCode   月份
     * @param cityCode    城市代码
     * @param projectCode 产品代码
     * @return 一级计划信息
     */
    TwoLevelPlan getTwoLevelPlan(String yearCode, String monthCode, String cityCode, String projectCode);

    /**
     * 计划运营-三层-专业线计划
     *
     * @param yearCode    年份
     * @param monthCode   月份
     * @param cityCode    城市代码
     * @param projectCode 产品代码
     * @return 一级计划信息
     */
    List<ProfessionalLinePlan> getProfessionalLinePlan(String yearCode, String monthCode, String cityCode, String projectCode);


    /**
     * 计划运营-三层-明细页面
     *
     * @param yearCode    年份
     * @param monthCode   月份
     * @param cityCode    城市代码
     * @param projectCode 产品代码
     * @return 明细页面
     */
    List<ThirdLayerDetailPlan> getTrdLayerDetailPlan(String yearCode, String monthCode, String cityCode, String projectCode, String lineType, String noteType);

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
