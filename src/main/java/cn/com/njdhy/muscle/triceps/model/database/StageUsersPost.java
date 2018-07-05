package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author richard.li
 * @date 2018/6/25 16:52
 */
@ApiModel
public class StageUsersPost {

    @ApiModelProperty(value = "职位记录ID", example = "职位记录ID")
    private String iPostRecordID;

    @ApiModelProperty(value = "所属机构ID", example = "所属机构ID")
    private String nNodeID;

    @ApiModelProperty(value = "员工编号", example = "员工编号")
    private String vcEmployeeID;

    @ApiModelProperty(value = "机构节点编号", example = "机构节点编号")
    private String vcOrganID;

    @ApiModelProperty(value = "职位ID", example = "职位ID")
    private String vcPostID;

    @ApiModelProperty(value = "职位名称", example = "职位名称")
    private String vcPostName;

    @ApiModelProperty(value = "是否管理人员", example = "是否管理人员")
    private String cIfMorB;

    @ApiModelProperty(value = "级别维编号", example = "级别维编号")
    private String tbALnNodeID;

    @ApiModelProperty(value = "管理级别名称", example = "管理级别名称")
    private String vcAdminLevelName;

    public String getiPostRecordID() {
        return iPostRecordID;
    }

    public void setiPostRecordID(String iPostRecordID) {
        this.iPostRecordID = iPostRecordID;
    }

    public String getnNodeID() {
        return nNodeID;
    }

    public void setnNodeID(String nNodeID) {
        this.nNodeID = nNodeID;
    }

    public String getVcEmployeeID() {
        return vcEmployeeID;
    }

    public void setVcEmployeeID(String vcEmployeeID) {
        this.vcEmployeeID = vcEmployeeID;
    }

    public String getVcOrganID() {
        return vcOrganID;
    }

    public void setVcOrganID(String vcOrganID) {
        this.vcOrganID = vcOrganID;
    }

    public String getVcPostID() {
        return vcPostID;
    }

    public void setVcPostID(String vcPostID) {
        this.vcPostID = vcPostID;
    }

    public String getVcPostName() {
        return vcPostName;
    }

    public void setVcPostName(String vcPostName) {
        this.vcPostName = vcPostName;
    }

    public String getcIfMorB() {
        return cIfMorB;
    }

    public void setcIfMorB(String cIfMorB) {
        this.cIfMorB = cIfMorB;
    }

    public String getTbALnNodeID() {
        return tbALnNodeID;
    }

    public void setTbALnNodeID(String tbALnNodeID) {
        this.tbALnNodeID = tbALnNodeID;
    }

    public String getVcAdminLevelName() {
        return vcAdminLevelName;
    }

    public void setVcAdminLevelName(String vcAdminLevelName) {
        this.vcAdminLevelName = vcAdminLevelName;
    }
}
