package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class CityComDisRe {
    @ApiModelProperty(value = "城市公司ID",example = "城市公司ID")
    private String areaId;
    @ApiModelProperty(value = "城市公司编码",example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称",example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "项目Id",example = "项目Id")
    private String projectId;
    @ApiModelProperty(value = "项目编码",example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称",example = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "回款金额月",example = "回款金额月")
    private String hkjem;
    @ApiModelProperty(value = "回款金额目标值月",example = "回款金额目标值月")
    private String hkjetm;
    @ApiModelProperty(value = "回款金额完成率月",example = "回款金额完成率月")
    private String hkjelm;
    @ApiModelProperty(value = "回款金额年",example = "回款金额年")
    private String hkjey;
    @ApiModelProperty(value = "回款金额目标值年",example = "回款金额目标值年")
    private String hkjety;
    @ApiModelProperty(value = "回款金额完成率年",example = "回款金额完成率年")
    private String hkjely;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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
}
