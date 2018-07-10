package cn.com.njdhy.muscle.triceps.model.database;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/20.
 */
@ApiModel
public class FactHnaImportantList {
    @ApiModelProperty(value = "月份",example = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "城市公司编码",example = "城市公司编码")
    private String cityCode;
    @ApiModelProperty(value = "城市公司名称",example = "城市公司名称")
    private String cityName;
    @ApiModelProperty(value = "项目编码",example = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "城市公司名称",example = "城市公司名称")
    private String projectName;
    @ApiModelProperty(value = "工作内容",example = "工作内容")
    private String jobContent;
    @ApiModelProperty(value = "工作目标",example = "工作目标")
    private String jobTarget;
    @ApiModelProperty(value = "工作类型",example = "工作类型")
    private String jobType;
    @ApiModelProperty(value = "计划结束时间",example = "计划结束时间")
    private String pEndDate;
    @ApiModelProperty(value = "实际结束时间",example = "实际结束时间")
    private String aEndDate;
    @ApiModelProperty(value = "工作状态",example = "工作状态")
    private String jobStatus;
    @ApiModelProperty(value = "当前进展",example = "当前进展")
    private String jobProcessing;
    @ApiModelProperty(value = "责任部门",example = "责任部门")
    private String dutyDept;
    @ApiModelProperty(value = "责任人",example = "责任人")
    private String dutyUser;
    @ApiModelProperty(value = "反馈人",example = "反馈人")
    private String fbUser;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobTarget() {
        return jobTarget;
    }

    public void setJobTarget(String jobTarget) {
        this.jobTarget = jobTarget;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getpEndDate() {
        return pEndDate;
    }

    public void setpEndDate(String pEndDate) {
        this.pEndDate = pEndDate;
    }

    public String getaEndDate() {
        return aEndDate;
    }

    public void setaEndDate(String aEndDate) {
        this.aEndDate = aEndDate;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobProcessing() {
        return jobProcessing;
    }

    public void setJobProcessing(String jobProcessing) {
        this.jobProcessing = jobProcessing;
    }

    public String getDutyDept() {
        return dutyDept;
    }

    public void setDutyDept(String dutyDept) {
        this.dutyDept = dutyDept;
    }

    public String getDutyUser() {
        return dutyUser;
    }

    public void setDutyUser(String dutyUser) {
        this.dutyUser = dutyUser;
    }

    public String getFbUser() {
        return fbUser;
    }

    public void setFbUser(String fbUser) {
        this.fbUser = fbUser;
    }
}
