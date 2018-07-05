package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CurrentSaleHKOfMonth {

    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "回款完成金额率", example = "回款完成金额率")
    private String hkwclm;
    @ApiModelProperty(value = "回款完成金额率月预警（1是正常 0是预警）", example = "回款完成金额率月预警（1是正常 0是预警）")
    private String hkwclmyj;
    @ApiModelProperty(value = "回款完成金额月", example = "回款完成金额月")
    private String hkwcm;
    @ApiModelProperty(value = "回款完成目标月", example = "回款完成目标月")
    private String hkwctm;

    public String getHkwclm() {
        return hkwclm;
    }

    public void setHkwclm(String hkwclm) {
        this.hkwclm = hkwclm;
    }

    public String getHkwclmyj() {
        return hkwclmyj;
    }

    public void setHkwclmyj(String hkwclmyj) {
        this.hkwclmyj = hkwclmyj;
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

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }
}
