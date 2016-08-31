package com.zyifly.common.exception;

import com.zyifly.common.timing.LoadCodeTask;

import java.util.Map;

/**
 * Created by zhaoyifei on 16/8/31.
 */
public class HttpException extends RuntimeException {
    protected String httpCode = "200";
    protected String code = "";
    protected String sysMessage = "";
    protected String businessMessage = "";

    @Override
    public String toString() {
        return "httpCode: "+httpCode+"; code: "+code+"; sysMessage: "+sysMessage+"; businessMessage: "+businessMessage+";";
    }

    public HttpException(String code) {
        Map<String, String> codes = LoadCodeTask.codeMap.get("40306");
        this.code = codes.get("code");
        this.httpCode = codes.get("httpCode");
        this.sysMessage = codes.get("sysMessage");
        this.businessMessage = codes.get("businessMessage");
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(String sysMessage) {
        this.sysMessage = sysMessage;
    }

    public String getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(String businessMessage) {
        this.businessMessage = businessMessage;
    }
}
