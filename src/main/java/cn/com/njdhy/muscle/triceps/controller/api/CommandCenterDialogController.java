package cn.com.njdhy.muscle.triceps.controller.api;


import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ICommandCenterDialogService;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cherlin on 2018/6/14.
 */
@Api(value = "指令中心弹出框", description = "指令中心弹出框")
@RestController
@RequestMapping("/api/commandCenterDialog")
public class CommandCenterDialogController extends BaseController {

    @Autowired
    private ICommandCenterDialogService iCommandCenterDialogService;

    @RequestMapping(path = "/getSixRateIndex", method = RequestMethod.GET)
    @ApiOperation(
            value = "查询六率指标",
            notes = "查询六率指标",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类别", required = true),
    })
    public HttpResult getSixRateIndexDialog(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String type) {
        List<SixRateIndexForDialog> sixRateIndexs = iCommandCenterDialogService.getSixRateIndexDialog(yearCode, monthCode, type);
        return new HttpResult(sixRateIndexs);
    }

    @RequestMapping(path = "/getSixRateIndexOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "查询六率指标 -月份趋势",
            notes = "查询六率指标 -月份趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类别", required = true),
    })
    public HttpResult getSixRateIndexOfMonth(@RequestParam String yearCode, @RequestParam String type) {
        List<SixRateIndexForDialogOfMonth> sixRateIndexsOfMonth = iCommandCenterDialogService.getSixRateIndexDialogOfMonth(yearCode, type);
        return new HttpResult(sixRateIndexsOfMonth);
    }

    @RequestMapping(path = "/getBudgetRevenue", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -预算收入",
            notes = "收入利润模块 -预算收入",
            response = HttpResult.class
    )
    public HttpResult getBudgetRevenueDialog(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                             @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode) {
        List<BudgetRevenue> budgetRevenues = iCommandCenterDialogService.getBudgetRevenueDialog(yearCode, monthCode);
        return new HttpResult(budgetRevenues);
    }

    @RequestMapping(path = "/getBudgetRevenueOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -预算收入 -月度趋势",
            notes = "收入利润模块 -预算收入 -月度趋势",
            response = HttpResult.class
    )
    public HttpResult getBudgetRevenueOfMonth(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode) {
        List<BudgetRevenueOfMonth> budgetRevenuesOfMonth = iCommandCenterDialogService.getBudgetRevenueDialogOfMonth(yearCode);
        return new HttpResult(budgetRevenuesOfMonth);
    }

    @RequestMapping(path = "/getCarryOverProfit", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -结转利润",
            notes = "收入利润模块 -结转利润",
            response = HttpResult.class
    )
    public HttpResult getCarryOverProfitDialog(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                               @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode) {
        List<CarryOverProfit> carryOverProfits = iCommandCenterDialogService.getCarryOverProfitDialog(yearCode, monthCode);
        return new HttpResult(carryOverProfits);
    }

    @RequestMapping(path = "/getCarryOverProfitOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -结转利润 -月度趋势",
            notes = "收入利润模块 -结转利润 -月度趋势",
            response = HttpResult.class
    )
    public HttpResult getCarryOverProfitDialogOfMonth(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode) {
        List<CarryOverProfitOfMonth> carryOverProfitsOfMonth = iCommandCenterDialogService.getCarryOverProfitDialogOfMonth(yearCode);
        return new HttpResult(carryOverProfitsOfMonth);
    }

    @RequestMapping(path = "/getTaxSection", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -节税",
            notes = "收入利润模块 -节税",
            response = HttpResult.class
    )
    public HttpResult getTaxSectionDialog(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                          @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode) {
        List<TaxSection> taxSections = iCommandCenterDialogService.getTaxSectionDialog(yearCode, monthCode);
        return new HttpResult(taxSections);
    }

    @RequestMapping(path = "/getTaxSectionOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -节税 -月度趋势",
            notes = "收入利润模块 -节税 -月度趋势",
            response = HttpResult.class
    )
    public HttpResult getTaxSectionDialogOfMonth(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode) {
        List<TaxSectionOfMonth> taxSectionsOfMonth = iCommandCenterDialogService.getTaxSectionDialogOfMonth(yearCode);
        return new HttpResult(taxSectionsOfMonth);
    }

    @RequestMapping(path = "/getCurrentSaleForSaleFinish", method = RequestMethod.GET)
    @ApiOperation(
            value = "销售完成模块 -本月／本年销售",
            notes = "销售完成模块 -本月／本年销售",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类别"),
    })
    public HttpResult getCurrentSaleForSaleFinishDialog(@RequestParam String yearCode, @RequestParam String monthCode, String type) {
        if (StringUtils.isEmpty(type))
            type = null;
        List<CurrentSaleXS> currentSales = iCommandCenterDialogService.getCurrentSaleForSaleFinishDialog(yearCode, monthCode, type);
        return new HttpResult(currentSales);
    }

    @RequestMapping(path = "/getCurrentSaleForSaleFinishOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "销售完成模块 -本月销售 -月度趋势",
            notes = "销售完成模块 -本月销售 -月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
    })
    public HttpResult getCurrentSaleForSaleFinishDialogOfMonth(@RequestParam String yearCode) {
        List<CurrentSaleXSOfMonth> currentSalesOfMonth = iCommandCenterDialogService.getCurrentSaleForSaleFinishDialogOfMonth(yearCode);
        return new HttpResult(currentSalesOfMonth);
    }

    @RequestMapping(path = "/getCurrentSaleForHK", method = RequestMethod.GET)
    @ApiOperation(
            value = "回款完成模块 -本月／本年销售",
            notes = "回款完成模块 -本月／本年销售",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类别"),
    })
    public HttpResult getCurrentSaleForHKDialog(@RequestParam String yearCode, @RequestParam String monthCode, String type) {
        if (StringUtils.isEmpty(type))
            type = null;
        List<CurrentSaleHK> currentSales = iCommandCenterDialogService.getCurrentSaleForHKDialog(yearCode, monthCode, type);
        return new HttpResult(currentSales);
    }

    @RequestMapping(path = "/getCurrentSaleForHKOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "回款完成模块 -本月销售 -月度趋势",
            notes = "回款完成模块 -本月销售 -月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true)
    })
    public HttpResult getCurrentSaleForHKDialogOfMonth(@RequestParam String yearCode) {
        List<CurrentSaleHKOfMonth> currentSalesOfMonth = iCommandCenterDialogService.getCurrentSaleForHKDialogOfMonth(yearCode);
        return new HttpResult(currentSalesOfMonth);
    }

    @RequestMapping(path = "/getFirstGradePlan", method = RequestMethod.GET)
    @ApiOperation(
            value = "一级计划模块 -本月／本年销售",
            notes = "一级计划模块 -本月／本年销售",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类别"),
    })
    public HttpResult getFirstGradePlanDialog(@RequestParam String yearCode, @RequestParam String monthCode, String type) {
        if (StringUtils.isEmpty(type))
            type = null;
        List<FirstGradePlan> currentSales = iCommandCenterDialogService.getFirstGradePlanDialog(yearCode, monthCode, type);
        return new HttpResult(currentSales);
    }

    @RequestMapping(path = "/getFirstGradePlanOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "一级计划模块 -本月销售 -月度趋势",
            notes = "一级计划模块 -本月销售 -月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true)
    })
    public HttpResult getFirstGradePlanDialogOfMonth(@RequestParam String yearCode) {
        List<FirstGradePlanOfMonth> currentSalesOfMonth = iCommandCenterDialogService.getFirstGradePlanDialogOfMonth(yearCode);
        return new HttpResult(currentSalesOfMonth);
    }

    @RequestMapping(path = "/getKeyWork", method = RequestMethod.GET)
    @ApiOperation(
            value = "重点工作模块 -重点工作完成率 -城市分布",
            notes = "重点工作模块 -重点工作完成率 -城市分布",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true)
    })
    public HttpResult getKeyWorkDialog(@RequestParam String yearCode, @RequestParam String monthCode) {
        List<KeyWorkForDialog> keyWorkForDialog = iCommandCenterDialogService.getKeyWorkDialog(yearCode, monthCode);
        return new HttpResult(keyWorkForDialog);
    }

    @RequestMapping(path = "/getKeyWorkOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "重点工作模块 -重点工作完成率 -月度趋势",
            notes = "重点工作模块 -重点工作完成率 -月度趋势",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true)
    })
    public HttpResult getKeyWorkDialogOfMonth(@RequestParam String yearCode) {
        List<KeyWorkForDialogOfMonth> keyWorkForDialogOfMonth = iCommandCenterDialogService.getKeyWorkDialogOfMonth(yearCode);
        return new HttpResult(keyWorkForDialogOfMonth);
    }

    @RequestMapping(path = "/getKeyWorkLand", method = RequestMethod.GET)
    @ApiOperation(
            value = "重点工作模块 -土地拓展完成率",
            notes = "重点工作模块 -土地拓展完成率",
            response = HttpResult.class
    )
    public HttpResult getKeyWorkLandDialog(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                           @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode) {
        List<KeyWorkLand> keyWorkLands = iCommandCenterDialogService.getKeyWorkLandDialog(yearCode, monthCode);
        return new HttpResult(keyWorkLands);
    }

    @RequestMapping(path = "/getKeyWorkLandOfMonth", method = RequestMethod.GET)
    @ApiOperation(
            value = "重点工作模块 -土地拓展完成率 -月度趋势",
            notes = "重点工作模块 -土地拓展完成率 -月度趋势",
            response = HttpResult.class
    )
    public HttpResult getKeyWorkLandDialogOfMonth(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode) {
        List<KeyWorkLandOfMonth> keyWorkLandsOfMonth = iCommandCenterDialogService.getKeyWorkLandDialogOfMonth(yearCode);
        return new HttpResult(keyWorkLandsOfMonth);
    }
}
