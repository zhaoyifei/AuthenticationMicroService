package com.zyifly.common.data;

/**
 * Created by zhaoyifei on 16/6/14.
 */
public enum HttpCode {

    STATUS_200_OK(200,"OK"),

    STATUS_201_CREATED(201,"Created"),

    STATUS_304_NOT_MODIFIED(304,"Not modified"),

    STATUS_400_BAD_REQUEST(400,"Bad request"),

    STATUS_401_UNAUTHORIZED(401,"unauthorized"),

    STATUS_403_FORBIDDEN(403,"forbidden"),

    STATUS_404_NOT_FOUND(404,"Not found"),

    STATUS_405_METHOD_NOT_ALLOWED(405,"Method not allowed"),
    STATUS_406_NOT_ACCEPTABLE(406,"Not acceptable"),
    STATUS_500_INTERNAL_SERVER_ERROR(500,"Internal server error");


    private int code;
    private String message;
    private HttpCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static HttpCode getHttpCode(int code){
        HttpCode httpCode = HttpCode.STATUS_200_OK;
        for(HttpCode hc: HttpCode.values()){
            if(code == hc.getCode()){
                httpCode = hc;
                break;
            }
        }
        return httpCode;
    }
    public static HttpCode getHttpCode(String codeStr){
        HttpCode httpCode = HttpCode.STATUS_200_OK;
        int code = Integer.parseInt(codeStr);
        for(HttpCode hc: HttpCode.values()){
            if(code == hc.getCode()){
                httpCode = hc;
                break;
            }
        }
        return httpCode;
    }
}
