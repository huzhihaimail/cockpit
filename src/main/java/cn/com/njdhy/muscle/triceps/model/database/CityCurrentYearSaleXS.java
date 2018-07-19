package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页销售完成模块本年销售项目分布
 */
@ApiModel
public class CityCurrentYearSaleXS {

    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "项目编码", example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "销售完成率年", example = "销售完成率年")
    private String xswcly;
    @ApiModelProperty(value = "销售完成率年预警", example = "销售完成率年预警")
    private String xswclyyj;
    @ApiModelProperty(value = "销售金额年", example = "销售金额年")
    private String xswcy;
    @ApiModelProperty(value = "销售目标年", example = "销售目标年")
    private String xswcty;

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

    public String getXswcly() {
        return xswcly;
    }

    public void setXswcly(String xswcly) {
        this.xswcly = xswcly;
    }

    public String getXswclyyj() {
        return xswclyyj;
    }

    public void setXswclyyj(String xswclyyj) {
        this.xswclyyj = xswclyyj;
    }

    public String getXswcy() {
        return xswcy;
    }

    public void setXswcy(String xswcy) {
        this.xswcy = xswcy;
    }

    public String getXswcty() {
        return xswcty;
    }

    public void setXswcty(String xswcty) {
        this.xswcty = xswcty;
    }
}
