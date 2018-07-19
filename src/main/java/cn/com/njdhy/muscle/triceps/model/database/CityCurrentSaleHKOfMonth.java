package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页回款完成模块本月销售项目分布
 */
@ApiModel
public class CityCurrentSaleHKOfMonth {

    @ApiModelProperty(value = "年月", example = "年月")
    private String yearMonth;

    @ApiModelProperty(value = "回款完成金额率", example = "回款完成金额率")
    private String hkwclm;
    @ApiModelProperty(value = "回款完成金额", example = "回款完成金额")
    private String hkwcm;
    @ApiModelProperty(value = "回款完成目标", example = "回款完成目标")
    private String hkwctm;
    @ApiModelProperty(value = "回款完成金额率月预警（1是正常 0是预警）", example = "回款完成金额率月预警（1是正常 0是预警）")
    private String hkwclmyj;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getHkwclm() {
        return hkwclm;
    }

    public void setHkwclm(String hkwclm) {
        this.hkwclm = hkwclm;
    }

    public String getHkwcm() {
        return hkwcm;
    }

    public void setHkwcm(String hkwcm) {
        this.hkwcm = hkwcm;
    }

    public String getHkwctm() {
        return hkwctm;
    }

    public void setHkwctm(String hkwctm) {
        this.hkwctm = hkwctm;
    }

    public String getHkwclmyj() {
        return hkwclmyj;
    }

    public void setHkwclmyj(String hkwclmyj) {
        this.hkwclmyj = hkwclmyj;
    }
}
