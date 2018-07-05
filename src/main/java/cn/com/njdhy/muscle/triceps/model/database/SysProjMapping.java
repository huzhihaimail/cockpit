package cn.com.njdhy.muscle.triceps.model.database;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author richard.li
 * @date 2018/7/4 16:33
 */
public class SysProjMapping extends BaseModel {

    private Integer id;

    private Integer reFlag;

    private String cityCode;

    private String cityName;

    private String jscProjCode;

    private String jscProjName;

    private String yyProjName;

    private String yxProjName;

    private String jyProjName;

    private String cbProjName;

    private String cwProjName;

    private Integer stId;

    private String createUser;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    private String modifyUser;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifyDate;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReFlag() {
        return reFlag;
    }

    public void setReFlag(Integer reFlag) {
        this.reFlag = reFlag;
    }

    public String getJscProjCode() {
        return jscProjCode;
    }

    public void setJscProjCode(String jscProjCode) {
        this.jscProjCode = jscProjCode;
    }

    public String getJscProjName() {
        return jscProjName;
    }

    public void setJscProjName(String jscProjName) {
        this.jscProjName = jscProjName;
    }

    public String getYyProjName() {
        return yyProjName;
    }

    public void setYyProjName(String yyProjName) {
        this.yyProjName = yyProjName;
    }

    public String getYxProjName() {
        return yxProjName;
    }

    public void setYxProjName(String yxProjName) {
        this.yxProjName = yxProjName;
    }

    public String getJyProjName() {
        return jyProjName;
    }

    public void setJyProjName(String jyProjName) {
        this.jyProjName = jyProjName;
    }

    public String getCbProjName() {
        return cbProjName;
    }

    public void setCbProjName(String cbProjName) {
        this.cbProjName = cbProjName;
    }

    public String getCwProjName() {
        return cwProjName;
    }

    public void setCwProjName(String cwProjName) {
        this.cwProjName = cwProjName;
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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
}
