package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jason.hu
 */
@ApiModel
public class ThirdLayerDetailPlan {

    @ApiModelProperty(value = "里程碑节点编码", example = "里程碑节点编码")
    private String nodeCode;

    @ApiModelProperty(value = "里程碑节点名称", example = "里程碑节点名称")
    private String nodeName;

    @ApiModelProperty(value = "里程碑节点类型", example = "里程碑节点类型")
    private String nodeType;

    @ApiModelProperty(value = "专业线", example = "专业线")
    private String lineType;

    @ApiModelProperty(value = "计划开始时间", example = "计划开始时间")
    private String pStartDate;

    @ApiModelProperty(value = "计划完成时间", example = "计划完成时间")
    private String pEndDate;

    @ApiModelProperty(value = "实际开始时间", example = "实际开始时间")
    private String aStartDate;

    @ApiModelProperty(value = "实际完成时间", example = "实际完成时间")
    private String aEndDate;

    @ApiModelProperty(value = "预警", example = "预警")
    private String yj;

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

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getpStartDate() {
        return pStartDate;
    }

    public void setpStartDate(String pStartDate) {
        this.pStartDate = pStartDate;
    }

    public String getpEndDate() {
        return pEndDate;
    }

    public void setpDndDate(String pEndDate) {
        this.pEndDate = pEndDate;
    }

    public String getaStartDate() {
        return aStartDate;
    }

    public void setaStartDate(String aStartDate) {
        this.aStartDate = aStartDate;
    }

    public String getaEndDate() {
        return aEndDate;
    }

    public void setaDndDate(String aDndDate) {
        this.aEndDate = aEndDate;
    }

    public String getYj() {
        return yj;
    }

    public void setYj(String yj) {
        this.yj = yj;
    }
}
