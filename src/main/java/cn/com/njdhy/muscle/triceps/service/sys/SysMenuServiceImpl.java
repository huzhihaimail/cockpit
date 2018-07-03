
package cn.com.njdhy.muscle.triceps.service.sys;

import cn.com.njdhy.muscle.triceps.model.database.SysMenu;
import cn.com.njdhy.muscle.triceps.service.BaseServiceImpl;
import cn.com.njdhy.muscle.triceps.dao.SysMenuDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <类功能简述> 菜单业务层实现类
 *
 * @author 胡志海
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

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
        return dao.queryMenu();
    }
}
