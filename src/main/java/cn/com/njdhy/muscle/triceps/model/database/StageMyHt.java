package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author richard.li
 * @date 2018/6/20 14:40
 */
@ApiModel
public class StageMyHt {

    @ApiModelProperty(value = "项目名称", example = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "年月日", example = "年月日")
    private String dataDate;

    @ApiModelProperty(value = "合同+变更金额", example = "合同+变更金额")
    private String allAmt;

    @ApiModelProperty(value = "已支付", example = "已支付")
    private String yzfAmt;

    @ApiModelProperty(value = "应付未付", example = "应付未付")
    private String yfwfAmt;

    @ApiModelProperty(value = "抽取时间", example = "抽取时间")
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

    public String getAllAmt() {
        return allAmt;
    }

    public void setAllAmt(String allAmt) {
        this.allAmt = allAmt;
    }

    public String getYzfAmt() {
        return yzfAmt;
    }

    public void setYzfAmt(String yzfAmt) {
        this.yzfAmt = yzfAmt;
    }

    public String getYfwfAmt() {
        return yfwfAmt;
    }

    public void setYfwfAmt(String yfwfAmt) {
        this.yfwfAmt = yfwfAmt;
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }
}
