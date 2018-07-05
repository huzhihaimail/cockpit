package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jason.hu
 */
@ApiModel
public class OneLevelPlan {

    @ApiModelProperty(value = "一级计划按时完成数", example = "一级计划按时完成数")
    private String yjanwcs;

    @ApiModelProperty(value = "一级计划逾期完成数", example = "一级计划逾期完成数")
    private String yjyqwcs;

    @ApiModelProperty(value = "一级完成数", example = "一级完成数")
    private String yjwcs;

    @ApiModelProperty(value = "一级未完成数", example = "一级未完成数")
    private String yjwwcs;

    @ApiModelProperty(value = "一级计划完成率", example = "一级计划完成率")
    private String yjjhecl;

    public String getYjanwcs() {
        return yjanwcs;
    }

    public void setYjanwcs(String yjanwcs) {
        this.yjanwcs = yjanwcs;
    }

    public String getYjyqwcs() {
        return yjyqwcs;
    }

    public void setYjyqwcs(String yjyqwcs) {
        this.yjyqwcs = yjyqwcs;
    }

    public String getYjwcs() {
        return yjwcs;
    }

    public void setYjwcs(String yjwcs) {
        this.yjwcs = yjwcs;
    }

    public String getYjwwcs() {
        return yjwwcs;
    }

    public void setYjwwcs(String yjwwcs) {
        this.yjwwcs = yjwwcs;
    }

    public String getYjjhecl() {
        return yjjhecl;
    }

    public void setYjjhecl(String yjjhecl) {
        this.yjjhecl = yjjhecl;
    }
}
