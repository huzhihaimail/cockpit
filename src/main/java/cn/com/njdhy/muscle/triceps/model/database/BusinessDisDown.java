package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class BusinessDisDown {
    @ApiModelProperty(value = "回款金额月", example = "回款金额月")
    private String hkjem;
    @ApiModelProperty(value = "回款金额目标值月", example = "回款金额目标值月")
    private String hkjetm;
    @ApiModelProperty(value = "回款金额完成率月", example = "回款金额完成率月")
    private String hkjelm;
    @ApiModelProperty(value = "回款金额完成率月预警", example = "回款金额完成率月预警")
    private String hkjelmyj;

    @ApiModelProperty(value = "回款金额年", example = "回款金额年")
    private String hkjey;
    @ApiModelProperty(value = "回款金额目标值年", example = "回款金额目标值年")
    private String hkjety;
    @ApiModelProperty(value = "回款金额完成率年", example = "回款金额完成率年")
    private String hkjely;
    @ApiModelProperty(value = "回款金额完成率年预警", example = "回款金额完成率年预警")
    private String hkjelyyj;

    @ApiModelProperty(value = "回款金额全周期", example = "回款金额全周期")
    private String hkjeqp;
    @ApiModelProperty(value = "回款金额目标值全周期", example = "回款金额目标值全周期")
    private String hkjetqp;
    @ApiModelProperty(value = "回款金额完成率全周期", example = "回款金额完成率全周期")
    private String hkjelqp;
    @ApiModelProperty(value = "回款金额完成率全周期预警", example = "回款金额完成率全周期预警")
    private String hkjelqpyj;

    public String getHkjelmyj() {
        return hkjelmyj;
    }

    public void setHkjelmyj(String hkjelmyj) {
        this.hkjelmyj = hkjelmyj;
    }

    public String getHkjelyyj() {
        return hkjelyyj;
    }

    public void setHkjelyyj(String hkjelyyj) {
        this.hkjelyyj = hkjelyyj;
    }

    public String getHkjelqpyj() {
        return hkjelqpyj;
    }

    public void setHkjelqpyj(String hkjelqpyj) {
        this.hkjelqpyj = hkjelqpyj;
    }

    public String getHkjem() {
        return hkjem;
    }

    public void setHkjem(String hkjem) {
        this.hkjem = hkjem;
    }

    public String getHkjetm() {
        return hkjetm;
    }

    public void setHkjetm(String hkjetm) {
        this.hkjetm = hkjetm;
    }

    public String getHkjelm() {
        return hkjelm;
    }

    public void setHkjelm(String hkjelm) {
        this.hkjelm = hkjelm;
    }

    public String getHkjey() {
        return hkjey;
    }

    public void setHkjey(String hkjey) {
        this.hkjey = hkjey;
    }

    public String getHkjety() {
        return hkjety;
    }

    public void setHkjety(String hkjety) {
        this.hkjety = hkjety;
    }

    public String getHkjely() {
        return hkjely;
    }

    public void setHkjely(String hkjely) {
        this.hkjely = hkjely;
    }

    public String getHkjeqp() {
        return hkjeqp;
    }

    public void setHkjeqp(String hkjeqp) {
        this.hkjeqp = hkjeqp;
    }

    public String getHkjetqp() {
        return hkjetqp;
    }

    public void setHkjetqp(String hkjetqp) {
        this.hkjetqp = hkjetqp;
    }

    public String getHkjelqp() {
        return hkjelqp;
    }

    public void setHkjelqp(String hkjelqp) {
        this.hkjelqp = hkjelqp;
    }
}
