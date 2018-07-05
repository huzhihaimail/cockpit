package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class BudgetRevenue {
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "预算收入目标完成率", example = "预算收入目标完成率")
    private String yssrl;
    @ApiModelProperty(value = "营业收入", example = "营业收入")
    private String yysr;
    @ApiModelProperty(value = "营业收入目标", example = "营业收入目标")
    private String yysrt;
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

    public void setMyssrlyj(String myssrlyj) {
        this.myssrlyj = myssrlyj;
    }

    public String getMyssrlyj() {

        return myssrlyj;
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

    public String getYssrl() {
        return yssrl;
    }

    public void setYssrl(String yssrl) {
        this.yssrl = yssrl;
    }

    public String getYysr() {
        return yysr;
    }

    public void setYysr(String yysr) {
        this.yysr = yysr;
    }

    public String getYysrt() {
        return yysrt;
    }

    public void setYysrt(String yysrt) {
        this.yysrt = yysrt;
    }
}
