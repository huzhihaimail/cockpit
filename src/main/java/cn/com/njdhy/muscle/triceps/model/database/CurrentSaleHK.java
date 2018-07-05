package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CurrentSaleHK {
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "回款完成金额率", example = "回款完成金额率")
    private String hkwcl;
    @ApiModelProperty(value = "回款完成金额", example = "回款完成金额")
    private String hkwc;
    @ApiModelProperty(value = "回款完成目标", example = "回款完成目标")
    private String hkwct;
    @ApiModelProperty(value = "回款完成金额率月预警（1是正常 0是预警）", example = "回款完成金额率月预警（1是正常 0是预警）")
    private String hkwclmyj;
    @ApiModelProperty(value = "回款完成金额率年预警（1是正常 0是预警）", example = "回款完成金额率年预警（1是正常 0是预警）")
    private String hkwclyyj;

    public void setHkwclmyj(String hkwclmyj) {
        this.hkwclmyj = hkwclmyj;
    }

    public void setHkwclyyj(String hkwclyyj) {
        this.hkwclyyj = hkwclyyj;
    }

    public String getHkwclmyj() {

        return hkwclmyj;
    }

    public String getHkwclyyj() {
        return hkwclyyj;
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

    public String getHkwcl() {
        return hkwcl;
    }

    public void setHkwcl(String hkwcl) {
        this.hkwcl = hkwcl;
    }

    public String getHkwc() {
        return hkwc;
    }

    public void setHkwc(String hkwc) {
        this.hkwc = hkwc;
    }

    public String getHkwct() {
        return hkwct;
    }

    public void setHkwct(String hkwct) {
        this.hkwct = hkwct;
    }
}
