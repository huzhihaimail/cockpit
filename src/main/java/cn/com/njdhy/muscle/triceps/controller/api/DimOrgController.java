package cn.com.njdhy.muscle.triceps.controller.api;

import cn.com.njdhy.muscle.triceps.model.database.DimOrg;
import cn.com.njdhy.muscle.triceps.service.cockpit.dim.DimOrgService;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/api/dimorg")
public class DimOrgController {

    @Autowired
    private DimOrgService dimOrgService;

    @RequestMapping(path = "/cityName", method = RequestMethod.GET)
    @ApiOperation(
            value = "组织结构管理页面新增获取城市公司名称下拉框数据",
            notes = "组织结构管理页面新增获取城市公司名称下拉框数据",
            response = HttpResult.class
    )
    public HttpResult getCityName() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("orgLevel","C");
        concurrentHashMap.put("stId",1);
        List<DimOrg> list = dimOrgService.queryList(concurrentHashMap);
        return new HttpResult(list);
    }

}


