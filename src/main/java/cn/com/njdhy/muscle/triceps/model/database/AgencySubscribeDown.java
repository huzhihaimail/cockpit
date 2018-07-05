package cn.com.njdhy.muscle.triceps.model.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by cherlin on 2018/6/14.
 */
@ApiModel
public class AgencySubscribeDown {
    @ApiModelProperty(value = "签约金额月",example = "签约金额月")
    private String qyjem;
    @ApiModelProperty(value = "签约金额目标值月",example = "签约金额目标值月")
    private String qyjetm;
    @ApiModelProperty(value = "签约金额完成率月",example = "签约金额完成率月")
    private String qyjelm;
    @ApiModelProperty(value = "签约金额完成率月预警",example = "签约金额完成率月预警")
    private String qyjelmyj;

    @ApiModelProperty(value = "签约金额年",example = "签约金额年")
    private String qyjey;
    @ApiModelProperty(value = "签约金额目标值年",example = "签约金额目标值年")
    private String qyjety;
    @ApiModelProperty(value = "签约金额完成率年",example = "签约金额完成率年")
    private String qyjely;
    @ApiModelProperty(value = "签约金额完成率年预警",example = "签约金额完成率年预警")
    private String qyjelyyj;

    @ApiModelProperty(value = "签约金额全盘",example = "签约金额全盘")
    private String qyjeqp;
    @ApiModelProperty(value = "签约金额目标全盘",example = "签约金额目标全盘")
    private String qyjetqp;
    @ApiModelProperty(value = "签约金额完成率全",example = "签约金额完成率全")
    private String qyjelqp;
    @ApiModelProperty(value = "签约金额完成率全预警",example = "签约金额完成率全预警")
    private String qyjelqpyj;

    @ApiModelProperty(value = "认购金额月",example = "认购金额月")
    private String rgjem;
    @ApiModelProperty(value = "认购金额目标值月",example = "认购金额目标值月")
    private String rgjetm;
    @ApiModelProperty(value = "认购金额完成率月",example = "认购金额完成率月")
    private String rgjelm;
    @ApiModelProperty(value = "认购金额完成率月预警",example = "认购金额完成率月预警")
    private String rgjelmyj;

    @ApiModelProperty(value = "认购金额年",example = "认购金额年")
    private String rgjey;
    @ApiModelProperty(value = "认购金额目标值年",example = "认购金额目标值年")
    private String rgjety;
    @ApiModelProperty(value = "认购金额完成率年",example = "认购金额完成率年")
    private String rgjely;
    @ApiModelProperty(value = "认购金额完成率年预警",example = "认购金额完成率年预警")
    private String rgjelyyj;

    @ApiModelProperty(value = "认购金额全盘",example = "认购金额全盘")
    private String rgjeqp;
    @ApiModelProperty(value = "认购金额目标值全盘",example = "认购金额目标值全盘")
    private String rgjetqp;
    @ApiModelProperty(value = "认购金额完成率全盘",example = "认购金额完成率全盘")
    private String rgjelqp;
    @ApiModelProperty(value = "认购金额完成率全盘预警",example = "认购金额完成率全盘预警")
    private String rgjelqpyj;

    public String getQyjelmyj() {
        return qyjelmyj;
    }

    public void setQyjelmyj(String qyjelmyj) {
        this.qyjelmyj = qyjelmyj;
    }

    public String getQyjelyyj() {
        return qyjelyyj;
    }

    public void setQyjelyyj(String qyjelyyj) {
        this.qyjelyyj = qyjelyyj;
    }

    public String getQyjelqpyj() {
        return qyjelqpyj;
    }

    public void setQyjelqpyj(String qyjelqpyj) {
        this.qyjelqpyj = qyjelqpyj;
    }

    public String getRgjelmyj() {
        return rgjelmyj;
    }

    public void setRgjelmyj(String rgjelmyj) {
        this.rgjelmyj = rgjelmyj;
    }

    public String getRgjelyyj() {
        return rgjelyyj;
    }

    public void setRgjelyyj(String rgjelyyj) {
        this.rgjelyyj = rgjelyyj;
    }

    public String getRgjelqpyj() {
        return rgjelqpyj;
    }

    public void setRgjelqpyj(String rgjelqpyj) {
        this.rgjelqpyj = rgjelqpyj;
    }

    public String getQyjem() {
        return qyjem;
    }

    public void setQyjem(String qyjem) {
        this.qyjem = qyjem;
    }

    public String getQyjetm() {
        return qyjetm;
    }

    public void setQyjetm(String qyjetm) {
        this.qyjetm = qyjetm;
    }

    public String getQyjelm() {
        return qyjelm;
    }

    public void setQyjelm(String qyjelm) {
        this.qyjelm = qyjelm;
    }

    public String getQyjey() {
        return qyjey;
    }

    public void setQyjey(String qyjey) {
        this.qyjey = qyjey;
    }

    public String getQyjety() {
        return qyjety;
    }

    public void setQyjety(String qyjety) {
        this.qyjety = qyjety;
    }

    public String getQyjely() {
        return qyjely;
    }

    public void setQyjely(String qyjely) {
        this.qyjely = qyjely;
    }

    public String getQyjeqp() {
        return qyjeqp;
    }

    public void setQyjeqp(String qyjeqp) {
        this.qyjeqp = qyjeqp;
    }

    public String getQyjetqp() {
        return qyjetqp;
    }

    public void setQyjetqp(String qyjetqp) {
        this.qyjetqp = qyjetqp;
    }

    public String getQyjelqp() {
        return qyjelqp;
    }

    public void setQyjelqp(String qyjelqp) {
        this.qyjelqp = qyjelqp;
    }

    public String getRgjem() {
        return rgjem;
    }

    public void setRgjem(String rgjem) {
        this.rgjem = rgjem;
    }

    public String getRgjetm() {
        return rgjetm;
    }

    public void setRgjetm(String rgjetm) {
        this.rgjetm = rgjetm;
    }

    public String getRgjelm() {
        return rgjelm;
    }

    public void setRgjelm(String rgjelm) {
        this.rgjelm = rgjelm;
    }

    public String getRgjey() {
        return rgjey;
    }

    public void setRgjey(String rgjey) {
        this.rgjey = rgjey;
    }

    public String getRgjety() {
        return rgjety;
    }

    public void setRgjety(String rgjety) {
        this.rgjety = rgjety;
    }

    public String getRgjeqp() {
        return rgjeqp;
    }

    public void setRgjeqp(String rgjeqp) {
        this.rgjeqp = rgjeqp;
    }

    public String getRgjetqp() {
        return rgjetqp;
    }

    public void setRgjetqp(String rgjetqp) {
        this.rgjetqp = rgjetqp;
    }

    public String getRgjelqp() {
        return rgjelqp;
    }

    public void setRgjelqp(String rgjelqp) {
        this.rgjelqp = rgjelqp;
    }

    public String getRgjely() {
        return rgjely;
    }

    public void setRgjely(String rgjely) {
        this.rgjely = rgjely;
    }
}
