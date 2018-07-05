package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/15.
 */
@ApiModel
public class FourRate {
    //月度完成率
    @ApiModelProperty(value = "月度完成",example = "月度完成")
    private String wcsm;
    @ApiModelProperty(value = "月度目标",example = "月度目标")
    private String wcstm;
    @ApiModelProperty(value = "月度完成率",example = "月度完成率")
    private String wclm;
    //年度完成数
    @ApiModelProperty(value = "年度完成",example = "年度完成")
    private String wcsynd;
    @ApiModelProperty(value = "年度目标",example = "年度目标")
    private String wcsty;
    @ApiModelProperty(value = "年度完成率",example = "年度完成率")
    private String wcly;
    //按时完成数
    @ApiModelProperty(value = "年度完成",example = "年度完成")
    private String wcsyas;
    @ApiModelProperty(value = "按时完成数",example = "按时完成数")
    private String aswcsy;
    @ApiModelProperty(value = "按时完成率",example = "按时完成率")
    private String aswcl;

    //逾期完成数
    @ApiModelProperty(value = "年度完成",example = "年度完成")
    private String wcsyyq;
    @ApiModelProperty(value = "逾期完成数",example = "逾期完成数")
    private String yqwcsy;
    @ApiModelProperty(value = "逾期完成率",example = "逾期完成率")
    private String yqwcl;

    public void setWcsynd(String wcsynd) {
        this.wcsynd = wcsynd;
    }

    public void setWcsyas(String wcsyas) {
        this.wcsyas = wcsyas;
    }

    public void setWcsyyq(String wcsyyq) {
        this.wcsyyq = wcsyyq;
    }

    public String getWcsynd() {

        return wcsynd;
    }

    public String getWcsyas() {
        return wcsyas;
    }

    public String getWcsyyq() {
        return wcsyyq;
    }

    public String getWcsm() {
        return wcsm;
    }

    public void setWcsm(String wcsm) {
        this.wcsm = wcsm;
    }

    public String getWcstm() {
        return wcstm;
    }

    public void setWcstm(String wcstm) {
        this.wcstm = wcstm;
    }

    public String getWclm() {
        return wclm;
    }

    public void setWclm(String wclm) {
        this.wclm = wclm;
    }


    public String getWcsty() {
        return wcsty;
    }

    public void setWcsty(String wcsty) {
        this.wcsty = wcsty;
    }

    public String getAswcsy() {
        return aswcsy;
    }

    public void setAswcsy(String aswcsy) {
        this.aswcsy = aswcsy;
    }

    public String getYqwcsy() {
        return yqwcsy;
    }

    public void setYqwcsy(String yqwcsy) {
        this.yqwcsy = yqwcsy;
    }

    public String getWcly() {
        return wcly;
    }

    public void setWcly(String wcly) {
        this.wcly = wcly;
    }

    public String getAswcl() {
        return aswcl;
    }

    public void setAswcl(String aswcl) {
        this.aswcl = aswcl;
    }

    public String getYqwcl() {
        return yqwcl;
    }

    public void setYqwcl(String yqwcl) {
        this.yqwcl = yqwcl;
    }
}
