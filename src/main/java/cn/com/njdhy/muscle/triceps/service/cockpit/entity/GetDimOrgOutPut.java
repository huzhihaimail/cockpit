
package cn.com.njdhy.muscle.triceps.service.cockpit.entity;

import cn.com.njdhy.muscle.triceps.model.database.BaseModel;

/**
 * <类功能简述>获取所有城市信息输出参数
 *
 * @author 胡贤
 */
public class GetDimOrgOutPut {

    /**
     * 年月
     */
    private String yearMonth;
    /**
     * 城市公司编码
     */
    private String orgCode;

    /**
     * 城市公司名称
     */
    private String orgName;

    /**
     * 城市公司短名称
     */
    private String shortOrgName;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getShortOrgName() {
        return shortOrgName;
    }

    public void setShortOrgName(String shortOrgName) {
        this.shortOrgName = shortOrgName;
    }
}
