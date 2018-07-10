package cn.com.njdhy.muscle.triceps.controller.api;


import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ICommandCenterService;
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
 * Created by cherlin on 2018/6/13.
 */
@Api(value = "指令中心", description = "指令中心")
@RestController
@RequestMapping("/api/commandCenter")
public class CommandCenterController extends BaseController {

    @Autowired
    private ICommandCenterService iCommandCenterService;


    @RequestMapping(path = "/getAllData", method = RequestMethod.GET)
    @ApiOperation(
            value = "获取所有城市信息",
            notes = "获取所有城市信息",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月"),
    })
    public HttpResult getAllData(@RequestParam String yearCode,@RequestParam String monthCode) {
        List<AllDataDetails> allDataDetails = iCommandCenterService.getAllData(yearCode,monthCode);
        return new HttpResult(allDataDetails);
    }

    @RequestMapping(path = "/getProjectByAreaCode", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据城市公司code和年月查询项目",
            notes = "根据城市公司code和年月查询项目",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年月"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "年月")
    })
    public HttpResult getProjectByAreaCode(String areaCode,String yearCode,String monthCode) {
        List<AllDataDetails> allProjectDetails = iCommandCenterService.getProjectByAreaCode(yearCode,monthCode,areaCode);
        return new HttpResult(allProjectDetails);
    }

    @RequestMapping(path = "/getSixRateIndex", method = RequestMethod.GET)
    @ApiOperation(
            value = "查询六率指标",
            notes = "查询六率指标",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getSixRateIndex(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        SixRateIndex sixRateIndex = iCommandCenterService.getSixRateIndex(yearCode, monthCode, areaCode);
        return new HttpResult(sixRateIndex);
    }

    @RequestMapping(path = "/getBudgetRevenue", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -预算收入",
            notes = "收入利润模块 -预算收入",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getBudgetRevenue(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        BudgetRevenue budgetRevenue = iCommandCenterService.getBudgetRevenue(yearCode, monthCode, areaCode);
        return new HttpResult(budgetRevenue);
    }

    @RequestMapping(path = "/getCarryOverProfit", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -结转利润",
            notes = "收入利润模块 -结转利润",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getCarryOverProfit(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        CarryOverProfit carryOverProfit = iCommandCenterService.getCarryOverProfit(yearCode, monthCode, areaCode);
        return new HttpResult(carryOverProfit);
    }

    @RequestMapping(path = "/getTaxSection", method = RequestMethod.GET)
    @ApiOperation(
            value = "收入利润模块 -节税",
            notes = "收入利润模块 -节税",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getTaxSection(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        TaxSection taxSection = iCommandCenterService.getTaxSection(yearCode, monthCode, areaCode);
        return new HttpResult(taxSection);
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
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getCurrentSaleForSaleFinish(@RequestParam String yearCode, @RequestParam String monthCode, String type, String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        CurrentSaleXS currentSale = iCommandCenterService.getCurrentSaleForSaleFinish(yearCode, monthCode, type, areaCode);
        return new HttpResult(currentSale);
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
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getCurrentSaleForHK(@RequestParam String yearCode, @RequestParam String monthCode, String type, String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        CurrentSaleHK currentSale = iCommandCenterService.getCurrentSaleForHK(yearCode, monthCode, type, areaCode);
        return new HttpResult(currentSale);
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
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getFirstGradePlan(@RequestParam String yearCode, @RequestParam String monthCode, String type, String areaCode) {
        if (StringUtils.isEmpty(type))
            type = null;
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        FirstGradePlan currentSale = iCommandCenterService.getFirstGradePlan(yearCode, monthCode, type, areaCode);
        return new HttpResult(currentSale);
    }

    @RequestMapping(path = "/getKeyWork", method = RequestMethod.GET)
    @ApiOperation(
            value = "重点工作模块 -重点工作完成率",
            notes = "重点工作模块 -重点工作完成率",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "choose", value = "职能还是项目")
    })
    public HttpResult getKeyWork(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode, String choose) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        if (StringUtils.isEmpty(choose))
            choose = null;
        KeyWork keyWork = iCommandCenterService.getKeyWork(yearCode, monthCode, areaCode, choose);
        return new HttpResult(keyWork);
    }

    @RequestMapping(path = "/getKeyWorkLand", method = RequestMethod.GET)
    @ApiOperation(
            value = "重点工作模块 -土地拓展完成率",
            notes = "重点工作模块 -土地拓展完成率",
            response = HttpResult.class
    )
    public HttpResult getKeyWorkLand(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                     @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode) {
        KeyWorkLand keyWorkLands = iCommandCenterService.getKeyWorkLand(yearCode, monthCode);
        return new HttpResult(keyWorkLands);
    }

    @RequestMapping(path = "/getMonCityCompanyDis", method = RequestMethod.GET)
    @ApiOperation(
            value = "中间月收入模块 --月收入城市公司分布",
            notes = "中间月收入模块 --月收入城市公司分布",
            response = HttpResult.class
    )
    public HttpResult getMonCityCompanyDis(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                           @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode) {
        List<MonCityCompanyDis> monCityCompanyDis = iCommandCenterService.getMonCityCompanyDis(yearCode, monthCode);
        return new HttpResult(monCityCompanyDis);
    }

    @RequestMapping(path = "/getInventory", method = RequestMethod.GET)
    @ApiOperation(
            value = "库存",
            notes = "库存",
            response = HttpResult.class
    )
    public HttpResult getInventory(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                   @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode,
                                   @ApiParam(value = "城市公司编码", required = true) @RequestParam(value = "areaCode") String areaCode) {
        List<KeyWorkLand> monCityCompanyDis = iCommandCenterService.getInventory(yearCode, monthCode, areaCode);
        return new HttpResult(monCityCompanyDis);
    }

}
