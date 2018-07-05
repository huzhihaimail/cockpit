
package cn.com.njdhy.muscle.triceps.dao;

import cn.com.njdhy.muscle.triceps.model.database.SysRoleMenu;
import cn.com.njdhy.muscle.triceps.model.database.SysUserRole;

import java.util.List;

/**
 * <类功能简述> 角色菜单关联
 *
 * @author 胡志海
 */
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu> {

    /**
     * 根据roleId查询该用户所有的菜单
     * @param roleMenu
     * @return
     */
    List<SysRoleMenu> queryMenuByRole(SysRoleMenu roleMenu);

}
