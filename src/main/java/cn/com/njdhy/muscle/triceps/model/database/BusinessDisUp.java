package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class BusinessDisUp {
    @ApiModelProperty(value = "业态",example = "业态")
    private String chanpin;
    @ApiModelProperty(value = "回款金额年",example = "回款金额年")
    private String hkjey;
    @ApiModelProperty(value = "回款金额全盘",example = "回款金额全盘")
    private String zphkjey;

    public String getChanpin() {
        return chanpin;
    }

    public void setChanpin(String chanpin) {
        this.chanpin = chanpin;
    }

    public String getHkjey() {
        return hkjey;
    }

    public void setHkjey(String hkjey) {
        this.hkjey = hkjey;
    }

    public String getZphkjey() {
        return zphkjey;
    }

    public void setZphkjey(String zphkjey) {
        this.zphkjey = zphkjey;
    }
}
