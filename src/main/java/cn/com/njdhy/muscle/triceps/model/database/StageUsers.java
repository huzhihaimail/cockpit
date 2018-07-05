package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author richard.li
 * @date 2018/6/25 11:21
 * 海航地产员工基本信息
 */
@ApiModel
public class StageUsers {

    @ApiModelProperty(value = "所属机构ID", example = "所属机构ID")
    private String nNodeID;

    @ApiModelProperty(value = "账号", example = "账号")
    private String vcAccount;

    @ApiModelProperty(value = "员工编号", example = "员工编号")
    private String vcEmployeeID;

    @ApiModelProperty(value = "姓名", example = "姓名")
    private String vcName;

    @ApiModelProperty(value = "是否在岗", example = "是否在岗")
    private String cFlag;

    @ApiModelProperty(value = "是否是管理干部", example = "是否是管理干部")
    private String cIfManageLeader;

    @ApiModelProperty(value = "管理级别名称", example = "管理级别名称")
    private String vcAdminLevelName;

    @ApiModelProperty(value = "管理级别编号", example = "管理级别编号")
    private String nAdminLevelID;

    public String getnNodeID() {
        return nNodeID;
    }

    public void setnNodeID(String nNodeID) {
        this.nNodeID = nNodeID;
    }

    public String getVcAccount() {
        return vcAccount;
    }

    public void setVcAccount(String vcAccount) {
        this.vcAccount = vcAccount;
    }

    public String getVcEmployeeID() {
        return vcEmployeeID;
    }

    public void setVcEmployeeID(String vcEmployeeID) {
        this.vcEmployeeID = vcEmployeeID;
    }

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    public String getcFlag() {
        return cFlag;
    }

    public void setcFlag(String cFlag) {
        this.cFlag = cFlag;
    }

    public String getcIfManageLeader() {
        return cIfManageLeader;
    }

    public void setcIfManageLeader(String cIfManageLeader) {
        this.cIfManageLeader = cIfManageLeader;
    }

    public String getVcAdminLevelName() {
        return vcAdminLevelName;
    }

    public void setVcAdminLevelName(String vcAdminLevelName) {
        this.vcAdminLevelName = vcAdminLevelName;
    }

    public String getnAdminLevelID() {
        return nAdminLevelID;
    }

    public void setnAdminLevelID(String nAdminLevelID) {
        this.nAdminLevelID = nAdminLevelID;
    }
}
