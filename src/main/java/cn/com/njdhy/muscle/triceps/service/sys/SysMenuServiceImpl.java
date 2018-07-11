
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.SysRoleMenuDao;
import cn.com.njdhy.muscle.triceps.model.database.SysMenu;
import cn.com.njdhy.muscle.triceps.model.database.SysRole;
import cn.com.njdhy.muscle.triceps.model.database.SysRoleMenu;
import cn.com.njdhy.muscle.triceps.model.exception.ApplicationException;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import cn.com.njdhy.muscle.triceps.dao.SysMenuDao;
import cn.com.njdhy.muscle.triceps.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <类功能简述> 菜单业务层实现类
 *
 * @author 胡志海
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Autowired
    protected SysRoleMenuDao sysRoleMenuDao;

    @Override
    public List<SysMenu> loadMenus(String userName) {
        return dao.loadMenus(userName);
    }

    /**
     * 查询一级和二级菜单
     * @return
     */
    @Override
    public List<SysMenu> queryMenu() {
        return dao.queryMenu();
    }

    /**
     * 查詢所有菜單
     * @return
     */
    @Override
    public List<SysMenu> queryAllMenu() {
        return dao.queryAllMenu();
    }

    @Override
    public List<String> queryMenuByRole(String roleId) {
        try {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            List<SysRoleMenu> roleMenuList = sysRoleMenuDao.queryMenuByRole(roleMenu);

            List<String> menuList = new ArrayList<>();
            if (!EmptyUtils.isEmpty(roleMenuList)){
                for (SysRoleMenu detail:roleMenuList){
                    menuList.add(detail.getMenuId());
                }
            }
            return menuList;
        } catch (ApplicationException e) {
            throw new ApplicationException("根据角色查询菜单失败");
        }
    }
}
