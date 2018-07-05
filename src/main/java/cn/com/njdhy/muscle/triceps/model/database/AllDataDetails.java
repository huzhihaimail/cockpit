package cn.com.njdhy.muscle.triceps.model.database;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/20.
 */
@ApiModel
public class AllDataDetails {
    @ApiModelProperty(value = "月份",example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "集团编码",example = "集团编码")
    private String orgCode;
    @ApiModelProperty(value = "集团名称",example = "集团名称")
    private String orgName;
    @ApiModelProperty(value = "集团短名称",example = "集团短名称")
    private String shortOrgName;
    @ApiModelProperty(value = "城市公司编码",example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称",example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "城市公司短名称",example = "城市公司短名称")
    private String shortAreaName;
    @ApiModelProperty(value = "项目编码",example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称",example = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "项目短名称",example = "项目短名称")
    private String shortProjectName;

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getShortAreaName() {
        return shortAreaName;
    }

    public void setShortAreaName(String shortAreaName) {
        this.shortAreaName = shortAreaName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getShortProjectName() {
        return shortProjectName;
    }

    public void setShortProjectName(String shortProjectName) {
        this.shortProjectName = shortProjectName;
    }
}
