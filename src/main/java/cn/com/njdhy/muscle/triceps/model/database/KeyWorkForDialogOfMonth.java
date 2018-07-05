package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class KeyWorkForDialogOfMonth {

    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "重点工作完成率", example = "重点工作完成率")
    private String zdgzly;
    @ApiModelProperty(value = "滞后数", example = "滞后数")
    private String zhsy;
    @ApiModelProperty(value = "重点工作总数", example = "重点工作总数")
    private String zdgzty;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getZdgzly() {
        return zdgzly;
    }

    public void setZdgzly(String zdgzly) {
        this.zdgzly = zdgzly;
    }

    public String getZhsy() {
        return zhsy;
    }

    public void setZhsy(String zhsy) {
        this.zhsy = zhsy;
    }

    public String getZdgzty() {
        return zdgzty;
    }

    public void setZdgzty(String zdgzty) {
        this.zdgzty = zdgzty;
    }
}
