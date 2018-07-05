package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TwoLevelPlan {

    @ApiModelProperty(value = "二级计划按时完成数", example = "二级计划按时完成数")
    private String ejanwcs;

    @ApiModelProperty(value = "二级计划逾期完成数", example = "二级计划逾期完成数")
    private String ejyqwcs;

    @ApiModelProperty(value = "二级完成数", example = "二级完成数")
    private String ejwcs;

    @ApiModelProperty(value = "二级未完成数", example = "二级未完成数")
    private String ejwwc;

    @ApiModelProperty(value = "二级计划完成率", example = "二级计划完成率")
    private String ejjhwcl;

    public String getEjanwcs() {
        return ejanwcs;
    }

    public void setEjanwcs(String ejanwcs) {
        this.ejanwcs = ejanwcs;
    }

    public String getEjyqwcs() {
        return ejyqwcs;
    }

    public void setEjyqwcs(String ejyqwcs) {
        this.ejyqwcs = ejyqwcs;
    }

    public String getEjwcs() {
        return ejwcs;
    }

    public void setEjwcs(String ejwcs) {
        this.ejwcs = ejwcs;
    }

    public String getEjwwc() {
        return ejwwc;
    }

    public void setEjwwc(String ejwwc) {
        this.ejwwc = ejwwc;
    }

    public String getEjjhwcl() {
        return ejjhwcl;
    }

    public void setEjjhwcl(String ejjhwcl) {
        this.ejjhwcl = ejjhwcl;
    }
}
