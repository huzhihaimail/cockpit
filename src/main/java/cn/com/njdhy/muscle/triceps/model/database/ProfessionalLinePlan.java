package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jason.hu
 */
@ApiModel
public class ProfessionalLinePlan {

//    @ApiModelProperty(value = "前期", example = "前期")
//    private String qqwcs;
//
//    @ApiModelProperty(value = "前期总数", example = "前期总数")
//    private String qqwcsTotal;
//
//    @ApiModelProperty(value = "前期完成率", example = "前期完成率")
//    private String qqwcsLv;
//
//    @ApiModelProperty(value = "行政", example = "行政")
//    private String xzwcs;
//
//    @ApiModelProperty(value = "行政总数", example = "行政总数")
//    private String xzwcsTotal;
//
//    @ApiModelProperty(value = "行政完成率", example = "行政完成率")
//    private String xzwcsLv;
//
//    @ApiModelProperty(value = "营销", example = "营销")
//    private String xswcs;
//
//    @ApiModelProperty(value = "营销总数", example = "营销总数")
//    private String xswcsTotal;
//
//    @ApiModelProperty(value = "营销完成率", example = "营销完成率")
//    private String xswcsLv;
//
//    @ApiModelProperty(value = "营销", example = "营销")
//    private String yywcs;
//
//    @ApiModelProperty(value = "营销总数", example = "营销总数")
//    private String yywcsTotal;
//
//    @ApiModelProperty(value = "营销完成率", example = "营销完成率")
//    private String yywcsLv;
//
//    @ApiModelProperty(value = "设计", example = "设计")
//    private String sjwcs;
//
//    @ApiModelProperty(value = "设计总数", example = "设计总数")
//    private String sjwcsTotal;
//
//    @ApiModelProperty(value = "设计完成率", example = "设计完成率")
//    private String sjwcsLv;
//
//    @ApiModelProperty(value = "成本", example = "成本")
//    private String cbwcs;
//
//    @ApiModelProperty(value = "成本总数", example = "成本总数")
//    private String cbwcsTotal;
//
//    @ApiModelProperty(value = "成本完成率", example = "成本完成率")
//    private String cbwcsLv;
//
//    @ApiModelProperty(value = "采购", example = "采购")
//    private String cgwcs;
//
//    @ApiModelProperty(value = "采购总数", example = "采购总数")
//    private String cgwcsTotal;
//
//    @ApiModelProperty(value = "采购完成率", example = "采购完成率")
//    private String cgwcsLv;
//
//    @ApiModelProperty(value = "报建", example = "报建")
//    private String bjwcs;
//
//    @ApiModelProperty(value = "报建总数", example = "报建总数")
//    private String bjwcsTotal;
//
//    @ApiModelProperty(value = "报建完成率", example = "报建完成率")
//    private String bjwcsLv;

    @ApiModelProperty(value = "专业线", example = "专业线")
    private String lineType;

    @ApiModelProperty(value = "总完成数", example = "总完成数")
    private String WCS;

    @ApiModelProperty(value = "总数", example = "总数")
    private String WCST;

    @ApiModelProperty(value = "完成率", example = "完成率")
    private String WCSL;

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public void setWCS(String WCS) {
        this.WCS = WCS;
    }

    public void setWCST(String WCST) {
        this.WCST = WCST;
    }

    public void setWCSL(String WCSL) {
        this.WCSL = WCSL;
    }

    public String getLineType() {

        return lineType;
    }

    public String getWCS() {
        return WCS;
    }

    public String getWCST() {
        return WCST;
    }

    public String getWCSL() {
        return WCSL;
    }

//    public String getQqwcs() {
//        return qqwcs;
//    }
//
//    public void setQqwcs(String qqwcs) {
//        this.qqwcs = qqwcs;
//    }
//
//    public String getQqwcsTotal() {
//        return qqwcsTotal;
//    }
//
//    public void setQqwcsTotal(String qqwcsTotal) {
//        this.qqwcsTotal = qqwcsTotal;
//    }
//
//    public String getQqwcsLv() {
//        return qqwcsLv;
//    }
//
//    public void setQqwcsLv(String qqwcsLv) {
//        this.qqwcsLv = qqwcsLv;
//    }
//
//    public String getXzwcs() {
//        return xzwcs;
//    }
//
//    public void setXzwcs(String xzwcs) {
//        this.xzwcs = xzwcs;
//    }
//
//    public String getXzwcsTotal() {
//        return xzwcsTotal;
//    }
//
//    public void setXzwcsTotal(String xzwcsTotal) {
//        this.xzwcsTotal = xzwcsTotal;
//    }
//
//    public String getXzwcsLv() {
//        return xzwcsLv;
//    }
//
//    public void setXzwcsLv(String xzwcsLv) {
//        this.xzwcsLv = xzwcsLv;
//    }
//
//    public String getYywcs() {
//        return yywcs;
//    }
//
//    public void setYywcs(String yywcs) {
//        this.yywcs = yywcs;
//    }
//
//    public String getYywcsTotal() {
//        return yywcsTotal;
//    }
//
//    public void setYywcsTotal(String yywcsTotal) {
//        this.yywcsTotal = yywcsTotal;
//    }
//
//    public String getYywcsLv() {
//        return yywcsLv;
//    }
//
//    public void setYywcsLv(String yywcsLv) {
//        this.yywcsLv = yywcsLv;
//    }
//
//    public String getSjwcs() {
//        return sjwcs;
//    }
//
//    public void setSjwcs(String sjwcs) {
//        this.sjwcs = sjwcs;
//    }
//
//    public String getSjwcsTotal() {
//        return sjwcsTotal;
//    }
//
//    public void setSjwcsTotal(String sjwcsTotal) {
//        this.sjwcsTotal = sjwcsTotal;
//    }
//
//    public String getSjwcsLv() {
//        return sjwcsLv;
//    }
//
//    public void setSjwcsLv(String sjwcsLv) {
//        this.sjwcsLv = sjwcsLv;
//    }
//
//    public String getCbwcs() {
//        return cbwcs;
//    }
//
//    public void setCbwcs(String cbwcs) {
//        this.cbwcs = cbwcs;
//    }
//
//    public String getCbwcsTotal() {
//        return cbwcsTotal;
//    }
//
//    public void setCbwcsTotal(String cbwcsTotal) {
//        this.cbwcsTotal = cbwcsTotal;
//    }
//
//    public String getCbwcsLv() {
//        return cbwcsLv;
//    }
//
//    public void setCbwcsLv(String cbwcsLv) {
//        this.cbwcsLv = cbwcsLv;
//    }
//
//    public String getCgwcs() {
//        return cgwcs;
//    }
//
//    public void setCgwcs(String cgwcs) {
//        this.cgwcs = cgwcs;
//    }
//
//    public String getCgwcsTotal() {
//        return cgwcsTotal;
//    }
//
//    public void setCgwcsTotal(String cgwcsTotal) {
//        this.cgwcsTotal = cgwcsTotal;
//    }
//
//    public String getCgwcsLv() {
//        return cgwcsLv;
//    }
//
//    public void setCgwcsLv(String cgwcsLv) {
//        this.cgwcsLv = cgwcsLv;
//    }
//
//    public String getBjwcs() {
//        return bjwcs;
//    }
//
//    public void setBjwcs(String bjwcs) {
//        this.bjwcs = bjwcs;
//    }
//
//    public String getBjwcsTotal() {
//        return bjwcsTotal;
//    }
//
//    public void setBjwcsTotal(String bjwcsTotal) {
//        this.bjwcsTotal = bjwcsTotal;
//    }
//
//    public String getBjwcsLv() {
//        return bjwcsLv;
//    }
//
//    public void setBjwcsLv(String bjwcsLv) {
//        this.bjwcsLv = bjwcsLv;
//    }
//
//    public String getXswcs() {
//        return xswcs;
//    }
//
//    public void setXswcs(String xswcs) {
//        this.xswcs = xswcs;
//    }
//
//    public String getXswcsTotal() {
//        return xswcsTotal;
//    }
//
//    public void setXswcsTotal(String xswcsTotal) {
//        this.xswcsTotal = xswcsTotal;
//    }
//
//    public String getXswcsLv() {
//        return xswcsLv;
//    }
//
//    public void setXswcsLv(String xswcsLv) {
//        this.xswcsLv = xswcsLv;
//    }
}
