package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by hux on 2018/6/21.
 */
@ApiModel
public class SysDomain {
    @ApiModelProperty(value = "类型值",example = "类型值")
    private String doMainValue;

    private String jobType;

    private String jobProcessing;

    public void setDoMainValue(String doMainValue) {
        this.doMainValue = doMainValue;
    }

    public String getDoMainValue() {

        return doMainValue;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobProcessing() {
        return jobProcessing;
    }

    public void setJobProcessing(String jobProcessing) {
        this.jobProcessing = jobProcessing;
    }
}
