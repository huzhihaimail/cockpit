package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/13.
 */
@ApiModel
public class CurrentSaleXS {
    @ApiModelProperty(value = "城市公司编码", example = "城市公司编码")
    private String areaCode;
    @ApiModelProperty(value = "城市公司名称", example = "城市公司名称")
    private String areaName;
    @ApiModelProperty(value = "销售完成率", example = "销售完成率")
    private String xswcl;
    @ApiModelProperty(value = "销售金额", example = "销售金额")
    private String xswc;
    @ApiModelProperty(value = "销售目标", example = "销售目标")
    private String xswct;
    @ApiModelProperty(value = "销售完成率月预警（1是正常 0是预警）", example = "销售完成率月预警（1是正常 0是预警）")
    private String xswclmyj;
    @ApiModelProperty(value = "销售完成率年预警（1是正常 0是预警）", example = "销售完成率年预警（1是正常 0是预警）")
    private String xswclyyj;

    public void setXswclmyj(String xswclmyj) {
        this.xswclmyj = xswclmyj;
    }

    public void setXswclyyj(String xswclyyj) {
        this.xswclyyj = xswclyyj;
    }

    public String getXswclmyj() {

        return xswclmyj;
    }

    public String getXswclyyj() {
        return xswclyyj;
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

    public String getXswcl() {
        return xswcl;
    }

    public void setXswcl(String xswcl) {
        this.xswcl = xswcl;
    }

    public String getXswc() {
        return xswc;
    }

    public void setXswc(String xswc) {
        this.xswc = xswc;
    }

    public String getXswct() {
        return xswct;
    }

    public void setXswct(String xswct) {
        this.xswct = xswct;
    }
}
