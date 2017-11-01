package com.luck.dto;

/**
 * @Author miracle
 * @Date 2017/11/1 0001 17:35
 */
public class CommonRespondDto<T> {
    private String code;
    private String msg;
    private Class data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Class getData() {
        return data;
    }

    public void setData(Class data) {
        this.data = data;
    }
}
