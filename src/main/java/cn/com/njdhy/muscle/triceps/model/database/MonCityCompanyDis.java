package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class MonCityCompanyDis {
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "月度收入完成率", example = "月度收入完成率")
    private String srwcl;

    @ApiModelProperty(value = "月度收入完成率目标值", example = "月度收入完成率目标值")
    private String srwclt;
    @ApiModelProperty(value = "月度收入完成率", example = "月度收入完成率")
    private String yj;

    @ApiModelProperty(value = "月度收入", example = "月度收入")
    private String sr;

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

    public String getSrwcl() {
        return srwcl;
    }

    public void setSrwcl(String srwcl) {
        this.srwcl = srwcl;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public void setSrwclt(String srwclt) {
        this.srwclt = srwclt;
    }

    public void setYj(String yj) {
        this.yj = yj;
    }

    public String getSrwclt() {

        return srwclt;
    }

    public String getYj() {
        return yj;
    }
}
