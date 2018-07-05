package cn.com.njdhy.muscle.triceps.controller.api;

import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.IPlanOperaService;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 计划运营
 * Created by cherlin on 2018/6/15.
 */
@Api(value = "计划运营", description = "计划运营")
@RestController
@RequestMapping("/api/planOpera")
public class PlanOperaController extends BaseController {

    @Autowired
    private IPlanOperaService iPlanOperaService;

    @RequestMapping(path = "/getFourRate", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-仪表盘",
            notes = "计划运营-仪表盘",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市公司编码")
    })
    public HttpResult getFourRate(@RequestParam String yearCode, @RequestParam String monthCode, String cityCode) {
        FourRate fourRate = iPlanOperaService.getFourRate(yearCode, monthCode, cityCode);
        return new HttpResult(fourRate);
    }

    @RequestMapping(path = "/getMonthDetailPlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-一层-一级明细页面-月度",
            notes = "计划运营-一层-一级明细页面-月度",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true)
    })
    public HttpResult getMonthDetailPlan(@RequestParam String yearCode, @RequestParam String monthCode) {
        List<DetailPlan> detailPlans = iPlanOperaService.getMonthDetailPlan(yearCode, monthCode);
        return new HttpResult(detailPlans);
    }

    @RequestMapping(path = "/getYearDetailPlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-一层-一级明细页面-年度",
            notes = "计划运营-一层-一级明细页面-年度",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true)
    })
    public HttpResult getYearDetailPlan(@RequestParam String yearCode, @RequestParam String monthCode) {
        List<DetailPlan> detailPlans = iPlanOperaService.getYearDetailPlan(yearCode, monthCode);
        return new HttpResult(detailPlans);
    }

    @RequestMapping(path = "/getSecLayerMonthDetailPlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-二层-明细页面-月度",
            notes = "计划运营-二层-明细页面-月度",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编码", required = true)
    })
    public HttpResult getSecLayerMonthDetailPlan(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String cityCode) {
        List<DetailPlan> detailPlan = iPlanOperaService.getSecLayerMonthDetailPlan(yearCode, monthCode, cityCode);
        return new HttpResult(detailPlan);
    }

    @RequestMapping(path = "/getSecLayerYearDetailPlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-二层-明细页面-年度",
            notes = "计划运营-二层-明细页面-年度",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编码", required = true)
    })
    public HttpResult getSecLayerYearDetailPlan(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String cityCode) {
        List<DetailPlan> detailPlan = iPlanOperaService.getSecLayerMonthDetailPlan(yearCode, monthCode, cityCode);
        return new HttpResult(detailPlan);
    }


    @RequestMapping(path = "/getMilestoneWarning", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-三层-里程碑预警",
            notes = "计划运营-三层-里程碑预警",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目代码", required = true)
    })
    public HttpResult getMilestoneWarning(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String cityCode, @RequestParam String projectCode) {
        List<MilestoneWarning> milestoneWarning = iPlanOperaService.getMilestoneWarning(yearCode, monthCode, cityCode, projectCode);
        return new HttpResult(milestoneWarning);
    }

    @RequestMapping(path = "/getOneLevelPlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-三层-一级计划",
            notes = "计划运营-三层-一级计划",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目代码", required = true)
    })
    public HttpResult getOneLevelPlan(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String cityCode, @RequestParam String projectCode) {
        OneLevelPlan oneLevelPlan = iPlanOperaService.getOneLevelPlan(yearCode, monthCode, cityCode, projectCode);
        return new HttpResult(oneLevelPlan);
    }


    @RequestMapping(path = "/getTwoLevelPlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-三层-二级计划",
            notes = "计划运营-三层-二级计划",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目代码", required = true)
    })
    public HttpResult getTwoLevelPlan(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String cityCode, @RequestParam String projectCode) {
        TwoLevelPlan twoLevelPlan = iPlanOperaService.getTwoLevelPlan(yearCode, monthCode, cityCode, projectCode);
        return new HttpResult(twoLevelPlan);
    }

    @RequestMapping(path = "/getTrdLayerDetailPlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-三层-明细页面",
            notes = "计划运营-三层-明细页面",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目代码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "lineType", value = "专业线"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "node", value = "等级")
    })
    public HttpResult getTrdLayerDetailPlan(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String cityCode,
                                            @RequestParam String projectCode, String lineType, String node) {

        List<ThirdLayerDetailPlan> thirdLayerDetailPlan = iPlanOperaService.getTrdLayerDetailPlan(yearCode, monthCode, cityCode, projectCode, lineType, node);
        return new HttpResult(thirdLayerDetailPlan);
    }


    @RequestMapping(path = "/getProfessionalLinePlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "计划运营-三层-专业线计划",
            notes = "计划运营-三层-专业线计划",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目代码", required = true)
    })
    public HttpResult getProfessionalLinePlan(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String cityCode, @RequestParam String projectCode) {
        List<ProfessionalLinePlan> professionalLinePlan = iPlanOperaService.getProfessionalLinePlan(yearCode, monthCode, cityCode, projectCode);
        return new HttpResult(professionalLinePlan);
    }

    @RequestMapping(path = "/getAllLevel", method = RequestMethod.GET)
    @ApiOperation(
            value = "获取所有等级",
            notes = "获取所有等级",
            response = HttpResult.class
    )
    public HttpResult getAllLevel() {
        List<SysDomain> levelList = iPlanOperaService.getAllLevel();
        return new HttpResult(levelList);
    }

    @RequestMapping(path = "/getAllLine", method = RequestMethod.GET)
    @ApiOperation(
            value = "获取所有专业线",
            notes = "获取所有专业线",
            response = HttpResult.class
    )
    public HttpResult getAllLine() {
        List<SysDomain> lineList = iPlanOperaService.getAllLine();
        return new HttpResult(lineList);
    }

}
