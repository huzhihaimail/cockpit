package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/15.
 */
@ApiModel
public class ProjectCost {
    @ApiModelProperty(value = "项目编码",example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称",example = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "项目成本目标值",example = "项目成本目标值")
    private String xmcbt;
    @ApiModelProperty(value = "项目成本",example = "项目成本")
    private String xmcb;
    @ApiModelProperty(value = "项目成本偏差率",example = "项目成本偏差率")
    private String mbcbpxl;

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

    public String getXmcbt() {
        return xmcbt;
    }

    public void setXmcbt(String xmcbt) {
        this.xmcbt = xmcbt;
    }

    public String getXmcb() {
        return xmcb;
    }

    public void setXmcb(String xmcb) {
        this.xmcb = xmcb;
    }

    public String getMbcbpxl() {
        return mbcbpxl;
    }

    public void setMbcbpxl(String mbcbpxl) {
        this.mbcbpxl = mbcbpxl;
    }
}
