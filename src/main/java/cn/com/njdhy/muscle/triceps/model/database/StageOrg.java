package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author richard.li
 * @date 2018/6/22 16:24
 */
@ApiModel
public class StageOrg {

    @ApiModelProperty(value = "有效标示", example = "有效标示")
    private String cFlag;

    @ApiModelProperty(value = "机构属性", example = "机构属性")
    private String hnaOrganProp;

    @ApiModelProperty(value = "机构ID", example = "机构ID")
    private String nNodeId;

    @ApiModelProperty(value = "机构全称", example = "机构全称")
    private String vcFullName;

    @ApiModelProperty(value = "机构名称", example = "机构名称")
    private String vcName;

    @ApiModelProperty(value = "机构简称", example = "机构简称")
    private String vcShortName;

    @ApiModelProperty(value = "层级", example = "层级")
    private String cLevel;

    @ApiModelProperty(value = "操作时间", example = "操作时间")
    private String dOperatorDate;

    @ApiModelProperty(value = "节点编号", example = "节点编号")
    private String vcOrganId;

    @ApiModelProperty(value = "父节点编号", example = "父节点编号")
    private String vcParentID;

    public String getcFlag() {
        return cFlag;
    }

    public void setcFlag(String cFlag) {
        this.cFlag = cFlag;
    }

    public String getHnaOrganProp() {
        return hnaOrganProp;
    }

    public void setHnaOrganProp(String hnaOrganProp) {
        this.hnaOrganProp = hnaOrganProp;
    }

    public String getnNodeId() {
        return nNodeId;
    }

    public void setnNodeId(String nNodeId) {
        this.nNodeId = nNodeId;
    }

    public String getVcFullName() {
        return vcFullName;
    }

    public void setVcFullName(String vcFullName) {
        this.vcFullName = vcFullName;
    }

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    public String getVcShortName() {
        return vcShortName;
    }

    public void setVcShortName(String vcShortName) {
        this.vcShortName = vcShortName;
    }

    public String getcLevel() {
        return cLevel;
    }

    public void setcLevel(String cLevel) {
        this.cLevel = cLevel;
    }

    public String getdOperatorDate() {
        return dOperatorDate;
    }

    public void setdOperatorDate(String dOperatorDate) {
        this.dOperatorDate = dOperatorDate;
    }

    public String getVcOrganId() {
        return vcOrganId;
    }

    public void setVcOrganId(String vcOrganId) {
        this.vcOrganId = vcOrganId;
    }

    public String getVcParentID() {
        return vcParentID;
    }

    public void setVcParentID(String vcParentID) {
        this.vcParentID = vcParentID;
    }
}
