package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.service.sys.SysDomainService;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import cn.com.njdhy.muscle.triceps.util.errorcode.OrgErrorCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/sys/domain")
public class SysDomainCtl {

    @Autowired
    private SysDomainService sysDomainService;


    @RequestMapping(path = "/type", method = RequestMethod.GET)
    @ApiOperation(
            value = "组织结构管理页面新增获取项目类型下拉框数据",
            notes = "组织结构管理页面新增获取项目类型下拉框数据",
            response = Result.class
    )
    public Result getProjectType() {

        List<String> doMainValueList = new ArrayList<String>();

        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("doMainId", 5);
            concurrentHashMap.put("stId", 1);
            doMainValueList = sysDomainService.getDomainValue(concurrentHashMap);
        } catch (RuntimeException e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }

        return Result.success().put("page", doMainValueList);
    }

    @RequestMapping(path = "/stage", method = RequestMethod.GET)
    @ApiOperation(
            value = "组织结构管理页面新增获取项目阶段下拉框数据",
            notes = "组织结构管理页面新增获取项目阶段下拉框数据",
            response = Result.class
    )
    public Result getProjectStage() {

        List<String> doMainValueList = new ArrayList<String>();

        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("doMainId", 6);
            concurrentHashMap.put("stId", 1);
            doMainValueList = sysDomainService.getDomainValue(concurrentHashMap);
        } catch (RuntimeException e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }

        return Result.success().put("page", doMainValueList);
    }


}
