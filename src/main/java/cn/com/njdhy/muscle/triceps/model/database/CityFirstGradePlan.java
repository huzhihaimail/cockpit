package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CityFirstGradePlan {

    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "项目编码", example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "一级计划完成率月", example = "一级计划完成率")
    private String yjjhl;
    @ApiModelProperty(value = "一级计划完成数月", example = "一级计划完成数")
    private String yjjh;
    @ApiModelProperty(value = "一级计划完成目标月", example = "一级计划完成目标")
    private String yjjht;

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

    public String getYjjhl() {
        return yjjhl;
    }

    public void setYjjhl(String yjjhl) {
        this.yjjhl = yjjhl;
    }

    public String getYjjh() {
        return yjjh;
    }

    public void setYjjh(String yjjh) {
        this.yjjh = yjjh;
    }

    public String getYjjht() {
        return yjjht;
    }

    public void setYjjht(String yjjht) {
        this.yjjht = yjjht;
    }
}
