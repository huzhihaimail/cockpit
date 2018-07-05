package cn.com.njdhy.muscle.triceps.controller.api;


import cn.com.njdhy.muscle.triceps.model.database.ContractAmount;
import cn.com.njdhy.muscle.triceps.model.database.FourTotal;
import cn.com.njdhy.muscle.triceps.model.database.ProjectCost;
import cn.com.njdhy.muscle.triceps.service.cockpit.InvestManageService;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 投资管理
 * Created by cherlin on 2018/6/14.
 */
@Api(value = "投资管理", description = "投资管理")
@RestController
@RequestMapping("/api/investManage")
public class InvestManageController extends BaseController {
    @Autowired
    private InvestManageService investManageService;

    @RequestMapping(path = "/getInvestFourTotal", method = RequestMethod.GET)
    @ApiOperation(
            value = "投资管理第一块",
            notes = "投资管理第一块",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "orgCode", value = "组织编码")
    })
    public HttpResult getInvestFourTotal(@RequestParam String yearCode, @RequestParam String monthCode, String orgCode) {
        if (StringUtils.isEmpty(orgCode))
            orgCode = null;
        FourTotal fourTotal = investManageService.getInvestFourTotal(yearCode, monthCode, orgCode);
        return new HttpResult(fourTotal);
    }

    @RequestMapping(path = "/getProjectCost", method = RequestMethod.GET)
    @ApiOperation(
            value = "项目成本",
            notes = "项目成本",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类型"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "区域码"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目代码")
    })
    public HttpResult getProjectCost(@RequestParam String yearCode, @RequestParam String monthCode, String type, String areaCode, String projectCode) {
        List<ProjectCost> projectCosts = investManageService.getProjectCost(yearCode, monthCode, type, areaCode, projectCode);
        if (projectCode == null)
            return new HttpResult(projectCosts);
        else
            return new HttpResult(projectCosts.get(0));
    }

    @RequestMapping(path = "/getContractAmount", method = RequestMethod.GET)
    @ApiOperation(
            value = "合同金额",
            notes = "合同金额",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "区域码"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目编号")
    })
    public HttpResult getContractAmount(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode, String projectCode) {
        ContractAmount contractAmount = investManageService.getContractAmount(yearCode, monthCode, areaCode, projectCode);
        return new HttpResult(contractAmount);
    }

    @RequestMapping(path = "/getContractAmountOfCity", method = RequestMethod.GET)
    @ApiOperation(
            value = "合同金额城市分布",
            notes = "合同金额城市分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "区域码"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目编号")
    })
    public HttpResult getContractAmountOfCity(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode, String projectCode) {
        List<ContractAmount> contractAmounts = investManageService.getContractAmountOfCity(yearCode, monthCode, areaCode, projectCode);
        return new HttpResult(contractAmounts);
    }

}
