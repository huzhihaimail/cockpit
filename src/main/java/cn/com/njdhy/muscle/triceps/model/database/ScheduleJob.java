package cn.com.njdhy.muscle.triceps.model.database;

import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务实体
 */
public class ScheduleJob implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";

    //
    private Integer id;
    //
    private String jobId;
    //任务名称
    private String jobName;
    //任务分组
    private String jobGroup;
    //任务状态:(0：停用，1：启用)
    private String jobStatus;
    //cron表达式
    private String cronExpression;
    //描述
    private String description;
    //任务是否可以并行运行（0：不可以，1：可以）
    private String isConcurrent;
    //任务执行时调用哪个类的方法 包名+类名
    private String beanClass;
    //spring bean
    private String springId;
    //任务调用的方法名
    private String methodName;
    //
    private Date createTime;
    //
    private Date updateTime;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    /**
     * 获取：
     */
    public String getJobId() {
        return jobId;
    }
    /**
     * 设置：任务名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    /**
     * 获取：任务名称
     */
    public String getJobName() {
        return jobName;
    }
    /**
     * 设置：任务分组
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }
    /**
     * 获取：任务分组
     */
    public String getJobGroup() {
        return jobGroup;
    }
    /**
     * 设置：任务状态:(0：停用，1：启用)
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    /**
     * 获取：任务状态:(0：停用，1：启用)
     */
    public String getJobStatus() {
        return jobStatus;
    }
    /**
     * 设置：cron表达式
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
    /**
     * 获取：cron表达式
     */
    public String getCronExpression() {
        return cronExpression;
    }
    /**
     * 设置：描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * 获取：描述
     */
    public String getDescription() {
        return description;
    }
    /**
     * 设置：任务是否可以并行运行（0：不可以，1：可以）
     */
    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }
    /**
     * 获取：任务是否可以并行运行（0：不可以，1：可以）
     */
    public String getIsConcurrent() {
        return isConcurrent;
    }
    /**
     * 设置：spring bean
     */
    public void setSpringId(String springId) {
        this.springId = springId;
    }
    /**
     * 获取：spring bean
     */
    public String getSpringId() {
        return springId;
    }
    /**
     * 设置：任务调用的方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    /**
     * 获取：任务调用的方法名
     */
    public String getMethodName() {
        return methodName;
    }
    /**
     * 设置：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public String toString() {
        return "ScheduleJob{" +
            "id=" + id +
            ", jobId='" + jobId + '\'' +
            ", jobName='" + jobName + '\'' +
            ", jobGroup='" + jobGroup + '\'' +
            ", jobStatus='" + jobStatus + '\'' +
            ", cronExpression='" + cronExpression + '\'' +
            ", description='" + description + '\'' +
            ", isConcurrent='" + isConcurrent + '\'' +
            ", springId='" + springId + '\'' +
            ", methodName='" + methodName + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
    }
}
