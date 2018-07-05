package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class GoodsValueDis {
    @ApiModelProperty(value = "业态",example = "业态")
    private String chanpin;
    @ApiModelProperty(value = "总货值",example = "总货值")
    private String zhzy;
    @ApiModelProperty(value = "已售货值",example = "已售货值")
    private String yshzy;
    @ApiModelProperty(value = "剩余货值",example = "剩余货值")
    private String syhzy;

    public String getChanpin() {
        return chanpin;
    }

    public void setChanpin(String chanpin) {
        this.chanpin = chanpin;
    }

    public String getZhzy() {
        return zhzy;
    }

    public void setZhzy(String zhzy) {
        this.zhzy = zhzy;
    }

    public String getYshzy() {
        return yshzy;
    }

    public void setYshzy(String yshzy) {
        this.yshzy = yshzy;
    }

    public String getSyhzy() {
        return syhzy;
    }

    public void setSyhzy(String syhzy) {
        this.syhzy = syhzy;
    }
}
