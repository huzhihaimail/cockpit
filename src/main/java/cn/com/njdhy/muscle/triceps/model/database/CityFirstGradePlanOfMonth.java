package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CityFirstGradePlanOfMonth {

    @ApiModelProperty(value = "年月", example = "年月")
    private String yearMonth;

    @ApiModelProperty(value = "一级计划完成率月", example = "一级计划完成率")
    private String yjjhlm;
    @ApiModelProperty(value = "一级计划完成数月", example = "一级计划完成数")
    private String yjjhm;
    @ApiModelProperty(value = "一级计划完成目标月", example = "一级计划完成目标")
    private String yjjhtm;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getYjjhlm() {
        return yjjhlm;
    }

    public void setYjjhlm(String yjjhlm) {
        this.yjjhlm = yjjhlm;
    }

    public String getYjjhm() {
        return yjjhm;
    }

    public void setYjjhm(String yjjhm) {
        this.yjjhm = yjjhm;
    }

    public String getYjjhtm() {
        return yjjhtm;
    }

    public void setYjjhtm(String yjjhtm) {
        this.yjjhtm = yjjhtm;
    }
}
