package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class SaleAndReturn {
    @ApiModelProperty(value = "城市公司ID", example = "城市公司ID")
    private String areaId;
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "昨日认购",example = "昨日认购")
    private String zrrg;
    @ApiModelProperty(value = "昨日签约",example = "昨日签约")
    private String zrqy;
    @ApiModelProperty(value = "认购未签约",example = "认购未签约")
    private String rgwqy;
    @ApiModelProperty(value = "昨日回款",example = "昨日回款")
    private String hkje;
    @ApiModelProperty(value = "签约逾期未回款",example = "签约逾期未回款")
    private String qyyqwhk;

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

    public String getZrrg() {
        return zrrg;
    }

    public void setZrrg(String zrrg) {
        this.zrrg = zrrg;
    }

    public String getZrqy() {
        return zrqy;
    }

    public void setZrqy(String zrqy) {
        this.zrqy = zrqy;
    }

    public String getRgwqy() {
        return rgwqy;
    }

    public void setRgwqy(String rgwqy) {
        this.rgwqy = rgwqy;
    }

    public String getHkje() {
        return hkje;
    }

    public void setHkje(String hkje) {
        this.hkje = hkje;
    }

    public String getQyyqwhk() {
        return qyyqwhk;
    }

    public void setQyyqwhk(String qyyqwhk) {
        this.qyyqwhk = qyyqwhk;
    }
}
