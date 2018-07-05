package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CarryOverProfitOfMonth {

    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "结转利润目标完成率", example = "结转利润目标完成率")
    private String mjzlrl;
    @ApiModelProperty(value = "结转利润", example = "结转利润")
    private String mjzlr;
    @ApiModelProperty(value = "结转利润目标", example = "结转利润目标")
    private String mjzlrt;
    @ApiModelProperty(value = "结转利润目标完成率预警（1是正常 0是预警）", example = "结转利润目标完成率预警（1是正常 0是预警）")
    private String mjzlrlyj;

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

    public String getMjzlrlyj() {
        return mjzlrlyj;
    }

    public void setMjzlrlyj(String mjzlrlyj) {
        this.mjzlrlyj = mjzlrlyj;
    }
}
