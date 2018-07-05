package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class KeyWorkForDialog {

    @ApiModelProperty(value = "地区code", example = "地区code")
    private String areaCode;
    @ApiModelProperty(value = "区域名称", example = "区域名称")
    private String areaName;
    @ApiModelProperty(value = "重点工作完成率", example = "重点工作完成率")
    private String zdgzly;
    @ApiModelProperty(value = "滞后数", example = "滞后数")
    private String zhsy;
    @ApiModelProperty(value = "重点工作总数", example = "重点工作总数")
    private String zdgzty;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getZdgzly() {
        return zdgzly;
    }

    public void setZdgzly(String zdgzly) {
        this.zdgzly = zdgzly;
    }

    public String getZhsy() {
        return zhsy;
    }

    public void setZhsy(String zhsy) {
        this.zhsy = zhsy;
    }

    public String getZdgzty() {
        return zdgzty;
    }

    public void setZdgzty(String zdgzty) {
        this.zdgzty = zdgzty;
    }
}
