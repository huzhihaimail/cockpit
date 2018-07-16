package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author Richard.li
 * @Description 签约逾期未回款
 * @Date 2018/7/16
 **/
@ApiModel
public class StageMyQyyqwhk {

    @ApiModelProperty(value = "项目编码", example = "项目编码")
    private String projectName;

    @ApiModelProperty(value = "年月日", example = "年月日")
    private String dataDate;

    @ApiModelProperty(value = "未收款项", example = "未收款项")
    private String oweType;

    @ApiModelProperty(value = "未收款金额", example = "未收款金额")
    private String oweAmt;

    private Date etlTime;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getOweType() {
        return oweType;
    }

    public void setOweType(String oweType) {
        this.oweType = oweType;
    }

    public String getOweAmt() {
        return oweAmt;
    }

    public void setOweAmt(String oweAmt) {
        this.oweAmt = oweAmt;
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }
}
