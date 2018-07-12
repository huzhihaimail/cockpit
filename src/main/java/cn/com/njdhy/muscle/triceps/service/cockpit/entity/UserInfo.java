
package cn.com.njdhy.muscle.triceps.service.cockpit.entity;

import cn.com.njdhy.muscle.triceps.model.database.BaseModel;

import java.util.List;

/**
 * <类功能简述>
 *
 * @author 胡志海
 */
public class UserInfo {

    /**
     * 用户等级
     */
    private String userLevel;

    /**
     *菜单列表
     */
    private List<MenuInfo> menuList;

    public List<MenuInfo> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuInfo> menuList) {
        this.menuList = menuList;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
}
