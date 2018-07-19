package cn.com.njdhy.muscle.triceps.model.database;

import java.util.Date;

/**
 * @Author Richard.li
 * @Description ESB日志
 * @Date 2018/7/19
 **/
public class EsbExceuteLog {

    private String esbName;

    private Integer esbCnt;

    private String etlStatus;

    private String etlFeadbak;

    private Date etlTime;

    public String getEsbName() {
        return esbName;
    }

    public void setEsbName(String esbName) {
        this.esbName = esbName;
    }

    public Integer getEsbCnt() {
        return esbCnt;
    }

    public void setEsbCnt(Integer esbCnt) {
        this.esbCnt = esbCnt;
    }

    public String getEtlStatus() {
        return etlStatus;
    }

    public void setEtlStatus(String etlStatus) {
        this.etlStatus = etlStatus;
    }

    public String getEtlFeadbak() {
        return etlFeadbak;
    }

    public void setEtlFeadbak(String etlFeadbak) {
        this.etlFeadbak = etlFeadbak;
    }

    public Date getEtlTime() {
        return etlTime;
    }

    public void setEtlTime(Date etlTime) {
        this.etlTime = etlTime;
    }
}
