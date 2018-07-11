
package cn.com.njdhy.muscle.triceps.model.database;

/**
 * <类功能简述>
 *
 * @author 胡志海
 */
public class DimOrg extends BaseModel {

    /**
     * code
     */
    private String orgCode;

    /**
     * 组织机构名称
     */
    private String orgName;

    /**
     * 组织机构短名称
     */
    private String shortOrgName;

    /**
     * 组织机构父级code
     */
    private String pOrgCode;

    /**
     *
     */
    private String seqNum;

    /**
     *
     */
    private String orgLevel;

    /**
     * 状态
     */
    private int stId;

    /**
     * 年月
     */
    private String yearMonth;

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

    public String getpOrgCode() {
        return pOrgCode;
    }

    public void setpOrgCode(String pOrgCode) {
        this.pOrgCode = pOrgCode;
    }

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum;
    }

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }
}
