package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/15.
 */
@ApiModel
public class FourTotal {
    @ApiModelProperty(value = "目标总投资",example = "目标总投资")
    private String ztzt;
    @ApiModelProperty(value = "动态总投资",example = "动态总投资")
    private String ztz;
    @ApiModelProperty(value = "超立项偏差金额",example = "超立项偏差金额")
    private String clxpcje;
    @ApiModelProperty(value = "超立项个数",example = "超立项个数")
    private String clxgs;

    public String getZtzt() {
        return ztzt;
    }

    public void setZtzt(String ztzt) {
        this.ztzt = ztzt;
    }

    public String getZtz() {
        return ztz;
    }

    public void setZtz(String ztz) {
        this.ztz = ztz;
    }

    public String getClxpcje() {
        return clxpcje;
    }

    public void setClxpcje(String clxpcje) {
        this.clxpcje = clxpcje;
    }

    public String getClxgs() {
        return clxgs;
    }

    public void setClxgs(String clxgs) {
        this.clxgs = clxgs;
    }
}
