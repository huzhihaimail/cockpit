package cn.com.njdhy.muscle.triceps.controller.api;


import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ICityCenterDialogService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cherlin on 2018/6/14.
 */
@Api(value = "二级首页弹出框", description = "二级首页弹出框")
@RestController
@RequestMapping("/api/cityCenterDialog")
public class CityCenterDialogController extends BaseController {


    @Autowired
    private ICityCenterDialogService iCityCenterDialogService;


    @RequestMapping(path = "/getSixRateCityIndexOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页六率指标弹框月度趋势",
            notes = "二级首页六率指标弹框月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类型",required = true),
    })
    public HttpResult getSixRateCityIndexOfMonth(@RequestParam String yearCode, @RequestParam String areaCode,@RequestParam String type) {
        List<SixRateCityIndexForDialogOfMonth> list = iCityCenterDialogService.getSixRateCityIndexDialogOfMonth(yearCode, areaCode,type);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityBudgetRevenueDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页收入利润模块预算收入项目分布",
            notes = "二级首页收入利润模块预算收入项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityBudgetRevenueDialogOfMonth(@RequestParam String yearCode, @RequestParam String monthCode,@RequestParam String areaCode) {
        List<CityBudgetRevenue> list = iCityCenterDialogService.getCityBudgetRevenueDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityBudgetRevenueDialogOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页收入利润模块预算收入月度趋势",
            notes = "二级首页收入利润模块预算收入月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityBudgetRevenueDialogOfMonth(@RequestParam String yearCode, @RequestParam String areaCode) {
        List<CityBudgetRevenueOfMonth> list = iCityCenterDialogService.getCityBudgetRevenueDialogOfMonth(yearCode, areaCode);
        return new HttpResult(list);
    }


    @RequestMapping(path = "/getCityCarryOverProfitDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页收入利润模块结转利润项目分布",
            notes = "二级首页收入利润模块结转利润项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCarryOverProfitDialog(@RequestParam String yearCode,@RequestParam String monthCode, @RequestParam String areaCode) {
        List<CityCarryOverProfit> list = iCityCenterDialogService.getCityCarryOverProfitDialog(yearCode,monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityCarryOverProfitDialogOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页收入利润模块结转利润月度趋势",
            notes = "二级首页收入利润模块结转利润月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCarryOverProfitDialogOfMonth(@RequestParam String yearCode, @RequestParam String areaCode) {
        List<CityCarryOverProfitOfMonth> list = iCityCenterDialogService.getCityCarryOverProfitDialogOfMonth(yearCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityTaxSectionDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页收入利润模块节税项目分布",
            notes = "二级首页收入利润模块节税项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityTaxSectionDialog(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String areaCode) {
        List<CityTaxSection> list = iCityCenterDialogService.getCityTaxSectionDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityTaxSectionDialogOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页收入利润模块节税月度趋势",
            notes = "二级首页收入利润模块节税月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityTaxSectionDialogOfMonth(@RequestParam String yearCode, @RequestParam String areaCode) {
        List<CityTaxSectionOfMonth> list = iCityCenterDialogService.getCityTaxSectionDialogOfMonth(yearCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityCurrentSaleForSaleFinishDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页销售完成模块本月销售项目分布",
            notes = "二级首页销售完成模块本月销售项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCurrentSaleForSaleFinishDialog(@RequestParam String yearCode,@RequestParam String monthCode, @RequestParam String areaCode) {
        List<CityCurrentSaleXS> list = iCityCenterDialogService.getCityCurrentSaleForSaleFinishDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityCurrentSaleForSaleFinishDialogOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页销售完成模块本月销售月度趋势",
            notes = "二级首页销售完成模块本月销售月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCurrentSaleForSaleFinishDialogOfMonth(@RequestParam String yearCode,@RequestParam String areaCode) {
        List<CityCurrentSaleXSOfMonth> list = iCityCenterDialogService.getCityCurrentSaleForSaleFinishDialogOfMonth(yearCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityCurrentYearSaleForSaleFinishDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页销售完成模块本年销售项目分布",
            notes = "二级首页销售完成模块本年销售项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCurrentYearSaleForSaleFinishDialogOfMonth(@RequestParam String yearCode,@RequestParam String monthCode,@RequestParam String areaCode) {
        List<CityCurrentYearSaleXS> list = iCityCenterDialogService.getCityCurrentYearSaleForSaleFinishDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityCurrentSaleForHKDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页回款完成模块本月销售项目分布",
            notes = "二级首页回款完成模块本月销售项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCurrentSaleForHKDialog(@RequestParam String yearCode,@RequestParam String monthCode,@RequestParam String areaCode) {
        List<CityCurrentSaleHK> list = iCityCenterDialogService.getCityCurrentSaleForHKDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityCurrentSaleForHKDialogOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页回款完成模块本月销售月度趋势",
            notes = "二级首页回款完成模块本月销售月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCurrentSaleForHKDialogOfMonth(@RequestParam String yearCode,@RequestParam String areaCode) {
        List<CityCurrentSaleHKOfMonth> list = iCityCenterDialogService.getCityCurrentSaleForHKDialogOfMonth(yearCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityCurrentYearSaleForHKDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页回款完成模块本年销售项目分布",
            notes = "二级首页回款完成模块本年销售项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityCurrentYearSaleForHKDialog(@RequestParam String yearCode,@RequestParam String monthCode,@RequestParam String areaCode) {
        List<CityCurrentYearSaleHK> list = iCityCenterDialogService.getCityCurrentYearSaleForHKDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityFirstGradePlanDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页一级计划模块本月销售项目分布",
            notes = "二级首页一级计划模块本月销售项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityFirstGradePlanDialog(@RequestParam String yearCode,@RequestParam String monthCode,@RequestParam String areaCode) {
        List<CityFirstGradePlan> list = iCityCenterDialogService.getCityFirstGradePlanDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityFirstGradePlanDialogOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页一级计划模块本月销售月度趋势",
            notes = "二级首页一级计划模块本月销售月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityFirstGradePlanDialogOfMonth(@RequestParam String yearCode,@RequestParam String areaCode) {
        List<CityFirstGradePlanOfMonth> list = iCityCenterDialogService.getCityFirstGradePlanDialogOfMonth(yearCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityFirstGradePlanYearDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页一级计划模块本年销售项目分布",
            notes = "二级首页一级计划模块本年销售项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
    })
    public HttpResult getCityFirstGradePlanYearDialog(@RequestParam String yearCode,@RequestParam String monthCode,@RequestParam String areaCode) {
        List<CityFirstGradePlanYear> list = iCityCenterDialogService.getCityFirstGradePlanYearDialog(yearCode, monthCode, areaCode);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityKeyWorkDialog", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页重点工作模块-项目-项目分布",
            notes = "二级首页重点工作模块-项目-项目分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类型",required = true),
    })
    public HttpResult getCityKeyWorkDialog(@RequestParam String yearCode,@RequestParam String monthCode,@RequestParam String areaCode,@RequestParam String type) {
        List<CityKeyWorkForDialog> list = iCityCenterDialogService.getCityKeyWorkDialog(yearCode, monthCode, areaCode,type);
        return new HttpResult(list);
    }

    @RequestMapping(path = "/getCityKeyWorkDialogOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "二级首页重点工作模块-项目-月度趋势",
            notes = "二级首页重点工作模块-项目-月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "地区",required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类型",required = true),
    })
    public HttpResult getCityKeyWorkDialogOfMonth(@RequestParam String yearCode,@RequestParam String areaCode,@RequestParam String type) {
        List<CityKeyWorkForDialogOfMonth> list = iCityCenterDialogService.getCityKeyWorkDialogOfMonth(yearCode, areaCode,type);
        return new HttpResult(list);
    }
}