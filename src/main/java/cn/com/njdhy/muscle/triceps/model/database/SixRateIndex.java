package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class SixRateIndex {

    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;

    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;

    @ApiModelProperty(value = "资产负债率", example = "资产负债率")
    private String zcfz;
    @ApiModelProperty(value = "资产周转率", example = "资产周转率")
    private String zczz;
    @ApiModelProperty(value = "资本利润率", example = "资本利润率")
    private String zblr;
    @ApiModelProperty(value = "净资产收益率", example = "净资产收益率")
    private String jzcsy;
    @ApiModelProperty(value = "人均收入（劳动生产率）", example = "人均收入（劳动生产率）")
    private String rjsr;
    @ApiModelProperty(value = "人均利润", example = "人均利润")
    private String rjlr;
    @ApiModelProperty(value = "市场占有率", example = "市场占有率")
    private String sczy;
    //六率指标你第一层返回参数
    @ApiModelProperty(value = "资产负债率预警", example = "资产负债率预警")
    private String mzcfzyj;
    @ApiModelProperty(value = "资产周转率预警", example = "资产周转率预警")
    private String mzczzyj;
    @ApiModelProperty(value = "资本利润率预警", example = "资本利润率预警")
    private String mzblryj;
    @ApiModelProperty(value = "净资产收益率预警", example = "净资产收益率预警")
    private String mjzcsyyj;
    @ApiModelProperty(value = "人均收入（劳动生产率）预警", example = "人均收入（劳动生产率）预警")
    private String mrjsryj;
    @ApiModelProperty(value = "人均利润预警", example = "人均利润预警")
    private String mrjlryj;
    @ApiModelProperty(value = "市场占有率预警", example = "市场占有率预警")
    private String msczyyj;

    //六率指标第二层返回参数
    @ApiModelProperty(value = "资产负债率预警", example = "资产负债率预警")
    private String zcfzyj;
    @ApiModelProperty(value = "资产周转率预警", example = "资产周转率预警")
    private String zczzyj;
    @ApiModelProperty(value = "资本利润率预警", example = "资本利润率预警")
    private String zblryj;
    @ApiModelProperty(value = "净资产收益率预警", example = "净资产收益率预警")
    private String jzcsyyj;
    @ApiModelProperty(value = "人均收入（劳动生产率）预警", example = "人均收入（劳动生产率）预警")
    private String rjsryj;
    @ApiModelProperty(value = "人均利润预警", example = "人均利润预警")
    private String rjlryj;
    @ApiModelProperty(value = "市场占有率预警", example = "市场占有率预警")
    private String sczyyj;

    public void setZcfzyj(String zcfzyj) {
        this.zcfzyj = zcfzyj;
    }

    public void setZczzyj(String zczzyj) {
        this.zczzyj = zczzyj;
    }

    public void setZblryj(String zblryj) {
        this.zblryj = zblryj;
    }

    public void setJzcsyyj(String jzcsyyj) {
        this.jzcsyyj = jzcsyyj;
    }

    public void setRjsryj(String rjsryj) {
        this.rjsryj = rjsryj;
    }

    public void setRjlryj(String rjlryj) {
        this.rjlryj = rjlryj;
    }

    public void setSczyyj(String sczyyj) {
        this.sczyyj = sczyyj;
    }

    public String getZcfzyj() {

        return zcfzyj;
    }

    public String getZczzyj() {
        return zczzyj;
    }

    public String getZblryj() {
        return zblryj;
    }

    public String getJzcsyyj() {
        return jzcsyyj;
    }

    public String getRjsryj() {
        return rjsryj;
    }

    public String getRjlryj() {
        return rjlryj;
    }

    public String getSczyyj() {
        return sczyyj;
    }

    public void setMzcfzyj(String mzcfzyj) {
        this.mzcfzyj = mzcfzyj;
    }

    public void setMzczzyj(String mzczzyj) {
        this.mzczzyj = mzczzyj;
    }

    public void setMzblryj(String mzblryj) {
        this.mzblryj = mzblryj;
    }

    public void setMjzcsyyj(String mjzcsyyj) {
        this.mjzcsyyj = mjzcsyyj;
    }

    public void setMrjsryj(String mrjsryj) {
        this.mrjsryj = mrjsryj;
    }

    public void setMrjlryj(String mrjlryj) {
        this.mrjlryj = mrjlryj;
    }

    public void setMsczyyj(String msczyyj) {
        this.msczyyj = msczyyj;
    }

    public String getMzcfzyj() {

        return mzcfzyj;
    }

    public String getMzczzyj() {
        return mzczzyj;
    }

    public String getMzblryj() {
        return mzblryj;
    }

    public String getMjzcsyyj() {
        return mjzcsyyj;
    }

    public String getMrjsryj() {
        return mrjsryj;
    }

    public String getMrjlryj() {
        return mrjlryj;
    }

    public String getMsczyyj() {
        return msczyyj;
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

    public String getZcfz() {
        return zcfz;
    }

    public void setZcfz(String zcfz) {
        this.zcfz = zcfz;
    }

    public String getZczz() {
        return zczz;
    }

    public void setZczz(String zczz) {
        this.zczz = zczz;
    }

    public String getZblr() {
        return zblr;
    }

    public void setZblr(String zblr) {
        this.zblr = zblr;
    }

    public String getJzcsy() {
        return jzcsy;
    }

    public void setJzcsy(String jzcsy) {
        this.jzcsy = jzcsy;
    }

    public String getRjsr() {
        return rjsr;
    }

    public void setRjsr(String rjsr) {
        this.rjsr = rjsr;
    }

    public String getRjlr() {
        return rjlr;
    }

    public void setRjlr(String rjlr) {
        this.rjlr = rjlr;
    }

    public String getSczy() {
        return sczy;
    }

    public void setSczy(String sczy) {
        this.sczy = sczy;
    }
}
