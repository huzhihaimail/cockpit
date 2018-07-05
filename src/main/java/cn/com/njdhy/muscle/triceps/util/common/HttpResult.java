package cn.com.njdhy.muscle.triceps.util.common;

import java.io.Serializable;

/**
 * 返回数据格式
 * Created by cherlin on 2018/6/13.
 */
public class HttpResult<T> implements Serializable {

    private Integer code;
    private String message;
    private T result;
    private String status;

    public HttpResult(T result) {
        this.status = "OK";
        this.code = 200;
        this.message="请求成功";
        this.result = result;
    }

    public HttpResult(String status, String message, T result, Integer code) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.code = code;
    }

    public HttpResult(String status, String message, Integer code){
        this.status = status;
        this.message = message;
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
