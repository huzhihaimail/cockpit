package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author Richard.li
 * @Description 成本合同目标+调整建筑成本单方、动态建筑成本单方、偏差率
 * @Date 2018/7/23
 **/
@ApiModel
public class StageMyCb {

    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "科目名称", example = "科目名称")
    private String itemName;

    @ApiModelProperty(value = "当前年月日", example = "当前年月日")
    private String dataDate;

    @ApiModelProperty(value = "目标+调整建筑成本合计", example = "目标+调整建筑成本合计")
    private String mbtzjzcbHj;

    @ApiModelProperty(value = "目标+调整建筑单方合计", example = "目标+调整建筑单方合计")
    private String mbtzjzdfHj;

    @ApiModelProperty(value = "动态建筑成本合计", example = "动态建筑成本合计")
    private String dtjzcbHj;

    @ApiModelProperty(value = "动态建筑单方合计", example = "动态建筑单方合计")
    private String dtjzdfHj;

    @ApiModelProperty(value = "偏差率合计", example = "偏差率合计")
    private String pclHj;

    @ApiModelProperty(value = "目标+调整建筑成本合计", example = "目标+调整建筑成本合计")
    private String mbtzjzCb;

    @ApiModelProperty(value = "目标+调整建筑单方合计", example = "目标+调整建筑单方合计")
    private String mbtzjzDf;

    @ApiModelProperty(value = "动态建筑成本", example = "动态建筑成本")
    private String dtjzCb;

    @ApiModelProperty(value = "动态建筑单方", example = "动态建筑单方")
    private String dtjzDf;

    @ApiModelProperty(value = "偏差率", example = "偏差率")
    private String pcl;

    private Date etlTime;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getMbtzjzcbHj() {
        return mbtzjzcbHj;
    }

    public void setMbtzjzcbHj(String mbtzjzcbHj) {
        this.mbtzjzcbHj = mbtzjzcbHj;
    }

    public String getMbtzjzdfHj() {
        return mbtzjzdfHj;
    }

    public void setMbtzjzdfHj(String mbtzjzdfHj) {
        this.mbtzjzdfHj = mbtzjzdfHj;
    }

    public String getDtjzcbHj() {
        return dtjzcbHj;
    }

    public void setDtjzcbHj(String dtjzcbHj) {
        this.dtjzcbHj = dtjzcbHj;
    }

    public String getDtjzdfHj() {
        return dtjzdfHj;
    }

    public void setDtjzdfHj(String dtjzdfHj) {
        this.dtjzdfHj = dtjzdfHj;
    }

    public String getPclHj() {
        return pclHj;
    }

    public void setPclHj(String pclHj) {
        this.pclHj = pclHj;
    }

    public String getMbtzjzCb() {
        return mbtzjzCb;
    }

    public void setMbtzjzCb(String mbtzjzCb) {
        this.mbtzjzCb = mbtzjzCb;
    }

    public String getMbtzjzDf() {
        return mbtzjzDf;
    }

    public void setMbtzjzDf(String mbtzjzDf) {
        this.mbtzjzDf = mbtzjzDf;
    }

    public String getDtjzCb() {
        return dtjzCb;
    }

    public void setDtjzCb(String dtjzCb) {
        this.dtjzCb = dtjzCb;
    }

    public String getDtjzDf() {
        return dtjzDf;
    }

    public void setDtjzDf(String dtjzDf) {
        this.dtjzDf = dtjzDf;
    }

    public String getPcl() {
        return pcl;
    }

    public void setPcl(String pcl) {
        this.pcl = pcl;
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }
}
