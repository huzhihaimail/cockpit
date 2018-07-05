package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class AgencySubscribeUp {
    @ApiModelProperty(value = "业态",example = "业态")
    private String chanpin;
    @ApiModelProperty(value = "签约金额年",example = "签约金额年")
    private String qyjey;
    @ApiModelProperty(value = "签约金额全盘",example = "签约金额全盘")
    private String qyjeqp;
    @ApiModelProperty(value = "认购金额年",example = "认购金额年")
    private String rgjey;
    @ApiModelProperty(value = "认购金额全盘",example = "认购金额全盘")
    private String rgjeqp;

    public String getChanpin() {
        return chanpin;
    }

    public void setChanpin(String chanpin) {
        this.chanpin = chanpin;
    }

    public String getQyjey() {
        return qyjey;
    }

    public void setQyjey(String qyjey) {
        this.qyjey = qyjey;
    }

    public String getQyjeqp() {
        return qyjeqp;
    }

    public void setQyjeqp(String qyjeqp) {
        this.qyjeqp = qyjeqp;
    }

    public String getRgjey() {
        return rgjey;
    }

    public void setRgjey(String rgjey) {
        this.rgjey = rgjey;
    }

    public String getRgjeqp() {
        return rgjeqp;
    }

    public void setRgjeqp(String rgjeqp) {
        this.rgjeqp = rgjeqp;
    }
}
