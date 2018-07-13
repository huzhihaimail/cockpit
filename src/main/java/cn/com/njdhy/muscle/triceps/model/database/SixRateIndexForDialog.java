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
    @ApiModelProperty(value = "负债总额", example = "资产负债率")
    private String fzze;
    @ApiModelProperty(value = "资产周转率预警（1是正常 0是预警）", example = "资产周转率预警（1是正常 0是预警）")
    private String zcze;

    @ApiModelProperty(value = "营业收入", example = "营业收入")
    private String yysr;
    @ApiModelProperty(value = "平均总资产", example = "平均总资产")
    private String pjzzc;
    @ApiModelProperty(value = "资产周转率", example = "资产周转率")
    private String zczz;
    @ApiModelProperty(value = "资产周转率预警（1是正常 0是预警）", example = "资产周转率预警（1是正常 0是预警）")
    private String zczzyj;

    @ApiModelProperty(value = "净利润", example = "净利润")
    private String jlr;
    @ApiModelProperty(value = "平均资本", example = "平均资本")
    private String pjzb;
    @ApiModelProperty(value = "资本利润率", example = "资本利润率")
    private String zblr;
    @ApiModelProperty(value = "资本利润率预警（1是正常 0是预警）", example = "资本利润率预警（1是正常 0是预警）")
    private String zblryj;

    @ApiModelProperty(value = "净利润", example = "净利润")
    private String jzcjlr;
    @ApiModelProperty(value = "平均所有者权益", example = "平均所有者权益")
    private String pjsyzqy;
    @ApiModelProperty(value = "净资产收益率", example = "净资产收益率")
    private String jzcsy;
    @ApiModelProperty(value = "净资产收益率预警（1是正常 0是预警）", example = "净资产收益率预警（1是正常 0是预警）")
    private String jzcsyyj;

    @ApiModelProperty(value = "营业收入", example = "营业收入")
    private String rjyysr;
    @ApiModelProperty(value = "人数", example = "人数")
    private String rs;
    @ApiModelProperty(value = "人均收入（劳动生产率）", example = "人均收入（劳动生产率）")
    private String rjsr;
    @ApiModelProperty(value = "人均收入（劳动生产率）预警（1是正常 0是预警）", example = "人均收入（劳动生产率）预警（1是正常 0是预警）")
    private String rjsryj;

    @ApiModelProperty(value = "利润金额", example = "利润金额")
    private String lrje;
    @ApiModelProperty(value = "人数", example = "人数")
    private String rjrs;
    @ApiModelProperty(value = "人均利润", example = "人均利润")
    private String rjlr;
    @ApiModelProperty(value = "人均利润预警（1是正常 0是预警）", example = "人均利润预警（1是正常 0是预警）")
    private String rjlryj;

    @ApiModelProperty(value = "海航地产销售额", example = "海航地产销售额")
    private String hanxse;
    @ApiModelProperty(value = "全国地产销售额", example = "全国地产销售额")
    private String qgxse;
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

    public String getFzze() {
        return fzze;
    }

    public void setFzze(String fzze) {
        this.fzze = fzze;
    }

    public String getZcze() {
        return zcze;
    }

    public void setZcze(String zcze) {
        this.zcze = zcze;
    }

    public String getYysr() {
        return yysr;
    }

    public void setYysr(String yysr) {
        this.yysr = yysr;
    }

    public String getPjzzc() {
        return pjzzc;
    }

    public void setPjzzc(String pjzzc) {
        this.pjzzc = pjzzc;
    }

    public String getJlr() {
        return jlr;
    }

    public void setJlr(String jlr) {
        this.jlr = jlr;
    }

    public String getPjzb() {
        return pjzb;
    }

    public void setPjzb(String pjzb) {
        this.pjzb = pjzb;
    }

    public String getJzcjlr() {
        return jzcjlr;
    }

    public void setJzcjlr(String jzcjlr) {
        this.jzcjlr = jzcjlr;
    }

    public String getPjsyzqy() {
        return pjsyzqy;
    }

    public void setPjsyzqy(String pjsyzqy) {
        this.pjsyzqy = pjsyzqy;
    }

    public String getRjyysr() {
        return rjyysr;
    }

    public void setRjyysr(String rjyysr) {
        this.rjyysr = rjyysr;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getLrje() {
        return lrje;
    }

    public void setLrje(String lrje) {
        this.lrje = lrje;
    }

    public String getRjrs() {
        return rjrs;
    }

    public void setRjrs(String rjrs) {
        this.rjrs = rjrs;
    }

    public String getHanxse() {
        return hanxse;
    }

    public void setHanxse(String hanxse) {
        this.hanxse = hanxse;
    }

    public String getQgxse() {
        return qgxse;
    }

    public void setQgxse(String qgxse) {
        this.qgxse = qgxse;
    }
}
