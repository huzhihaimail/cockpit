package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author Richard.li
 * @Description 已认购未签约
 * @Date 2018/7/16
 **/
@ApiModel
public class StageMyRgwqy {


    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "一级业态名称", example = "一级业态名称")
    private String pdName;

    @ApiModelProperty(value = "二级业态名称", example = "二级业态名称")
    private String subPdName;

    @ApiModelProperty(value = "当前年月日", example = "当前年月日")
    private String dataDate;

    @ApiModelProperty(value = "已认购未签约_套数", example = "已认购未签约_套数")
    private String cRgCnt;

    @ApiModelProperty(value = "已认购未签约_面积", example = "已认购未签约_面积")
    private String cRgArea;

    @ApiModelProperty(value = "已认购未签约_成交总价", example = "已认购未签约_成交总价")
    private String cRgAmt;

    @ApiModelProperty(value = "已认购未签约_已回款", example = "已认购未签约_已回款")
    private String cRgHk;

    @ApiModelProperty(value = "已认购未签约_未回款", example = "已认购未签约_未回款")
    private String cRgWhk;

    @ApiModelProperty(value = "已认购未到签约日期_套数", example = "已认购未到签约日期_套数")
    private String dRgCnt;

    @ApiModelProperty(value = "已认购未到签约日期_面积", example = "已认购未到签约日期_面积")
    private String dRgArea;

    @ApiModelProperty(value = "已认购未到签约日期_成交总价", example = "已认购未到签约日期_成交总价")
    private String dRgAmt;

    @ApiModelProperty(value = "已认购未到签约日期_已回款", example = "已认购未到签约日期_已回款")
    private String dRgHk;

    @ApiModelProperty(value = "已认购未到签约日期_未回款", example = "已认购未到签约日期_未回款")
    private String dRgWhk;

    @ApiModelProperty(value = "逾期未签约_套数", example = "逾期未签约_套数")
    private String eRgCnt;

    @ApiModelProperty(value = "逾期未签约_面积", example = "逾期未签约_面积")
    private String eRgArea;

    @ApiModelProperty(value = "逾期未签约_总交总价", example = "逾期未签约_总交总价")
    private String eRgAmt;

    @ApiModelProperty(value = "逾期未签约_已回款", example = "逾期未签约_已回款")
    private String eRgHk;

    @ApiModelProperty(value = "逾期未签约_未回款", example = "逾期未签约_未回款")
    private String eRgWhk;

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

    public String getSubPdName() {
        return subPdName;
    }

    public void setSubPdName(String subPdName) {
        this.subPdName = subPdName;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getcRgCnt() {
        return cRgCnt;
    }

    public void setcRgCnt(String cRgCnt) {
        this.cRgCnt = cRgCnt;
    }

    public String getcRgArea() {
        return cRgArea;
    }

    public void setcRgArea(String cRgArea) {
        this.cRgArea = cRgArea;
    }

    public String getcRgAmt() {
        return cRgAmt;
    }

    public void setcRgAmt(String cRgAmt) {
        this.cRgAmt = cRgAmt;
    }

    public String getcRgHk() {
        return cRgHk;
    }

    public void setcRgHk(String cRgHk) {
        this.cRgHk = cRgHk;
    }

    public String getcRgWhk() {
        return cRgWhk;
    }

    public void setcRgWhk(String cRgWhk) {
        this.cRgWhk = cRgWhk;
    }

    public String getdRgCnt() {
        return dRgCnt;
    }

    public void setdRgCnt(String dRgCnt) {
        this.dRgCnt = dRgCnt;
    }

    public String getdRgArea() {
        return dRgArea;
    }

    public void setdRgArea(String dRgArea) {
        this.dRgArea = dRgArea;
    }

    public String getdRgAmt() {
        return dRgAmt;
    }

    public void setdRgAmt(String dRgAmt) {
        this.dRgAmt = dRgAmt;
    }

    public String getdRgHk() {
        return dRgHk;
    }

    public void setdRgHk(String dRgHk) {
        this.dRgHk = dRgHk;
    }

    public String getdRgWhk() {
        return dRgWhk;
    }

    public void setdRgWhk(String dRgWhk) {
        this.dRgWhk = dRgWhk;
    }

    public String geteRgCnt() {
        return eRgCnt;
    }

    public void seteRgCnt(String eRgCnt) {
        this.eRgCnt = eRgCnt;
    }

    public String geteRgArea() {
        return eRgArea;
    }

    public void seteRgArea(String eRgArea) {
        this.eRgArea = eRgArea;
    }

    public String geteRgAmt() {
        return eRgAmt;
    }

    public void seteRgAmt(String eRgAmt) {
        this.eRgAmt = eRgAmt;
    }

    public String geteRgHk() {
        return eRgHk;
    }

    public void seteRgHk(String eRgHk) {
        this.eRgHk = eRgHk;
    }

    public String geteRgWhk() {
        return eRgWhk;
    }

    public void seteRgWhk(String eRgWhk) {
        this.eRgWhk = eRgWhk;
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }
}
