package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class KeyWorkLandOfMonth {
    @ApiModelProperty(value = "月份", example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "土地拓展完成率", example = "土地拓展完成率")
    private String tdtzly;
    @ApiModelProperty(value = "土地收储", example = "土地收储")
    private String tdtzy;
    @ApiModelProperty(value = "土地收储目标", example = "土地收储目标")
    private String tdtzty;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getTdtzly() {
        return tdtzly;
    }

    public void setTdtzly(String tdtzly) {
        this.tdtzly = tdtzly;
    }

    public String getTdtzy() {
        return tdtzy;
    }

    public void setTdtzy(String tdtzy) {
        this.tdtzy = tdtzy;
    }

    public String getTdtzty() {
        return tdtzty;
    }

    public void setTdtzty(String tdtzty) {
        this.tdtzty = tdtzty;
    }
}
