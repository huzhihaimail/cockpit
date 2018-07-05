package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class KeyWorkLand {
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "土地拓展完成率", example = "土地拓展完成率")
    private String tdtzl;
    @ApiModelProperty(value = "土地收储", example = "土地收储")
    private String tdtz;
    @ApiModelProperty(value = "土地收储目标", example = "土地收储目标")
    private String tdtzt;
    @ApiModelProperty(value = "指标编码", example = "指标编码")
    private String accountCode;
    @ApiModelProperty(value = "指标名称", example = "指标名称")
    private String accountName;

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

    public String getTdtzl() {
        return tdtzl;
    }

    public void setTdtzl(String tdtzl) {
        this.tdtzl = tdtzl;
    }

    public String getTdtz() {
        return tdtz;
    }

    public void setTdtz(String tdtz) {
        this.tdtz = tdtz;
    }

    public String getTdtzt() {
        return tdtzt;
    }

    public void setTdtzt(String tdtzt) {
        this.tdtzt = tdtzt;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
