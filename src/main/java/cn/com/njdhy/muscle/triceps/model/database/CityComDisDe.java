package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class CityComDisDe {
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
    @ApiModelProperty(value = "去化率月",example = "去化率月")
    private String qhlm;
    @ApiModelProperty(value = "去化率年",example = "去化率年")
    private String qhly;

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

    public String getQhlm() {
        return qhlm;
    }

    public void setQhlm(String qhlm) {
        this.qhlm = qhlm;
    }

    public String getQhly() {
        return qhly;
    }

    public void setQhly(String qhly) {
        this.qhly = qhly;
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
