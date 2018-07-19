package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.service.sys.DataCenterService;
import cn.com.njdhy.muscle.triceps.service.sys.DataCenterServiceImpl;
import cn.com.njdhy.muscle.triceps.util.errorcode.OrgErrorCode;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Richard.li
 * @Description  数据中心
 * @Date 2018/7/18
 **/
@RestController
@RequestMapping("/sys/dataCenter")
public class DataCenterCtl {

    @Autowired
    private DataCenterService dataCenterService;

    @RequestMapping(path = "/tableName", method = RequestMethod.GET)
    @ApiOperation(
            value = "查询数据库所有的表名",
            notes = "查询数据库所有的表名",
            response = Result.class
    )
    public Result selectAllTableName() {

        List<String> tableNameList = new ArrayList<String>();
        try {
            tableNameList = dataCenterService.selectAllTableName();
        } catch (RuntimeException e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }

        return Result.success().put("name", tableNameList);
    }


    @RequestMapping(path = "/colums", method = RequestMethod.GET)
    @ApiOperation(
            value = "获取Bootstrap-table的表头信息",
            notes = "获取Bootstrap-table的表头信息",
            response = Result.class
    )
    public Result getColumns() {
        JSONArray columnsArray = new JSONArray();
        JSONObject columsJson = new JSONObject();
        columsJson.put("field","cityName");
        columsJson.put("title","城市名称");
        columsJson.put("width","20%");
        columnsArray.add(columsJson);
        return Result.success().put("columns", columnsArray);
    }


    @RequestMapping("/list")
    public Result index(@RequestParam String tableName, Integer pageNumber, Integer pageSize) {
        PageInfo<Map<String,Object>> result = dataCenterService.selectDataByTableName(tableName,pageNumber,pageSize);
        return Result.success(result.getTotal(), result.getList());
    }

}
