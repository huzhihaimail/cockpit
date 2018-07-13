package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by hux on 2018/6/21.
 */
@ApiModel
public class SysDomain {

    private String doMainId;

    private String doMainDesc;

    @ApiModelProperty(value = "类型值",example = "类型值")
    private String doMainValue;

    private String jobType;

    private String jobProcessing;

    private Integer seq;

    private Integer stId;

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

    public String getDoMainId() {
        return doMainId;
    }

    public void setDoMainId(String doMainId) {
        this.doMainId = doMainId;
    }

    public String getDoMainDesc() {
        return doMainDesc;
    }

    public void setDoMainDesc(String doMainDesc) {
        this.doMainDesc = doMainDesc;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }
}
