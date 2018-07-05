package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class BudgetRevenueOfMonth {

    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "预算收入目标完成率", example = "预算收入目标完成率")
    private String myssrl;
    @ApiModelProperty(value = "预算收入目标完成率预警（1是正常 0是预警）", example = "预算收入目标完成率预警（1是正常 0是预警）")
    private String myssrlyj;
    @ApiModelProperty(value = "销售收入", example = "销售收入")
    private String xssr;
    @ApiModelProperty(value = "销售收入占比", example = "销售收入占比")
    private String xssrzb;
    @ApiModelProperty(value = "自持有收入", example = "自持有收入")
    private String zcysr;
    @ApiModelProperty(value = "自持有收入占比", example = "自持有收入占比")
    private String zcysrzb;

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public void setMyssrl(String myssrl) {
        this.myssrl = myssrl;
    }

    public void setMyssrlyj(String myssrlyj) {
        this.myssrlyj = myssrlyj;
    }

    public void setXssr(String xssr) {
        this.xssr = xssr;
    }

    public void setXssrzb(String xssrzb) {
        this.xssrzb = xssrzb;
    }

    public void setZcysr(String zcysr) {
        this.zcysr = zcysr;
    }

    public void setZcysrzb(String zcysrzb) {
        this.zcysrzb = zcysrzb;
    }

    public String getYearMonth() {

        return yearMonth;
    }

    public String getMyssrl() {
        return myssrl;
    }

    public String getMyssrlyj() {
        return myssrlyj;
    }

    public String getXssr() {
        return xssr;
    }

    public String getXssrzb() {
        return xssrzb;
    }

    public String getZcysr() {
        return zcysr;
    }

    public String getZcysrzb() {
        return zcysrzb;
    }
}
