
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.Application;
import cn.com.njdhy.muscle.triceps.dao.SysUserDao;
import cn.com.njdhy.muscle.triceps.dao.SysUserOrgDao;
import cn.com.njdhy.muscle.triceps.dao.SysUserRoleDao;
import cn.com.njdhy.muscle.triceps.model.database.SysUser;
import cn.com.njdhy.muscle.triceps.model.database.SysUserOrg;
import cn.com.njdhy.muscle.triceps.model.database.SysUserRole;
import cn.com.njdhy.muscle.triceps.model.exception.ApplicationException;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import cn.com.njdhy.muscle.triceps.util.ShiroUtil;
import org.apache.shiro.codec.CodecException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.UnknownAlgorithmException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <类功能简述> 用户角色业务层实现类
 *
 * @author 胡志海
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private SysUserOrgDao sysUserOrgDao;

    /**
     * 插入用户
     *
     * @param sysUser 用户信息（包含角色信息）
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public void saveUser(SysUser sysUser) {

        try {
            // 获取密码盐
            String salt = new SecureRandomNumberGenerator().nextBytes(3).toHex();
            sysUser.setSalt(salt);

            // 获取密码
            String pwd = new SimpleHash("md5", sysUser.getPassword(), sysUser.getUserName() + salt, 3).toHex();
            sysUser.setPassword(pwd);

            // 用户信息入库
            dao.insert(sysUser);

            List<SysUserRole> sysUserRolesLst = new ArrayList<>();

            // 获取角色信息
            List<String> roles = sysUser.getUserRoles();
            // 获取用户ID
            String userId = String.valueOf(sysUser.getId());

            for (String roleId : roles) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(userId);
                sysUserRole.setRoleId(roleId);
                sysUserRolesLst.add(sysUserRole);
            }

            // 用户配置角色信息入库
            sysUserRoleService.batchInsert(sysUserRolesLst);

            //用户配置组织机构
            List<String> orgList = sysUser.getOrgIdList();
            List<SysUserOrg> userOrgList = new ArrayList<>();
            //用户配置的组织机构不为空
            if (!EmptyUtils.isEmpty(orgList)) {
                for (String orgId : orgList) {
                    SysUserOrg userOrg = new SysUserOrg();
                    userOrg.setEmployeeId(userId);
                    userOrg.setOrgCode(orgId);
                    userOrg.setStId(1);
                    userOrg.setCreateDate(new Date());
                    userOrg.setCreateUser(ShiroUtil.getUserId());
                    userOrgList.add(userOrg);
                }

                sysUserOrgDao.batchInsert(userOrgList);
            }

        } catch (ApplicationException e) {
            throw new ApplicationException("新增用户失败");
        }


    }

    /**
     * 根据用户id查询用户信息和角色信息(修改用户时用)
     *
     * @param sysUser
     * @return
     */
    @Override
    public SysUser queryUserInfo(SysUser sysUser) {

        try {
            SysUser user = this.dao.queryById(String.valueOf(sysUser.getId()));
            List<SysUserRole> userRoleList = sysUserRoleDao.queryRoleByUserId(String.valueOf(sysUser.getId()));
            List<String> rolesList = new ArrayList<>();
            if (!EmptyUtils.isEmpty(userRoleList)) {
                for (SysUserRole userRole : userRoleList) {
                    rolesList.add(userRole.getRoleId());
                }
            }
            user.setRolesList(rolesList);
            return user;
        } catch (ApplicationException e) {
            throw new ApplicationException("根据用户id查询用户信息失败");
        }
    }

    /**
     * 初始化密码
     *
     * @param sysUser
     */
    @Override
    public void initPassword(SysUser sysUser) {
        try {

            //根据用户id查询用户名
            SysUser user = this.dao.queryById(String.valueOf(sysUser.getId()));
            // 获取密码盐
            String salt = new SecureRandomNumberGenerator().nextBytes(3).toHex();
            sysUser.setSalt(salt);
            sysUser.setPassword("111111");
            sysUser.setStatus(1);
            // 获取密码
            String pwd = new SimpleHash("md5", sysUser.getPassword(), user.getUserName() + salt, 3).toHex();
            sysUser.setPassword(pwd);

            this.dao.update(sysUser);
        } catch (ApplicationException e) {
            throw new ApplicationException("密码初始化失败");
        }
    }

    /**
     * 初始化密码
     *
     * @param sysUser
     */
    @Override
    public void updateUser(SysUser sysUser) {
        try {
            //修改用户信息
            this.dao.update(sysUser);
            //删除用户角色关联信息
            List<String> userList = new ArrayList<>();
            userList.add(String.valueOf(sysUser.getId()));
            sysUserRoleDao.deleteByIds(userList);

            //重新增加用户角色关联信息
            List<SysUserRole> sysUserRolesLst = new ArrayList<>();

            // 获取角色信息
            List<String> roles = sysUser.getUserRoles();
            // 获取用户ID
            String userId = String.valueOf(sysUser.getId());

            if (!EmptyUtils.isEmpty(roles)) {
                for (String roleId : roles) {
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setUserId(userId);
                    sysUserRole.setRoleId(roleId);
                    sysUserRolesLst.add(sysUserRole);
                }
                // 用户配置角色信息入库
                sysUserRoleService.batchInsert(sysUserRolesLst);
            }

            //删除用户城市配置信息
            int id = sysUser.getId();
            ConcurrentHashMap map = new ConcurrentHashMap();
            if (!EmptyUtils.isEmpty(id)){
                map.put("id",id);
                sysUserOrgDao.deleteUserOrgByUserId(map);
            }

            //重新增加用户城市配置信息
            List<String> orgList = sysUser.getOrgIdList();
            List<SysUserOrg> userOrgList = new ArrayList<>();
            //用户配置的组织机构不为空
            if (!EmptyUtils.isEmpty(orgList)) {
                for (String orgId : orgList) {
                    SysUserOrg userOrg = new SysUserOrg();
                    userOrg.setEmployeeId(userId);
                    userOrg.setOrgCode(orgId);
                    userOrg.setStId(1);
                    userOrg.setCreateDate(new Date());
                    userOrg.setCreateUser(ShiroUtil.getUserId());
                    userOrgList.add(userOrg);
                }

                sysUserOrgDao.batchInsert(userOrgList);
            }


        } catch (ApplicationException e) {
            throw new ApplicationException("修改用户失败");
        }
    }


}
