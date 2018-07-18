package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class SixRateCityIndexForDialogOfMonth {

    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;

    @ApiModelProperty(value = "负债总额", example = "负债总额")
    private String fzze;
    @ApiModelProperty(value = "资产总额", example = "资产总额")
    private String zcze;
    @ApiModelProperty(value = "资产负债率", example = "资产负债率")
    private String zcfz;
    @ApiModelProperty(value = "资产周转率预警（1是正常 0是预警）", example = "资产周转率预警（1是正常 0是预警）")
    private String zcfzyj;

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
    private String rjsryysr;
    @ApiModelProperty(value = "人数", example = "人数")
    private String rjsrrs;
    @ApiModelProperty(value = "人均收入（劳动生产率）", example = "人均收入（劳动生产率）")
    private String rjsr;
    @ApiModelProperty(value = "人均收入（劳动生产率）预警（1是正常 0是预警）", example = "人均收入（劳动生产率）预警（1是正常 0是预警）")
    private String rjsryj;


    @ApiModelProperty(value = "利润金额", example = "利润金额")
    private String  lrje;
    @ApiModelProperty(value = "人数", example = "人数")
    private String rjlrrs;
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


    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
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

    public String getZcfz() {
        return zcfz;
    }

    public void setZcfz(String zcfz) {
        this.zcfz = zcfz;
    }

    public String getZcfzyj() {
        return zcfzyj;
    }

    public void setZcfzyj(String zcfzyj) {
        this.zcfzyj = zcfzyj;
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

    public String getZczz() {
        return zczz;
    }

    public void setZczz(String zczz) {
        this.zczz = zczz;
    }

    public String getZczzyj() {
        return zczzyj;
    }

    public void setZczzyj(String zczzyj) {
        this.zczzyj = zczzyj;
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

    public String getZblr() {
        return zblr;
    }

    public void setZblr(String zblr) {
        this.zblr = zblr;
    }

    public String getZblryj() {
        return zblryj;
    }

    public void setZblryj(String zblryj) {
        this.zblryj = zblryj;
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

    public String getJzcsy() {
        return jzcsy;
    }

    public void setJzcsy(String jzcsy) {
        this.jzcsy = jzcsy;
    }

    public String getJzcsyyj() {
        return jzcsyyj;
    }

    public void setJzcsyyj(String jzcsyyj) {
        this.jzcsyyj = jzcsyyj;
    }

    public String getRjsryysr() {
        return rjsryysr;
    }

    public void setRjsryysr(String rjsryysr) {
        this.rjsryysr = rjsryysr;
    }

    public String getRjsrrs() {
        return rjsrrs;
    }

    public void setRjsrrs(String rjsrrs) {
        this.rjsrrs = rjsrrs;
    }

    public String getRjsr() {
        return rjsr;
    }

    public void setRjsr(String rjsr) {
        this.rjsr = rjsr;
    }

    public String getRjsryj() {
        return rjsryj;
    }

    public void setRjsryj(String rjsryj) {
        this.rjsryj = rjsryj;
    }

    public String getLrje() {
        return lrje;
    }

    public void setLrje(String lrje) {
        this.lrje = lrje;
    }

    public String getRjlrrs() {
        return rjlrrs;
    }

    public void setRjlrrs(String rjlrrs) {
        this.rjlrrs = rjlrrs;
    }

    public String getRjlr() {
        return rjlr;
    }

    public void setRjlr(String rjlr) {
        this.rjlr = rjlr;
    }

    public String getRjlryj() {
        return rjlryj;
    }

    public void setRjlryj(String rjlryj) {
        this.rjlryj = rjlryj;
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

    public String getSczy() {
        return sczy;
    }

    public void setSczy(String sczy) {
        this.sczy = sczy;
    }

    public String getSczyyj() {
        return sczyyj;
    }

    public void setSczyyj(String sczyyj) {
        this.sczyyj = sczyyj;
    }
}
