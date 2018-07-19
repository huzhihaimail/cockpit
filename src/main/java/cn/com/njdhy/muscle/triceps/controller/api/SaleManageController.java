package cn.com.njdhy.muscle.triceps.controller.api;

import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.ISaleManageService;
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
 * 销售管理
 * Created by cherlin on 2018/6/14.
 */
@Api(value = "销售管理", description = "销售管理")
@RestController
@RequestMapping("/api/saleManage")
public class SaleManageController extends BaseController {

    @Autowired
    private ISaleManageService saleManageService;

    @RequestMapping(path = "/getSaleAndReturn", method = RequestMethod.GET)
    @ApiOperation(
            value = "查询销售和回款",
            notes = "查询销售和回款",
            response = HttpResult.class
    )
    public HttpResult getSaleAndReturn(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                       @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode,
                                       @ApiParam(value = "城市公司编码") String areaCode,
                                       @ApiParam(value = "项目编码") String projectCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        if (StringUtils.isEmpty(projectCode))
            projectCode = null;
        SaleAndReturn saleAndReturn = saleManageService.getSaleAndReturn(yearCode, monthCode, areaCode, projectCode);
        return new HttpResult(saleAndReturn);
    }

    @RequestMapping(path = "/getCityComDis", method = RequestMethod.GET)
    @ApiOperation(
            value = "销售模块",
            notes = "销售模块",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码")
    })
    public HttpResult getCityComDis(@RequestParam String yearCode, @RequestParam String monthCode, String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        List<CityComDis> cityComDis = saleManageService.getCityComDis(yearCode, monthCode, areaCode);
        return new HttpResult(cityComDis);
    }

    @RequestMapping(path = "/getCityComDisRe", method = RequestMethod.GET)
    @ApiOperation(
            value = "回款模块",
            notes = "回款模块",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码"),
    })
    public HttpResult getCityComDisRe(@RequestParam String yearCode,@RequestParam String monthCode,String areaCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        List<CityComDisRe> cityComDisRe = saleManageService.getCityComDisRe(yearCode, monthCode, areaCode);
        return new HttpResult(cityComDisRe);
    }

    @RequestMapping(path = "/getCityComDisDe", method = RequestMethod.GET)
    @ApiOperation(
            value = "去化率模块",
            notes = "去化率模块",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目编码"),
    })
    public HttpResult getCityComDisDe(@RequestParam String yearCode,@RequestParam String monthCode,String areaCode,String projectCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        if (StringUtils.isEmpty(projectCode))
            projectCode = null;
        List<CityComDisDe> cityComDisDe = saleManageService.getCityComDisDe(yearCode, monthCode, areaCode, projectCode);
        if (projectCode == null) {
            return new HttpResult(cityComDisDe);
        } else {
            return new HttpResult(cityComDisDe.get(0));
        }
    }

    @RequestMapping(path = "/getGoodsValueDis", method = RequestMethod.GET)
    @ApiOperation(
            value = "货值分布模块",
            notes = "货值分布模块",
            response = HttpResult.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "yearCode", value = "年（yyyy）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "monthCode", value = "月（M）", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "choose", value = "选项", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "areaCode", value = "城市公司编码"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目编码")
    })
    public HttpResult getGoodsValueDis(@RequestParam String yearCode, @RequestParam String monthCode, @RequestParam String choose, String areaCode, String projectCode) {
        if (StringUtils.isEmpty(areaCode))
            areaCode = null;
        if (StringUtils.isEmpty(projectCode))
            projectCode = null;
        List<GoodsValueDis> goodsValueDis = saleManageService.getGoodsValueDis(yearCode, monthCode, choose, areaCode, projectCode);
        return new HttpResult(goodsValueDis);
    }

    @RequestMapping(path = "/getAgencySubscribeUp", method = RequestMethod.GET)
    @ApiOperation(
            value = "签约和认购上图",
            notes = "签约和认购上图",
            response = HttpResult.class
    )
    public HttpResult getAgencySubscribeUp(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                           @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode,
                                           @ApiParam(value = "城市公司编码", required = true) @RequestParam(value = "areaCode") String areaCode,
                                           @ApiParam(value = "项目编码", required = true) @RequestParam(value = "projectCode") String projectCode) {
        List<AgencySubscribeUp> agencySubscribeUp = saleManageService.getAgencyAndSubscribeUp(yearCode, monthCode, areaCode, projectCode);
        return new HttpResult(agencySubscribeUp);
    }

    @RequestMapping(path = "/getAgencySubscribeDo", method = RequestMethod.GET)
    @ApiOperation(
            value = "签约和认购下图",
            notes = "签约和认购下图",
            response = HttpResult.class
    )
    public HttpResult getAgencySubscribeDo(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                           @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode,
                                           @ApiParam(value = "城市公司编码", required = true) @RequestParam(value = "areaCode") String areaCode,
                                           @ApiParam(value = "项目编码", required = true) @RequestParam(value = "projectCode") String projectCode) {
        AgencySubscribeDown agencyAndSubscribe = saleManageService.getAgencyAndSubscribeDown(yearCode, monthCode, areaCode, projectCode);
        return new HttpResult(agencyAndSubscribe);
    }


    @RequestMapping(path = "/getBusinessDisUp", method = RequestMethod.GET)
    @ApiOperation(
            value = "业态分布上图",
            notes = "业态分布上图",
            response = HttpResult.class
    )
    public HttpResult getBusinessDisUp(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                       @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode,
                                       @ApiParam(value = "城市公司编码", required = true) @RequestParam(value = "areaCode") String areaCode,
                                       @ApiParam(value = "项目编码", required = true) @RequestParam(value = "projectCode") String projectCode) {
        List<BusinessDisUp> businessDisUp = saleManageService.getBusinessDisUp(yearCode, monthCode, areaCode, projectCode);
        return new HttpResult(businessDisUp);
    }

    @RequestMapping(path = "/getBusinessDisDo", method = RequestMethod.GET)
    @ApiOperation(
            value = "业态分布下图",
            notes = "业态分布下图",
            response = HttpResult.class
    )
    public HttpResult getBusinessDisDo(@ApiParam(value = "年（yyyy）", required = true) @RequestParam(value = "yearCode") String yearCode,
                                       @ApiParam(value = "月（M）", required = true) @RequestParam(value = "monthCode") String monthCode,
                                       @ApiParam(value = "城市公司编码", required = true) @RequestParam(value = "areaCode") String areaCode,
                                       @ApiParam(value = "项目编码", required = true) @RequestParam(value = "projectCode") String projectCode) {
        BusinessDisDown businessDisDown = saleManageService.getBusinessDisDown(yearCode, monthCode, areaCode, projectCode);
        return new HttpResult(businessDisDown);
    }

}
