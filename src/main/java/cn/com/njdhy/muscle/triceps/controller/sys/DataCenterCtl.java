package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.service.sys.DataCenterService;
import cn.com.njdhy.muscle.triceps.util.ExportExcelUtil;
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

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
            value = "获取Bootstrap-table的表头信息，用于组装VUE的columns",
            notes = "获取Bootstrap-table的表头信息，用于组装VUE的columns",
            response = Result.class
    )
    public Result getColumns(@RequestParam String tableName) {

        //TODO 先选择sys_role 带有ID字段的来测试
        List<Map<String,Object>> lists =  dataCenterService.selectColumnsAndNotes(tableName);
        JSONArray columnsArray = new JSONArray();
        lists.forEach( map -> {
            String columnName = (String) map.get("column_name");
            String columnDescription = (String) map.get("column_description");
            JSONObject columsJson = new JSONObject();
            columsJson.put("field",columnName);
            columsJson.put("title",columnDescription);
            columsJson.put("width","20%");
            columnsArray.add(columsJson);
        });

        return Result.success().put("columns", columnsArray);
    }


    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据表名分页查询表的数据",
            notes = "根据表名分页查询表的数据",
            response = Result.class
    )
    public Result index(@RequestParam String tableName, Integer pageNumber, Integer pageSize) {
        PageInfo<Map<String,Object>> result = dataCenterService.selectDataByTableName(tableName,pageNumber,pageSize);
        return Result.success(result.getTotal(), result.getList());
    }


    @RequestMapping(path = "/export", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据表名导出表的数据",
            notes = "根据表名导出表的数据"
    )
    public void export(@RequestParam String tableName, HttpServletResponse response) throws IOException {
        List<String> listColums = dataCenterService.selectColumns(tableName);
        List<Map<String,Object>> dataLists = dataCenterService.selectDataByTableName(tableName);
        String name =  tableName + ".xls";
        response.addHeader("Content-Disposition",
                "attachment;filename=" + new String(name.getBytes("UTF-8"), "ISO8859-1"));
        response.setContentType("application/octet-stream");
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        ExportExcelUtil.exportExcel(dataLists, listColums, response.getOutputStream());
        toClient.flush();
        response.getOutputStream().close();
    }

}
