package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class KeyWork {
    @ApiModelProperty(value = "重点工作完成率", example = "重点工作完成率")
    private String zdgzl;
    @ApiModelProperty(value = "滞后数", example = "滞后数")
    private String zhs;
    @ApiModelProperty(value = "重点工作总数", example = "重点工作总数")
    private String zdgzt;

    public String getZdgzl() {
        return zdgzl;
    }

    public void setZdgzl(String zdgzl) {
        this.zdgzl = zdgzl;
    }

    public String getZhs() {
        return zhs;
    }

    public void setZhs(String zhs) {
        this.zhs = zhs;
    }

    public String getZdgzt() {
        return zdgzt;
    }

    public void setZdgzt(String zdgzt) {
        this.zdgzt = zdgzt;
    }

}
