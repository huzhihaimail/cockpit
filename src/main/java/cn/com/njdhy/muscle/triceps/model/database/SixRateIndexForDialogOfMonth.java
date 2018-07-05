package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class SixRateIndexForDialogOfMonth {

    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;

    @ApiModelProperty(value = "资产负债率", example = "资产负债率")
    private String mzcfz;
    @ApiModelProperty(value = "资产周转率预警（1是正常 0是预警）", example = "资产周转率预警（1是正常 0是预警）")
    private String mzcfzyj;

    @ApiModelProperty(value = "资产周转率", example = "资产周转率")
    private String mzczz;
    @ApiModelProperty(value = "资产周转率预警（1是正常 0是预警）", example = "资产周转率预警（1是正常 0是预警）")
    private String mzczzyj;

    @ApiModelProperty(value = "资本利润率", example = "资本利润率")
    private String mzblr;
    @ApiModelProperty(value = "资本利润率预警（1是正常 0是预警）", example = "资本利润率预警（1是正常 0是预警）")
    private String mzblryj;

    @ApiModelProperty(value = "净资产收益率", example = "净资产收益率")
    private String mjzcsy;
    @ApiModelProperty(value = "净资产收益率预警（1是正常 0是预警）", example = "净资产收益率预警（1是正常 0是预警）")
    private String mjzcsyyj;

    @ApiModelProperty(value = "人均收入（劳动生产率）", example = "人均收入（劳动生产率）")
    private String mrjsr;
    @ApiModelProperty(value = "人均收入（劳动生产率）预警（1是正常 0是预警）", example = "人均收入（劳动生产率）预警（1是正常 0是预警）")
    private String mrjsryj;

    @ApiModelProperty(value = "人均利润", example = "人均利润")
    private String mrjlr;
    @ApiModelProperty(value = "人均利润预警（1是正常 0是预警）", example = "人均利润预警（1是正常 0是预警）")
    private String mrjlryj;

    @ApiModelProperty(value = "市场占有率", example = "市场占有率")
    private String msczy;
    @ApiModelProperty(value = "市场占有率预警（1是正常 0是预警）", example = "市场占有率预警（1是正常 0是预警）")
    private String msczyyj;

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public void setMzcfz(String mzcfz) {
        this.mzcfz = mzcfz;
    }

    public void setMzcfzyj(String mzcfzyj) {
        this.mzcfzyj = mzcfzyj;
    }

    public void setMzczz(String mzczz) {
        this.mzczz = mzczz;
    }

    public void setMzczzyj(String mzczzyj) {
        this.mzczzyj = mzczzyj;
    }

    public void setMzblr(String mzblr) {
        this.mzblr = mzblr;
    }

    public void setMzblryj(String mzblryj) {
        this.mzblryj = mzblryj;
    }

    public void setMjzcsy(String mjzcsy) {
        this.mjzcsy = mjzcsy;
    }

    public void setMjzcsyyj(String mjzcsyyj) {
        this.mjzcsyyj = mjzcsyyj;
    }

    public void setMrjsr(String mrjsr) {
        this.mrjsr = mrjsr;
    }

    public void setMrjsryj(String mrjsryj) {
        this.mrjsryj = mrjsryj;
    }

    public void setMrjlr(String mrjlr) {
        this.mrjlr = mrjlr;
    }

    public void setMrjlryj(String mrjlryj) {
        this.mrjlryj = mrjlryj;
    }

    public void setMsczy(String msczy) {
        this.msczy = msczy;
    }

    public void setMsczyyj(String msczyyj) {
        this.msczyyj = msczyyj;
    }

    public String getYearMonth() {

        return yearMonth;
    }

    public String getMzcfz() {
        return mzcfz;
    }

    public String getMzcfzyj() {
        return mzcfzyj;
    }

    public String getMzczz() {
        return mzczz;
    }

    public String getMzczzyj() {
        return mzczzyj;
    }

    public String getMzblr() {
        return mzblr;
    }

    public String getMzblryj() {
        return mzblryj;
    }

    public String getMjzcsy() {
        return mjzcsy;
    }

    public String getMjzcsyyj() {
        return mjzcsyyj;
    }

    public String getMrjsr() {
        return mrjsr;
    }

    public String getMrjsryj() {
        return mrjsryj;
    }

    public String getMrjlr() {
        return mrjlr;
    }

    public String getMrjlryj() {
        return mrjlryj;
    }

    public String getMsczy() {
        return msczy;
    }

    public String getMsczyyj() {
        return msczyyj;
    }
}
