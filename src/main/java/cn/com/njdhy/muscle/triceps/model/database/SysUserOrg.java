
package cn.com.njdhy.muscle.triceps.model.database;

import java.util.Date;

/**
 * <类功能简述> 用户角色关联实体
 *
 * @author 胡志海
 */
public class SysUserOrg extends BaseModel {

    /**
     *
     */
    private String employeeId;

    /**
     *
     */
    private String orgCode;

    /**
     *
     */
    private int stId;

    /**
     * 创建人
     */
    private int createUser;

    /**
     * 创建时间
     */
    private Date createDate;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
