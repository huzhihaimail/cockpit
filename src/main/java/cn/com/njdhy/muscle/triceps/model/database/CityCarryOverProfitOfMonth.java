package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页收入利润模块结转利润月度趋势实体
 */
@ApiModel
public class CityCarryOverProfitOfMonth {

    @ApiModelProperty(value = "年月", example = "年月")
    private String yearMonth;

    @ApiModelProperty(value = "结转利润目标完成率", example = "结转利润目标完成率")
    private String mjzlrl;
    @ApiModelProperty(value = "结转利润目标完成率预警（1是正常 0是预警）", example = "结转利润目标完成率预警（1是正常 0是预警）")
    private String mjzlrlyj;
    @ApiModelProperty(value = "结转利润", example = "结转利润")
    private String mjzlr;
    @ApiModelProperty(value = "结转利润目标", example = "结转利润目标")
    private String mjzlrt;

    @ApiModelProperty(value = "结转利润销售收入", example = "结转利润销售收入")
    private String xsjzlr;
    @ApiModelProperty(value = "结转利润销售占比", example = "结转利润销售占比")
    private String xsjzlrzb;
    @ApiModelProperty(value = "结转利润自持有收入", example = "结转利润自持有收入")
    private String zcyjzlr;
    @ApiModelProperty(value = "结转利润自持有占比", example = "结转利润自持有占比")
    private String zcyjzlrzb;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getMjzlrl() {
        return mjzlrl;
    }

    public void setMjzlrl(String mjzlrl) {
        this.mjzlrl = mjzlrl;
    }

    public String getMjzlrlyj() {
        return mjzlrlyj;
    }

    public void setMjzlrlyj(String mjzlrlyj) {
        this.mjzlrlyj = mjzlrlyj;
    }

    public String getMjzlr() {
        return mjzlr;
    }

    public void setMjzlr(String mjzlr) {
        this.mjzlr = mjzlr;
    }

    public String getMjzlrt() {
        return mjzlrt;
    }

    public void setMjzlrt(String mjzlrt) {
        this.mjzlrt = mjzlrt;
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
