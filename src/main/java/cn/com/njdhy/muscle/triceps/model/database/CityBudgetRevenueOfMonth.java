package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页分公司首页收入利润预算收入月度趋势实体
 */
@ApiModel
public class CityBudgetRevenueOfMonth {

    @ApiModelProperty(value = "年月", example = "年月")
    private String yearMonth;

    @ApiModelProperty(value = "预算收入目标完成率", example = "预算收入目标完成率")
    private String myssrl;
    @ApiModelProperty(value = "预算收入目标完成率预警（1是正常 0是预警）", example = "预算收入目标完成率预警（1是正常 0是预警）")
    private String myssrlyj;
    @ApiModelProperty(value = "预算收入(总收入)", example = "预算收入目标完成率预警（1是正常 0是预警）")
    private String myysr;
    @ApiModelProperty(value = "销售收入", example = "销售收入")
    private String xssr;
    @ApiModelProperty(value = "销售收入占比", example = "销售收入占比")
    private String xssrzb;
    @ApiModelProperty(value = "自持有收入", example = "自持有收入")
    private String zcysr;
    @ApiModelProperty(value = "自持有收入占比", example = "自持有收入占比")
    private String zcysrzb;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getMyssrl() {
        return myssrl;
    }

    public void setMyssrl(String myssrl) {
        this.myssrl = myssrl;
    }

    public String getMyssrlyj() {
        return myssrlyj;
    }

    public void setMyssrlyj(String myssrlyj) {
        this.myssrlyj = myssrlyj;
    }

    public String getMyysr() {
        return myysr;
    }

    public void setMyysr(String myysr) {
        this.myysr = myysr;
    }

    public String getXssr() {
        return xssr;
    }

    public void setXssr(String xssr) {
        this.xssr = xssr;
    }

    public String getXssrzb() {
        return xssrzb;
    }

    public void setXssrzb(String xssrzb) {
        this.xssrzb = xssrzb;
    }

    public String getZcysr() {
        return zcysr;
    }

    public void setZcysr(String zcysr) {
        this.zcysr = zcysr;
    }

    public String getZcysrzb() {
        return zcysrzb;
    }

    public void setZcysrzb(String zcysrzb) {
        this.zcysrzb = zcysrzb;
    }
}
