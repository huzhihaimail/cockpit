
package cn.com.njdhy.muscle.triceps.model.database;

/**
 * <类功能简述> 系统菜单实体
 *
 * @author 胡志海
 */
public class MenuInfo extends BaseModel {

    /**
     * 父级菜单ID
     */
    private String parentId;


    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单跳转页面
     */
    private String url;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单排序
     */
    private String orderNum;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
