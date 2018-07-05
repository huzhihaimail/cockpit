package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class CityComDis {
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
    @ApiModelProperty(value = "签约金额月",example = "签约金额月")
    private String qyjem;
    @ApiModelProperty(value = "签约金额目标值月",example = "签约金额目标值月")
    private String qyjetm;
    @ApiModelProperty(value = "签约金额完成率月",example = "签约金额完成率月")
    private String qyjelm;
    @ApiModelProperty(value = "签约金额年",example = "签约金额年")
    private String qyjey;
    @ApiModelProperty(value = "签约金额目标值年",example = "签约金额目标值年")
    private String qyjety;
    @ApiModelProperty(value = "签约金额完成率年",example = "签约金额完成率年")
    private String qyjely;
    @ApiModelProperty(value = "认购金额月",example = "认购金额月")
    private String rgjem;
    @ApiModelProperty(value = "认购金额目标值月",example = "认购金额目标值月")
    private String rgjetm;
    @ApiModelProperty(value = "认购金额完成率月",example = "认购金额完成率月")
    private String rgjelm;
    @ApiModelProperty(value = "认购金额年",example = "认购金额年")
    private String rgjey;
    @ApiModelProperty(value = "认购金额目标值年",example = "认购金额目标值年")
    private String rgjety;
    @ApiModelProperty(value = "认购金额完成率年",example = "认购金额完成率年")
    private String rgjely;

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

    public String getQyjem() {
        return qyjem;
    }

    public void setQyjem(String qyjem) {
        this.qyjem = qyjem;
    }

    public String getQyjetm() {
        return qyjetm;
    }

    public void setQyjetm(String qyjetm) {
        this.qyjetm = qyjetm;
    }

    public String getQyjelm() {
        return qyjelm;
    }

    public void setQyjelm(String qyjelm) {
        this.qyjelm = qyjelm;
    }

    public String getQyjey() {
        return qyjey;
    }

    public void setQyjey(String qyjey) {
        this.qyjey = qyjey;
    }

    public String getQyjety() {
        return qyjety;
    }

    public void setQyjety(String qyjety) {
        this.qyjety = qyjety;
    }

    public String getQyjely() {
        return qyjely;
    }

    public void setQyjely(String qyjely) {
        this.qyjely = qyjely;
    }

    public String getRgjem() {
        return rgjem;
    }

    public void setRgjem(String rgjem) {
        this.rgjem = rgjem;
    }

    public String getRgjetm() {
        return rgjetm;
    }

    public void setRgjetm(String rgjetm) {
        this.rgjetm = rgjetm;
    }

    public String getRgjelm() {
        return rgjelm;
    }

    public void setRgjelm(String rgjelm) {
        this.rgjelm = rgjelm;
    }

    public String getRgjey() {
        return rgjey;
    }

    public void setRgjey(String rgjey) {
        this.rgjey = rgjey;
    }

    public String getRgjety() {
        return rgjety;
    }

    public void setRgjety(String rgjety) {
        this.rgjety = rgjety;
    }

    public String getRgjely() {
        return rgjely;
    }

    public void setRgjely(String rgjely) {
        this.rgjely = rgjely;
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
