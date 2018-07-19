package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级首页回款完成模块本月销售项目分布
 */
@ApiModel
public class CityCurrentSaleHK {

    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "项目编码", example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "回款完成金额率", example = "回款完成金额率")
    private String hkwcl;
    @ApiModelProperty(value = "回款完成金额", example = "回款完成金额")
    private String hkwc;
    @ApiModelProperty(value = "回款完成目标", example = "回款完成目标")
    private String hkwct;
    @ApiModelProperty(value = "回款完成金额率月预警（1是正常 0是预警）", example = "回款完成金额率月预警（1是正常 0是预警）")
    private String hkwclmyj;

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

    public String getHkwcl() {
        return hkwcl;
    }

    public void setHkwcl(String hkwcl) {
        this.hkwcl = hkwcl;
    }

    public String getHkwc() {
        return hkwc;
    }

    public void setHkwc(String hkwc) {
        this.hkwc = hkwc;
    }

    public String getHkwct() {
        return hkwct;
    }

    public void setHkwct(String hkwct) {
        this.hkwct = hkwct;
    }

    public String getHkwclmyj() {
        return hkwclmyj;
    }

    public void setHkwclmyj(String hkwclmyj) {
        this.hkwclmyj = hkwclmyj;
    }
}
