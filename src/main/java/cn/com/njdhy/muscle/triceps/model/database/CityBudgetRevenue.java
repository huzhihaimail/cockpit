package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页分公司首页收入利润预算收入月度趋势实体
 */
@ApiModel
public class CityBudgetRevenue {

    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "项目编码", example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "预算收入目标完成率", example = "预算收入目标完成率")
    private String myssrl;
    @ApiModelProperty(value = "预算收入目标完成率预警（1是正常 0是预警）", example = "预算收入目标完成率预警（1是正常 0是预警）")
    private String myssrlyj;
    @ApiModelProperty(value = "预算收入(总收入)", example = "预算收入目标完成率预警（1是正常 0是预警）")
    private String myssr;
    @ApiModelProperty(value = "销售收入", example = "销售收入")
    private String xssr;
    @ApiModelProperty(value = "销售收入占比", example = "销售收入占比")
    private String xssrzb;
    @ApiModelProperty(value = "自持有收入", example = "自持有收入")
    private String zcysr;
    @ApiModelProperty(value = "自持有收入占比", example = "自持有收入占比")
    private String zcysrzb;

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

    public String getMyssrl() {
        return myssrl;
    }

    public void setMyssrl(String myssrl) {
        this.myssrl = myssrl;
    }

    public String getMyssrlyj() {
        return myssrlyj;
    }

    public void setMyssrlyj(String myssrlyj) {
        this.myssrlyj = myssrlyj;
    }

    public String getMyssr() {
        return myssr;
    }

    public void setMyssr(String myssr) {
        this.myssr = myssr;
    }

    public String getXssr() {
        return xssr;
    }

    public void setXssr(String xssr) {
        this.xssr = xssr;
    }

    public String getXssrzb() {
        return xssrzb;
    }

    public void setXssrzb(String xssrzb) {
        this.xssrzb = xssrzb;
    }

    public String getZcysr() {
        return zcysr;
    }

    public void setZcysr(String zcysr) {
        this.zcysr = zcysr;
    }

    public String getZcysrzb() {
        return zcysrzb;
    }

    public void setZcysrzb(String zcysrzb) {
        this.zcysrzb = zcysrzb;
    }
}
