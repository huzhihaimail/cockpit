package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import cn.com.njdhy.muscle.triceps.dao.SysMenuDao;
import cn.com.njdhy.muscle.triceps.dao.SysRoleDao;
import cn.com.njdhy.muscle.triceps.dao.SysUserDao;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.UserService;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cherlin on 2018/6/14.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    /**
     * 查询菜单提供给前端
     *
     * @param userName
     * @param position
     * @return
     */
    @Override
    public UserInfo queryMenuForHaiHang(String userName, String position) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("userName", userName);
        map.put("position", position);
        //查询该用户拥有的菜单
        UserInfo userInfo = new UserInfo();
        List<MenuInfo> menuInfoList = new ArrayList<>();
        List<SysMenu> menuList = sysMenuDao.queryMenuForHaiHang(map);
        if (!EmptyUtils.isEmpty(menuList)) {
            for (SysMenu menu : menuList) {
                MenuInfo detail = new MenuInfo();
                detail.setId(menu.getId());
                detail.setParentId(menu.getParentId());
                detail.setIcon(menu.getIcon());
                detail.setName(menu.getName());
                detail.setOrderNum(menu.getOrderNum());
                detail.setUrl(menu.getUrl());
                menuInfoList.add(detail);
            }
        }
        userInfo.setMenuList(menuInfoList);
        //查询该用户的基本信息
        SysUser sysUser = sysUserDao.queryByName(userName);
        if (!EmptyUtils.isEmpty(sysUser)){
            userInfo.setId(sysUser.getId());
            userInfo.setUserName(sysUser.getUserName());
            userInfo.setNickName(sysUser.getNickName());
            userInfo.setEmail(sysUser.getEmail());
            userInfo.setMobile(sysUser.getMobile());
        }

        //查询该用户的角色信息
        SysRole role = sysRoleDao.queryRoleByUserName(userName);
        if (!EmptyUtils.isEmpty(role)){
            userInfo.setId(role.getId());
            userInfo.setRoleName(role.getName());
        }

        return userInfo;
    }
}
