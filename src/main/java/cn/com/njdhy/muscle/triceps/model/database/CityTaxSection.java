package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CityTaxSection {

    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "项目编码", example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "节税目标完成率", example = "节税目标完成率")
    private String jswcl;
    @ApiModelProperty(value = "节税金额", example = "节税金额")
    private String jswc;
    @ApiModelProperty(value = "节税金额目标", example = "节税金额目标")
    private String jswct;
    @ApiModelProperty(value = "节税目标完成率预警（1是正常 0是预警）", example = "节税目标完成率预警（1是正常 0是预警）")
    private String jswclyj;

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

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getJswcl() {
        return jswcl;
    }

    public void setJswcl(String jswcl) {
        this.jswcl = jswcl;
    }

    public String getJswc() {
        return jswc;
    }

    public void setJswc(String jswc) {
        this.jswc = jswc;
    }

    public String getJswct() {
        return jswct;
    }

    public void setJswct(String jswct) {
        this.jswct = jswct;
    }

    public String getJswclyj() {
        return jswclyj;
    }

    public void setJswclyj(String jswclyj) {
        this.jswclyj = jswclyj;
    }
}

