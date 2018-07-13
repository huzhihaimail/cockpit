package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CarryOverProfit {
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "结转利润目标完成率", example = "结转利润目标完成率")
    private String jzlrl;
    @ApiModelProperty(value = "结转利润", example = "结转利润")
    private String jzlr;
    @ApiModelProperty(value = "结转利润目标", example = "结转利润目标")
    private String jzlrt;
    @ApiModelProperty(value = "结转利润目标完成率预警（1是正常 0是预警）", example = "结转利润目标完成率预警（1是正常 0是预警）")
    private String mjzlrlyj;


    @ApiModelProperty(value = "结转利润销售收入", example = "结转利润销售收入")
    private String xsjzlr;
    @ApiModelProperty(value = "结转利润销售占比", example = "结转利润销售占比")
    private String xsjzlrzb;
    @ApiModelProperty(value = "结转利润自持有收入", example = "结转利润自持有收入")
    private String zcyjzlr;
    @ApiModelProperty(value = "结转利润自持有占比", example = "结转利润自持有占比")
    private String zcyjzlrzb;


    public void setMjzlrlyj(String mjzlrlyj) {
        this.mjzlrlyj = mjzlrlyj;
    }

    public String getMjzlrlyj() {

        return mjzlrlyj;
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

    public String getJzlrl() {
        return jzlrl;
    }

    public void setJzlrl(String jzlrl) {
        this.jzlrl = jzlrl;
    }

    public String getJzlr() {
        return jzlr;
    }

    public void setJzlr(String jzlr) {
        this.jzlr = jzlr;
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

    public String getJzlrt() {
        return jzlrt;
    }

    public void setJzlrt(String jzlrt) {
        this.jzlrt = jzlrt;
    }
}
