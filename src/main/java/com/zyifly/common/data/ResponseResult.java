package com.zyifly.common.data;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhaoyifei on 16/7/12.
 */
public class ResponseResult<T> {

    private int code = 200;

    private String message = "success";

    private boolean success = true;

    private ResultContent<T> content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultContent<T> getContent() {
        return content;
    }

    public void setContent(ResultContent<T> content) {
        this.content = content;
    }

    public String toJson(){
        String json;
        json = JSON.toJSONString(this);
        return json;
    }
}
