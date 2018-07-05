package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class TaxSectionOfMonth {

    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "节税目标完成率", example = "节税目标完成率")
    private String mjswcl;
    @ApiModelProperty(value = "节税金额", example = "节税金额")
    private String mjswc;
    @ApiModelProperty(value = "节税金额目标", example = "节税金额目标")
    private String mjswct;
    @ApiModelProperty(value = "节税目标完成率预警（1是正常 0是预警）", example = "节税目标完成率预警（1是正常 0是预警）")
    private String mjswclyj;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getMjswcl() {
        return mjswcl;
    }

    public void setMjswcl(String mjswcl) {
        this.mjswcl = mjswcl;
    }

    public String getMjswc() {
        return mjswc;
    }

    public void setMjswc(String mjswc) {
        this.mjswc = mjswc;
    }

    public String getMjswct() {
        return mjswct;
    }

    public void setMjswct(String mjswct) {
        this.mjswct = mjswct;
    }

    public String getMjswclyj() {
        return mjswclyj;
    }

    public void setMjswclyj(String mjswclyj) {
        this.mjswclyj = mjswclyj;
    }
}
