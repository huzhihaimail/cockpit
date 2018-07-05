package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/19.
 */
@ApiModel
public class DetailPlan {
    @ApiModelProperty(value = "项目编码",example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称",example = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "里程碑节点编码",example = "里程碑节点编码")
    private String nodeCode;
    @ApiModelProperty(value = "里程碑名称",example = "里程碑名称")
    private String nodeName;
    @ApiModelProperty(value = "计划完成时间",example = "计划完成时间")
    private String pEndDate;
    @ApiModelProperty(value = "实际完成时间",example = "实际完成时间")
    private String aEndDate;
    @ApiModelProperty(value="预警",example = "预警")
    private String yj;

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

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getpEndDate() {
        return pEndDate;
    }

    public void setpEndDate(String pEndDate) {
        this.pEndDate = pEndDate;
    }

    public String getaEndDate() {
        return aEndDate;
    }

    public void setaEndDate(String aEndDate) {
        this.aEndDate = aEndDate;
    }

    public String getYj() {
        return yj;
    }

    public void setYj(String yj) {
        this.yj = yj;
    }
}
