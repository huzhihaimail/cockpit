
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.dao.SysRoleDao;
import cn.com.njdhy.muscle.triceps.dao.SysRoleMenuDao;
import cn.com.njdhy.muscle.triceps.model.database.SysRole;
import cn.com.njdhy.muscle.triceps.model.database.SysRoleMenu;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <类功能简述> 角色业务层实现类
 *
 * @author 胡志海
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Autowired
    protected SysRoleMenuDao roleMenuDao;

    @Override
    public List<SysRole> loadRoles(Map<String, Object> userName) {
        return dao.loadRoles(userName);
    }

    @Override
    public List<String> queryRolesByUserName(String userName) {

        Map<String, Object> query = new HashMap<>();
        query.put("userName", userName);

        return dao.queryRolesByUserName(query);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @Override
    public void insertRoleInfo(SysRole role) {

        try {
            //新增角色
            SysRole detail = new SysRole();
            detail.setName(role.getName());
            detail.setNameCn(role.getNameCn());
            detail.setStatus("0");
            this.dao.insert(detail);

            //新增角色菜單關聯表
            List<SysRoleMenu> list = new ArrayList<>();
            for (String menuId:role.getMenuIdList()){
                SysRoleMenu roleMenu = new SysRoleMenu();
                roleMenu.setRoleId(String.valueOf(detail.getId()));
                roleMenu.setMenuId(menuId);
                list.add(roleMenu);
            }
            roleMenuDao.batchInsert(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
