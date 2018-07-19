
package cn.com.njdhy.muscle.triceps.controller.sys;

import cn.com.njdhy.muscle.triceps.model.common.Query;
import cn.com.njdhy.muscle.triceps.model.common.Result;
import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import cn.com.njdhy.muscle.triceps.model.exception.ApplicationException;
import cn.com.njdhy.muscle.triceps.service.sys.SysUserService;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import cn.com.njdhy.muscle.triceps.util.ShiroUtil;
import cn.com.njdhy.muscle.triceps.util.errorcode.RoleErrorCode;
import com.github.pagehelper.PageInfo;
import cn.com.njdhy.muscle.triceps.model.database.SysRole;
import cn.com.njdhy.muscle.triceps.service.sys.SysRoleService;
import cn.com.njdhy.muscle.triceps.util.errorcode.UserErrorCode;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 首页控制器
 *
 * @author 胡志海
 */
@RestController
@RequestMapping("/sys/user")
public class UserCtl {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCtl.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询用户列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result index(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        Query queryParam = new Query(params);
        PageInfo<SysUser> result = sysUserService.queryList(queryParam, pageNumber, pageSize);

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {
        SysUser model = new SysUser();
        try {
            if (EmptyUtils.isEmpty(id)){
                return Result.error("500","请选择id后再查询用户信息");
            }
            SysUser user = new SysUser();
            user.setId(Integer.valueOf(id));
            model = sysUserService.queryUserInfo(user);

            if (ObjectUtils.isEmpty(model)) {
                model = new SysUser();
            }
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_QUERY_INFO_APP_ERROR_CODE, UserErrorCode.SYS_USER_QUERY_INFO_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_QUERY_INFO_ERROR_CODE,UserErrorCode.SYS_USER_QUERY_INFO_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param sysUser 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    @RequiresPermissions("sys:user:add")
    public Result insert(@RequestBody SysUser sysUser) {

        try {
            // 校验参数
            if (EmptyUtils.isEmpty(sysUser.getUserName())){
                return Result.error("500","请输入用户名");
            }
            if (EmptyUtils.isEmpty(sysUser.getPassword())){
                return Result.error("500","请输入密码");
            }
            // 执行入库操作
            sysUserService.saveUser(sysUser);
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_SAVE_APP_ERROR_CODE, UserErrorCode.SYS_USER_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(UserErrorCode.SYS_USER_SAVE_ERROR_CODE, UserErrorCode.SYS_USER_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param sysUser 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public Result update(@RequestBody SysUser sysUser) {

        try {
            // 校验参数
            if (EmptyUtils.isEmpty(sysUser.getId())){
                return Result.error("500","请选择好用户后再进行修改");
            }

            // 执行修改
            sysUserService.updateUser(sysUser);
        } catch (RuntimeException e) {
            return Result.error(UserErrorCode.SYS_USER_UPDATE_APP_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_UPDATE_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_ERROR_MESSAGE);
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
    @RequiresPermissions("sys:user:delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            //校验参数
            if (EmptyUtils.isEmpty(ids)){
                return Result.error("500","请选择用户再进行删除");
            }
            //执行删除
            sysUserService.deleteByIds(ids);
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }

    /**
     * 校验用户名是否重复
     * @param userName
     * @return
     */
    @RequestMapping("/queryUserInfoByUserName")
    public Result queryUserInfoByUserName(String userName) {

        try {
            if (EmptyUtils.isEmpty(userName)){
                return Result.error("500","用户名不能为空");
            }
            SysUser user = sysUserService.queryByName(userName);
            if (EmptyUtils.isEmpty(user)){
                return Result.success();
            }else{
                return Result.error("用户名已重复");
            }
        } catch (ApplicationException e) {
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 加载角色列表
     *
     * @return
     */
    @RequestMapping("/loadRoles")
    public Result loadRoles() {

        try {
            // 获取登用户名
            String loginUserName = ShiroUtil.getLoginUserName();

            // 设置查询参数
            Map<String, Object> params = new HashMap<>();
            params.put("userName", loginUserName);

            Query query = new Query(params);

            List<SysRole> rolesLst = sysRoleService.loadRoles(query);
            return Result.success().put("page", rolesLst);
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_CODE, UserErrorCode.SYS_USER_LOAD_ROLES_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_LOAD_ROLES_ERROR_CODE, UserErrorCode.SYS_USER_LOAD_ROLES_ERROR_MESSAGE);
        }
    }

    /**
     * 初始化密码
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/initPassword")
    @RequiresPermissions("sys:user:initPassword")
    public Result initPassword(@RequestBody List<String> ids) {

        try {
            if (EmptyUtils.isEmpty(ids)){
                return Result.error("500","请选择用户在进行密码重置");
            }
            SysUser user = new SysUser();
            user.setId(Integer.valueOf(ids.get(0)));
            // 执行修改
            sysUserService.initPassword(user);
        } catch (ApplicationException e) {
            return Result.error(UserErrorCode.SYS_USER_UPDATE_APP_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            return Result.error(UserErrorCode.SYS_USER_UPDATE_ERROR_CODE, UserErrorCode.SYS_USER_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }
}
