
package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Query;
import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.model.exception.ApplicationException;
import cn.com.njdhy.muscle.triceps.service.sys.DimOrgService;
import cn.com.njdhy.muscle.triceps.service.sys.SysRoleService;
import cn.com.njdhy.muscle.triceps.service.sys.SysUserService;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import cn.com.njdhy.muscle.triceps.util.ShiroUtil;
import cn.com.njdhy.muscle.triceps.util.errorcode.UserErrorCode;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 首页控制器
 *
 * @author 胡志海
 */
@RestController
@RequestMapping("/sys/org")
public class DimOrgCtl {

    private static final Logger LOGGER = LoggerFactory.getLogger(DimOrgCtl.class);

    @Autowired
    private DimOrgService dimOrgService;

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
            List<DimOrg> orgList = dimOrgService.queryOrgTreeForUser();
            if (!EmptyUtils.isEmpty(orgList)){
                for (DimOrg org:orgList){
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

}
