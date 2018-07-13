package cn.com.njdhy.muscle.triceps.service.cockpit.impl;

import cn.com.njdhy.muscle.triceps.dao.SysMenuDao;
import cn.com.njdhy.muscle.triceps.dao.SysRoleDao;
import cn.com.njdhy.muscle.triceps.dao.SysUserDao;
import cn.com.njdhy.muscle.triceps.model.database.*;
import cn.com.njdhy.muscle.triceps.service.cockpit.UserService;
import cn.com.njdhy.muscle.triceps.service.cockpit.entity.MenuInfo;
import cn.com.njdhy.muscle.triceps.service.cockpit.entity.UserDetail;
import cn.com.njdhy.muscle.triceps.service.cockpit.entity.UserInfo;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
     * @return
     */
    @Override
    public UserInfo queryFirstLevelMenu(String userName) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("userName", userName);

        UserInfo info = new UserInfo();
        SysUser sysUser = this.sysUserDao.queryByName(userName);
        if (!EmptyUtils.isEmpty(sysUser)){
            info.setUserLevel(sysUser.getUserLevel());
        }
        //查询该用户拥有的菜单
        List<MenuInfo> menuInfoList = new ArrayList<>();
        List<SysMenu> menuList = sysMenuDao.queryFirstLevelMenu(map);

        if (!EmptyUtils.isEmpty(menuList)){
            for (SysMenu menu:menuList){
                MenuInfo menuInfo = new MenuInfo();
                menuInfo.setId(menu.getId());
                menuInfo.setName(menu.getName());
                menuInfo.setUrl(menu.getUrl());
                menuInfo.setIcon(menu.getIcon());
                menuInfo.setOrderNum(menu.getOrderNum());
                menuInfo.setParentId(menu.getParentId());
                menuInfoList.add(menuInfo);
            }
            info.setMenuList(menuInfoList);
        }
        return info;
    }

    /**
     * 根据一级菜单查询二级菜单提供给前端
     * @param userName
     * @param menuId
     * @return
     */
    @Override
    public UserInfo querySecondLevelMenuByFirstLevel(String userName, String menuId) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("userName", userName);
        map.put("menuId", menuId);
        //查询该用户拥有的菜单
        UserInfo userInfo = new UserInfo();
        List<MenuInfo> menuInfoList = new ArrayList<>();
        List<SysMenu> menuList = sysMenuDao.querySecondLevelMenuByFirstLevel(map);

        if (!EmptyUtils.isEmpty(menuList)){
            for (SysMenu menu:menuList){
                MenuInfo menuInfo = new MenuInfo();
                menuInfo.setId(menu.getId());
                menuInfo.setName(menu.getName());
                menuInfo.setUrl(menu.getUrl());
                menuInfo.setIcon(menu.getIcon());
                menuInfo.setOrderNum(menu.getOrderNum());
                menuInfo.setParentId(menu.getParentId());
                menuInfoList.add(menuInfo);
            }
            userInfo.setMenuList(menuInfoList);
        }
        return userInfo;
    }

    /**
     * 用户用户等级
     * @param userName
     * @return
     */
    @Override
    public UserInfo queryByUserName(String userName) {
        UserInfo info = new UserInfo();
        SysUser sysUser = this.sysUserDao.queryByName(userName);
        if (!EmptyUtils.isEmpty(sysUser)){
            info.setUserLevel(sysUser.getUserLevel());
        }
        String parentName = null;
        ConcurrentHashMap map = new ConcurrentHashMap();
        if (sysUser.getUserLevel().equals("1")){
            parentName = "集团";
        }else if (sysUser.getUserLevel().equals("2")){
            parentName = "分公司";
        }else if (sysUser.getUserLevel().equals("3")){
            parentName = "项目";
        }
        map.put("userName", userName);
        map.put("parentName", parentName);
        List<MenuInfo> menuInfoList = new ArrayList<>();
        List<SysMenu> menuList = sysMenuDao.queryChildMenuByParentName(map);
        if (!EmptyUtils.isEmpty(menuList)){
            for (SysMenu menu:menuList){
                MenuInfo menuInfo = new MenuInfo();
                menuInfo.setId(menu.getId());
                menuInfo.setName(menu.getName());
                menuInfo.setUrl(menu.getUrl());
                menuInfo.setParentId(menu.getParentId());
                menuInfo.setOrderNum(menu.getOrderNum());
                menuInfo.setIcon(menu.getIcon());
                menuInfoList.add(menuInfo);
            }
            info.setMenuList(menuInfoList);
        }
        return info;
    }
}
