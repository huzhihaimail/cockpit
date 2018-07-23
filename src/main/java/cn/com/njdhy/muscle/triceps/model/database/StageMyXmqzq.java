package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author Richard.li
 * @Description 项目全周期
 * @Date 2018/7/18
 **/
@ApiModel
public class StageMyXmqzq {

    @ApiModelProperty(value = "项目编码", example = "项目编码")
    private String projCode;

    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projName;

    @ApiModelProperty(value = "一级业态编码", example = "一级业态编码")
    private String prodCode;

    @ApiModelProperty(value = "一级业态名称", example = "一级业态名称")
    private String prodName;

    @ApiModelProperty(value = "二级业态编码", example = "二级业态编码")
    private String subProdCode;

    @ApiModelProperty(value = "二级业态名称", example = "二级业态名称")
    private String subProdName;

    @ApiModelProperty(value = "面积总数（㎡）", example = "面积总数（㎡）")
    private String areaAll;

    @ApiModelProperty(value = "已售面积（㎡）", example = "已售面积（㎡）")
    private String ysArea;

    @ApiModelProperty(value = "剩余面积（㎡）", example = "剩余面积（㎡）")
    private String syArea;

    @ApiModelProperty(value = "已售货值净认购", example = "已售货值净认购")
    private String yshzjrgAmt;

    @ApiModelProperty(value = "已售货值净签约", example = "已售货值净签约")
    private String yshzjqyAmt;

    @ApiModelProperty(value = "剩余货值净认购", example = "剩余货值净认购")
    private String syhzjrgAmt;

    @ApiModelProperty(value = "剩余货值净签约", example = "剩余货值净签约")
    private String syhzjqyAmt;

    @ApiModelProperty(value = "已回款总额（元）", example = "已回款总额（元）")
    private String yhkAmt;

    @ApiModelProperty(value = "当前年月日", example = "当前年月日")
    private String dataDate;

    private Date etlTime;

    public String getProjCode() {
        return projCode;
    }

    public void setProjCode(String projCode) {
        this.projCode = projCode;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getSubProdCode() {
        return subProdCode;
    }

    public void setSubProdCode(String subProdCode) {
        this.subProdCode = subProdCode;
    }

    public String getSubProdName() {
        return subProdName;
    }

    public void setSubProdName(String subProdName) {
        this.subProdName = subProdName;
    }

    public String getAreaAll() {
        return areaAll;
    }

    public void setAreaAll(String areaAll) {
        this.areaAll = areaAll;
    }

    public String getYsArea() {
        return ysArea;
    }

    public void setYsArea(String ysArea) {
        this.ysArea = ysArea;
    }

    public String getSyArea() {
        return syArea;
    }

    public void setSyArea(String syArea) {
        this.syArea = syArea;
    }

    public String getYshzjrgAmt() {
        return yshzjrgAmt;
    }

    public void setYshzjrgAmt(String yshzjrgAmt) {
        this.yshzjrgAmt = yshzjrgAmt;
    }

    public String getYshzjqyAmt() {
        return yshzjqyAmt;
    }

    public void setYshzjqyAmt(String yshzjqyAmt) {
        this.yshzjqyAmt = yshzjqyAmt;
    }

    public String getSyhzjrgAmt() {
        return syhzjrgAmt;
    }

    public void setSyhzjrgAmt(String syhzjrgAmt) {
        this.syhzjrgAmt = syhzjrgAmt;
    }

    public String getSyhzjqyAmt() {
        return syhzjqyAmt;
    }

    public void setSyhzjqyAmt(String syhzjqyAmt) {
        this.syhzjqyAmt = syhzjqyAmt;
    }

    public String getYhkAmt() {
        return yhkAmt;
    }

    public void setYhkAmt(String yhkAmt) {
        this.yhkAmt = yhkAmt;
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }
}
