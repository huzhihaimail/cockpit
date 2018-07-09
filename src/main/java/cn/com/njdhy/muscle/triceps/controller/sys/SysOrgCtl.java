
package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.sys.SysOrgService;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import cn.com.njdhy.muscle.triceps.util.errorcode.UserErrorCode;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <类功能简述> 首页控制器
 *
 * @author 胡志海
 */
@RestController
@RequestMapping("/sys/org")
public class SysOrgCtl {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysOrgCtl.class);

    @Autowired
    private SysOrgService sysOrgService;

    /**
     * 加载组织机构树控件
     *
     * @return
     */
    @RequestMapping("/queryOrgTreeForUser")
    public Result queryOrgTreeForUser() {

        List<ZTree> treeList = new ArrayList<>();
        try {
            //查询列表数据
            List<SysOrg> orgList = sysOrgService.queryOrgTreeForUser();
            if (!EmptyUtils.isEmpty(orgList)){
                for (SysOrg org:orgList){
                    ZTree tree = new ZTree();
                    tree.setMenuId(org.getOrgCode());
                    tree.setParentId(org.getpOrgCode());
                    tree.setName(org.getOrgName());
                    treeList.add(tree);
                }
            }
        } catch (RuntimeException e) {
            return Result.error(UserErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, UserErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, UserErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }
        return Result.success().put("model",treeList );
    }


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
        List<SysOrg> list = sysOrgService.queryListForProjMapping(concurrentHashMap);
        return new HttpResult(list);
    }

}
