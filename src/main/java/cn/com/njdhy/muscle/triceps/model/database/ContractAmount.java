package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/15.
 */
@ApiModel
public class ContractAmount {
    @ApiModelProperty(value = "组织ID",example = "组织ID")
    private String orgId;
    @ApiModelProperty(value = "组织编码",example = "组织编码")
    private String orgCode;
    @ApiModelProperty(value = "组织名称",example = "组织名称")
    private String orgName;
    @ApiModelProperty(value = "已签合同金额（总金额）",example = "已签合同金额（总金额）")
    private String yqhtje;
    @ApiModelProperty(value = "已支付金额",example = "已支付金额")
    private String yzfje;
    @ApiModelProperty(value = "待支付金额",example = "待支付金额")
    private String dzfje;
    @ApiModelProperty(value = "科目ID",example = "科目ID")
    private String itemId;
    @ApiModelProperty(value = "科目名称",example = "科目名称")
    private String itemName;
    @ApiModelProperty(value = "项目成本目标值",example = "项目成本目标值")
    private String xmcbt;
    @ApiModelProperty(value = "项目成本",example = "项目成本")
    private String xmcb;
    @ApiModelProperty(value = "项目成本偏差率",example = "项目成本偏差率")
    private String mbcbpxy;
    @ApiModelProperty(value = "预警，1是预警0是正常",example = "预警，1是预警0是正常")
    private String yj;
    @ApiModelProperty(value = "项目编号",example = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目名称",example = "名称")
    private String projectName;

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {

        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setYj(String yj) {
        this.yj = yj;
    }

    public String getYj() {
        return yj;
    }

    public String getYqhtje() {
        return yqhtje;
    }

    public void setYqhtje(String yqhtje) {
        this.yqhtje = yqhtje;
    }

    public String getYzfje() {
        return yzfje;
    }

    public void setYzfje(String yzfje) {
        this.yzfje = yzfje;
    }

    public String getDzfje() {
        return dzfje;
    }

    public void setDzfje(String dzfje) {
        this.dzfje = dzfje;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getXmcbt() {
        return xmcbt;
    }

    public void setXmcbt(String xmcbt) {
        this.xmcbt = xmcbt;
    }

    public String getXmcb() {
        return xmcb;
    }

    public void setXmcb(String xmcb) {
        this.xmcb = xmcb;
    }

    public String getMbcbpxy() {
        return mbcbpxy;
    }

    public void setMbcbpxy(String mbcbpxy) {
        this.mbcbpxy = mbcbpxy;
    }
}
