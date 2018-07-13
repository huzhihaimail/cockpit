package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.service.sys.SysDomainService;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import cn.com.njdhy.muscle.triceps.util.errorcode.OrgErrorCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/sys/domain")
public class SysDomainCtl {

    @Autowired
    private SysDomainService sysDomainService;


    @RequestMapping(path = "/doMainValue", method = RequestMethod.GET)
    @ApiOperation(
            value = "组织结构管理页面新增获取项目类型和项目阶段下拉框数据 ; 项目类型(doMainId = 5 & stId = 1) ; 项目阶段(doMainId = 6 & stId = 1)",
            notes = "组织结构管理页面新增获取项目类型和项目阶段下拉框数据 ; 项目类型(doMainId = 5 & stId = 1) ; 项目阶段(doMainId = 6 & stId = 1)",
            response = Result.class
    )
    public Result getDoMainValue(@RequestParam(value="doMainId") String doMainId,@RequestParam(value="stId") String stId) {

        List<String> doMainValueList = new ArrayList<String>();

        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("doMainId", doMainId);
            concurrentHashMap.put("stId", stId);
            doMainValueList = sysDomainService.getDomainValue(concurrentHashMap);
        } catch (RuntimeException e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }

        return Result.success().put("page", doMainValueList);
    }

}
