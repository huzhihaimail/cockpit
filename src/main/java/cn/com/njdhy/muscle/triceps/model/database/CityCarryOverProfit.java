package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页收入利润模块结转利润项目分布实体
 */
@ApiModel
public class CityCarryOverProfit {
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;

    @ApiModelProperty(value = "项目编号", example = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;


    @ApiModelProperty(value = "结转利润目标完成率", example = "结转利润目标完成率")
    private String jzlrl;
    @ApiModelProperty(value = "结转利润目标完成率预警（1是正常 0是预警）", example = "结转利润目标完成率预警（1是正常 0是预警）")
    private String jzlrlyj;
    @ApiModelProperty(value = "结转利润", example = "结转利润")
    private String jzlr;

    @ApiModelProperty(value = "结转利润销售收入", example = "结转利润销售收入")
    private String xsjzlr;
    @ApiModelProperty(value = "结转利润销售占比", example = "结转利润销售占比")
    private String xsjzlrzb;
    @ApiModelProperty(value = "结转利润自持有收入", example = "结转利润自持有收入")
    private String zcyjzlr;
    @ApiModelProperty(value = "结转利润自持有占比", example = "结转利润自持有占比")
    private String zcyjzlrzb;

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

    public String getJzlrl() {
        return jzlrl;
    }

    public void setJzlrl(String jzlrl) {
        this.jzlrl = jzlrl;
    }

    public String getJzlrlyj() {
        return jzlrlyj;
    }

    public void setJzlrlyj(String jzlrlyj) {
        this.jzlrlyj = jzlrlyj;
    }

    public String getJzlr() {
        return jzlr;
    }

    public void setJzlr(String jzlr) {
        this.jzlr = jzlr;
    }

    public String getXsjzlr() {
        return xsjzlr;
    }

    public void setXsjzlr(String xsjzlr) {
        this.xsjzlr = xsjzlr;
    }

    public String getXsjzlrzb() {
        return xsjzlrzb;
    }

    public void setXsjzlrzb(String xsjzlrzb) {
        this.xsjzlrzb = xsjzlrzb;
    }

    public String getZcyjzlr() {
        return zcyjzlr;
    }

    public void setZcyjzlr(String zcyjzlr) {
        this.zcyjzlr = zcyjzlr;
    }

    public String getZcyjzlrzb() {
        return zcyjzlrzb;
    }

    public void setZcyjzlrzb(String zcyjzlrzb) {
        this.zcyjzlrzb = zcyjzlrzb;
    }
}
