
package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.model.database.SysOrg;
import cn.com.njdhy.muscle.triceps.model.database.SysUserOrg;
import cn.com.njdhy.muscle.triceps.model.database.ZTree;
import cn.com.njdhy.muscle.triceps.service.sys.SysOrgService;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import cn.com.njdhy.muscle.triceps.util.common.HttpResult;
import cn.com.njdhy.muscle.triceps.util.errorcode.OrgErrorCode;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <类功能简述> 首页控制器
 *
 * @author 胡志海
 */
@RestController()
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
            if (!EmptyUtils.isEmpty(orgList)) {
                for (SysOrg org : orgList) {
                    ZTree tree = new ZTree();
                    tree.setMenuId(org.getOrgCode());
                    tree.setParentId(org.getpOrgCode());
                    tree.setName(org.getOrgName());
                    treeList.add(tree);
                }
            }
        } catch (RuntimeException e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }
        return Result.success().put("model", treeList);
    }

    /**
     * 修改页面加载组织机构树控件
     *
     * @return
     */
    @RequestMapping("/queryOrgTreeForUpdateUser")
    public Result queryOrgTreeForUpdateUser(@RequestParam String id) {

        List<ZTree> treeList = new ArrayList<>();
        try {
            //查询列表数据
            List<SysOrg> orgList = sysOrgService.queryOrgTreeForUser();

            //根据用户id查询该用户所在哪些城市公司
            List<SysUserOrg> userOrgList = sysOrgService.queryOrgListByUserId(id);
            List<String> orgIdList = new ArrayList<>();
            for (SysUserOrg userOrg : userOrgList) {
                orgIdList.add(userOrg.getOrgCode());
            }

            if (!EmptyUtils.isEmpty(orgList)) {
                if (!EmptyUtils.isEmpty(userOrgList)) {
                    for (SysOrg org : orgList) {
                        if (orgIdList.contains(org.getOrgCode())) {
                            ZTree tree = new ZTree();
                            tree.setMenuId(org.getOrgCode());
                            tree.setParentId(org.getpOrgCode());
                            tree.setName(org.getOrgName());
                            tree.setChecked(true);
                            treeList.add(tree);
                        } else {
                            ZTree tree = new ZTree();
                            tree.setMenuId(org.getOrgCode());
                            tree.setParentId(org.getpOrgCode());
                            tree.setName(org.getOrgName());
                            tree.setChecked(false);
                            treeList.add(tree);
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }
        return Result.success().put("model", treeList);
    }


    @RequestMapping(path = "/cityName", method = RequestMethod.GET)
    @ApiOperation(
            value = "组织结构管理页面新增获取城市公司名称下拉框数据",
            notes = "组织结构管理页面新增获取城市公司名称下拉框数据",
            response = HttpResult.class
    )
    public Result getCityName() {

        List<SysOrg> sysOrgLst = new ArrayList<>();

        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("orgLevel", "C");
            concurrentHashMap.put("stId", 1);
            sysOrgLst = sysOrgService.queryListForProjMapping(concurrentHashMap);
        } catch (RuntimeException e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, OrgErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }

        return Result.success().put("page", sysOrgLst);
    }

}
