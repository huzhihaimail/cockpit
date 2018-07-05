package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class SixRateIndexForDialog {

    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;

    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;

    @ApiModelProperty(value = "资产负债率", example = "资产负债率")
    private String zcfz;
    @ApiModelProperty(value = "资产周转率预警（1是正常 0是预警）", example = "资产周转率预警（1是正常 0是预警）")
    private String zcfzyj;

    @ApiModelProperty(value = "资产周转率", example = "资产周转率")
    private String zczz;
    @ApiModelProperty(value = "资产周转率预警（1是正常 0是预警）", example = "资产周转率预警（1是正常 0是预警）")
    private String zczzyj;

    @ApiModelProperty(value = "资本利润率", example = "资本利润率")
    private String zblr;
    @ApiModelProperty(value = "资本利润率预警（1是正常 0是预警）", example = "资本利润率预警（1是正常 0是预警）")
    private String zblryj;

    @ApiModelProperty(value = "净资产收益率", example = "净资产收益率")
    private String jzcsy;
    @ApiModelProperty(value = "净资产收益率预警（1是正常 0是预警）", example = "净资产收益率预警（1是正常 0是预警）")
    private String jzcsyyj;

    @ApiModelProperty(value = "人均收入（劳动生产率）", example = "人均收入（劳动生产率）")
    private String rjsr;
    @ApiModelProperty(value = "人均收入（劳动生产率）预警（1是正常 0是预警）", example = "人均收入（劳动生产率）预警（1是正常 0是预警）")
    private String rjsryj;

    @ApiModelProperty(value = "人均利润", example = "人均利润")
    private String rjlr;
    @ApiModelProperty(value = "人均利润预警（1是正常 0是预警）", example = "人均利润预警（1是正常 0是预警）")
    private String rjlryj;

    @ApiModelProperty(value = "市场占有率", example = "市场占有率")
    private String sczy;
    @ApiModelProperty(value = "市场占有率预警（1是正常 0是预警）", example = "市场占有率预警（1是正常 0是预警）")
    private String sczyyj;

    public String getAreaCode() {
        return areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getZcfz() {
        return zcfz;
    }

    public String getZcfzyj() {
        return zcfzyj;
    }

    public String getZczz() {
        return zczz;
    }

    public String getZczzyj() {
        return zczzyj;
    }

    public String getZblr() {
        return zblr;
    }

    public String getZblryj() {
        return zblryj;
    }

    public String getJzcsy() {
        return jzcsy;
    }

    public String getJzcsyyj() {
        return jzcsyyj;
    }

    public String getRjsr() {
        return rjsr;
    }

    public String getRjsryj() {
        return rjsryj;
    }

    public String getRjlr() {
        return rjlr;
    }

    public String getRjlryj() {
        return rjlryj;
    }

    public String getSczy() {
        return sczy;
    }

    public String getSczyyj() {
        return sczyyj;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setZcfz(String zcfz) {
        this.zcfz = zcfz;
    }

    public void setZcfzyj(String zcfzyj) {
        this.zcfzyj = zcfzyj;
    }

    public void setZczz(String zczz) {
        this.zczz = zczz;
    }

    public void setZczzyj(String zczzyj) {
        this.zczzyj = zczzyj;
    }

    public void setZblr(String zblr) {
        this.zblr = zblr;
    }

    public void setZblryj(String zblryj) {
        this.zblryj = zblryj;
    }

    public void setJzcsy(String jzcsy) {
        this.jzcsy = jzcsy;
    }

    public void setJzcsyyj(String jzcsyyj) {
        this.jzcsyyj = jzcsyyj;
    }

    public void setRjsr(String rjsr) {
        this.rjsr = rjsr;
    }

    public void setRjsryj(String rjsryj) {
        this.rjsryj = rjsryj;
    }

    public void setRjlr(String rjlr) {
        this.rjlr = rjlr;
    }

    public void setRjlryj(String rjlryj) {
        this.rjlryj = rjlryj;
    }

    public void setSczy(String sczy) {
        this.sczy = sczy;
    }

    public void setSczyyj(String sczyyj) {
        this.sczyyj = sczyyj;
    }
}
