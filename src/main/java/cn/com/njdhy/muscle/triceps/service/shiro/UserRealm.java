

package cn.com.njdhy.muscle.triceps.service.shiro;

import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import cn.com.njdhy.muscle.triceps.service.sys.SysPrivilegeService;
import cn.com.njdhy.muscle.triceps.service.sys.SysRoleService;
import cn.com.njdhy.muscle.triceps.service.sys.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <一句话功能简述> 用户身份认证和授权
 * <功能详细描述>
 *
 * @author 胡志海
 * @version V0.0.1-SNAPSHOT
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //获取登录时输入的用户名  
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        String loginName = user.getUserName();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //用户角色授权
        addRole(loginName, info);
        //用户权限授权
        addPrivileges(loginName, info);

        return info;
    }

    /**
     * 用户身份认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取前台用户输入的用户名和密码
        String userName = String.valueOf(token.getPrincipal());

        // 用户为空
        if (StringUtils.isEmpty(userName)) {
            throw new UnknownAccountException();
        }

        //查询用户信息
        SysUser user = this.sysUserService.queryByName(userName);

        //账号不存在
        if (user == null) {
            throw new UnknownAccountException();
        }

        // 角色已被禁用
        if (user.getStatus() == 0) {
            throw new LockedAccountException();
        }

        //若存在，将此用户存放到登录认证中进行密码匹配
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getUserName() + user.getSalt()), getName());
    }

    /**
     * 函数功能描述：根据用户名查询权限
     *
     * @param loginName 登录用户名
     * @param info      对象
     */
    private void addPrivileges(String loginName, SimpleAuthorizationInfo info) {
        List<String> privilegesLst = sysPrivilegeService.queryPrivilegesByUserName(loginName);
        //用户角色列表
        Set<String> privileges = new HashSet<String>();

        for (String perm : privilegesLst) {
            if (StringUtils.isEmpty(perm)) {
                continue;
            }
            privileges.addAll(Arrays.asList(perm.trim().split(",")));
        }

        info.setStringPermissions(privileges);
    }

    /**
     * 函数功能描述：用户角色授权
     *
     * @param loginName 登录名称
     * @param info      对象
     */
    private void addRole(String loginName, SimpleAuthorizationInfo info) {
        List<String> RoleList = sysRoleService.queryRolesByUserName(loginName);
        //用户角色列表
        Set<String> RoleSet = new HashSet<String>();
        for (String role : RoleList) {
            if (StringUtils.isEmpty(role)) {
                continue;
            }
            RoleSet.addAll(Arrays.asList(role.trim().split(",")));
        }

        info.setRoles(RoleSet);
    }
}
