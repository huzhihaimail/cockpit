package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by richard on 2018/6/14.
 */
@ApiModel
public class StageMyXSHKDaily {

    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "业态", example = "业态")
    private String pdName;

    @ApiModelProperty(value = "二级业态", example = "二级业态")
    private String subpdName;

    @ApiModelProperty(value = "年月日", example = "年月日")
    private String dataDate;

    @ApiModelProperty(value = "认购套数（套）", example = "认购套数（套）")
    private String rgCnt;

    @ApiModelProperty(value = "认购面积（㎡）", example = "认购面积（㎡）")
    private String rgArea;

    @ApiModelProperty(value = "认购金额（元）", example = "认购金额（元）")
    private String rgAmt;

    @ApiModelProperty(value = "签约金额（元）", example = "签约金额（元）")
    private String qyAmt;

    @ApiModelProperty(value = "销售预算分解-销售套数", example = "销售预算分解-销售套数")
    private String qyCntBudget;

    @ApiModelProperty(value = "销售预算分解-销售面积", example = "销售预算分解-销售面积")
    private String qyAreaBudget;

    @ApiModelProperty(value = "销售预算分解-销售金额", example = "销售预算分解-销售金额")
    private String qyAmtBudget;

    @ApiModelProperty(value = "回款预算分解-销售金额", example = "回款预算分解-销售金额")
    private String hkAmtBudget;

    @ApiModelProperty(value = "已回总房款", example = "已回总房款")
    private String hkAmt;

    @ApiModelProperty(value = "抽取时间", example = "抽取时间")
    private Date etlTime;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getSubpdName() {
        return subpdName;
    }

    public void setSubpdName(String subpdName) {
        this.subpdName = subpdName;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getRgCnt() {
        return rgCnt;
    }

    public void setRgCnt(String rgCnt) {
        this.rgCnt = rgCnt;
    }

    public String getRgArea() {
        return rgArea;
    }

    public void setRgArea(String rgArea) {
        this.rgArea = rgArea;
    }

    public String getRgAmt() {
        return rgAmt;
    }

    public void setRgAmt(String rgAmt) {
        this.rgAmt = rgAmt;
    }

    public String getQyAmt() {
        return qyAmt;
    }

    public void setQyAmt(String qyAmt) {
        this.qyAmt = qyAmt;
    }

    public String getQyCntBudget() {
        return qyCntBudget;
    }

    public void setQyCntBudget(String qyCntBudget) {
        this.qyCntBudget = qyCntBudget;
    }

    public String getQyAreaBudget() {
        return qyAreaBudget;
    }

    public void setQyAreaBudget(String qyAreaBudget) {
        this.qyAreaBudget = qyAreaBudget;
    }

    public String getQyAmtBudget() {
        return qyAmtBudget;
    }

    public void setQyAmtBudget(String qyAmtBudget) {
        this.qyAmtBudget = qyAmtBudget;
    }

    public String getHkAmtBudget() {
        return hkAmtBudget;
    }

    public void setHkAmtBudget(String hkAmtBudget) {
        this.hkAmtBudget = hkAmtBudget;
    }

    public String getHkAmt() {
        return hkAmt;
    }

    public void setHkAmt(String hkAmt) {
        this.hkAmt = hkAmt;
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }
}
