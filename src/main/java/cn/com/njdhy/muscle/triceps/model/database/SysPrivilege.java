
package cn.com.njdhy.muscle.triceps.model.database;

/**
 * <类功能简述>
 *
 * @author 胡志海
 */
public class SysPrivilege extends BaseModel {

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 权限关联菜单菜单名称
     */
    private String menuName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "SysPrivilege{" +
                "name='" + name + '\'' +
                ", perms='" + perms + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}
