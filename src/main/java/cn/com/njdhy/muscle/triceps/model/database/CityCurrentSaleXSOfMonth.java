package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页销售完成模块本月销售月度趋势
 */
@ApiModel
public class CityCurrentSaleXSOfMonth {

    @ApiModelProperty(value = "年月", example = "年月")
    private String yearMonth;

    @ApiModelProperty(value = "销售完成率", example = "销售完成率")
    private String xswclm;
    @ApiModelProperty(value = "销售完成率月预警（1是正常 0是预警）", example = "销售完成率月预警（1是正常 0是预警）")
    private String xswclmyj;
    @ApiModelProperty(value = "销售金额", example = "销售金额")
    private String xswcm;
    @ApiModelProperty(value = "销售目标", example = "销售目标")
    private String xswctm;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getXswclm() {
        return xswclm;
    }

    public void setXswclm(String xswclm) {
        this.xswclm = xswclm;
    }

    public String getXswclmyj() {
        return xswclmyj;
    }

    public void setXswclmyj(String xswclmyj) {
        this.xswclmyj = xswclmyj;
    }

    public String getXswcm() {
        return xswcm;
    }

    public void setXswcm(String xswcm) {
        this.xswcm = xswcm;
    }

    public String getXswctm() {
        return xswctm;
    }

    public void setXswctm(String xswctm) {
        this.xswctm = xswctm;
    }
}
