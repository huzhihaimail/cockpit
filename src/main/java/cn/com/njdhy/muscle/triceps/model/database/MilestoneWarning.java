package cn.com.njdhy.muscle.triceps.model.database;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jasoon.hu
 */
@ApiModel
public class MilestoneWarning {

    @ApiModelProperty(value = "里程碑阶段ID", example = "里程碑阶段ID")
    private String nodeCode;

    @ApiModelProperty(value = "里程碑名称", example = "里程碑名称")
    private String nodeName;

    @ApiModelProperty(value = "里程碑排列顺序", example = "里程碑排列顺序")
    private String nodeSeq;

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

    public String getNodeSeq() {
        return nodeSeq;
    }

    public void setNodeSeq(String nodeSeq) {
        this.nodeSeq = nodeSeq;
    }

    public String getYj() {
        return yj;
    }

    public void setYj(String yj) {
        this.yj = yj;
    }
}
