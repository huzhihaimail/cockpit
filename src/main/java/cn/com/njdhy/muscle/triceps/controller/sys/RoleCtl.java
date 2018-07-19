
package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Query;
import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import cn.com.njdhy.muscle.triceps.model.database.SysUserRole;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import com.github.pagehelper.PageInfo;
import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.model.database.SysRole;
import cn.com.njdhy.muscle.triceps.model.exception.ApplicationException;
import cn.com.njdhy.muscle.triceps.service.sys.SysRoleService;
import cn.com.njdhy.muscle.triceps.util.errorcode.RoleErrorCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 角色控制器
 *
 * @author 胡志海
 */
@RestController
@RequestMapping("/sys/role")
public class RoleCtl {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleCtl.class);

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询角色列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 角色列表
     */
    @RequestMapping("/list")
    public Result index(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {

        try {
            Query queryParam = new Query(params);
            PageInfo<SysRole> result = sysRoleService.queryList(queryParam, pageNumber, pageSize);

            return Result.success(result.getTotal(), result.getList());

        } catch (ApplicationException e) {
            return Result.error(RoleErrorCode.SYS_ROLE_QUERY_APP_ERROR_CODE, RoleErrorCode.SYS_ROLE_QUERY_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(RoleErrorCode.SYS_ROLE_QUERY_ERROR_CODE, RoleErrorCode.SYS_ROLE_QUERY_ERROR_MESSAGE);
        }
    }

    /**
     * 根据id查询角色信息
     *
     * @param id 角色ID
     * @return 角色实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {

        try {
            //校验参数
            if (EmptyUtils.isEmpty(id)){
                return Result.error("500","请选择角色后再查询信息");
            }
            SysRole model = sysRoleService.queryById(id);

            if (ObjectUtils.isEmpty(model)) {
                model = new SysRole();
            }

            return Result.success().put("model", model);
        } catch (ApplicationException e) {
            return Result.error(RoleErrorCode.SYS_ROLE_QUERY_APP_ERROR_CODE, RoleErrorCode.SYS_ROLE_QUERY_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(RoleErrorCode.SYS_ROLE_QUERY_ERROR_CODE, RoleErrorCode.SYS_ROLE_QUERY_ERROR_MESSAGE);
        }
    }

    /**
     * 保存
     *
     * @param sysRole 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    @RequiresPermissions("sys:role:add")
    public Result insert(@RequestBody SysRole sysRole) {

        try {
            // 校验参数
            if (EmptyUtils.isEmpty(sysRole.getName())){
                return Result.error("500","请输入角色名称");
            }
            // 执行入库操作
            sysRoleService.insertRoleInfo(sysRole);
        } catch (ApplicationException e) {
            return Result.error(RoleErrorCode.SYS_ROLE_SAVE_APP_ERROR_CODE, RoleErrorCode.SYS_ROLE_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(RoleErrorCode.SYS_ROLE_SAVE_ERROR_CODE, RoleErrorCode.SYS_ROLE_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param sysRole 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public Result update(@RequestBody SysRole sysRole) {

        try {
            // 校验参数
            if (EmptyUtils.isEmpty(sysRole.getId())){
                return Result.error("500","请选择一条数据再进行修改");
            }

            // 执行修改
            sysRoleService.updateRoleInfo(sysRole);
        } catch (ApplicationException e) {
            return Result.error(RoleErrorCode.SYS_ROLE_QUERY_APP_ERROR_CODE, RoleErrorCode.SYS_ROLE_QUERY_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(RoleErrorCode.SYS_ROLE_QUERY_ERROR_CODE, RoleErrorCode.SYS_ROLE_QUERY_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            // 校验参数
            if (EmptyUtils.isEmpty(ids)){
                return Result.error("500","请选择角色再进行删除");
            }
            List<SysUserRole> list = sysRoleService.queryByRoleId(ids.get(0));
            if (!EmptyUtils.isEmpty(list)){
                return Result.error("500","角色已被占用，不能删除");
            }
            sysRoleService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(RoleErrorCode.SYS_ROLE_DELETE_APP_ERROR_CODE, RoleErrorCode.SYS_ROLE_DELETE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(RoleErrorCode.SYS_ROLE_DELETE_ERROR_CODE, RoleErrorCode.SYS_ROLE_DELETE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 校验角色名是否重复
     * @param roleName
     * @return
     */
    @RequestMapping("/queryRoleInfoByRoleName")
    public Result queryRoleInfoByRoleName(String roleName) {

        try {
            if (EmptyUtils.isEmpty(roleName)){
                return Result.error("500","角色名不能为空");
            }
            SysRole role = sysRoleService.queryByName(roleName);
            if (EmptyUtils.isEmpty(role)){
                return Result.success();
            }else{
                return Result.error("角色名已重复");
            }
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
