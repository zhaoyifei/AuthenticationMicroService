package com.zyifly.common.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyifei on 16/6/14.
 */
public class HttpHeader{

    private Map<String,String> header = new HashMap<String, String>();

    //Application/json
    public static final String CONTENT_TYPE = "Content-Type";

    //Token 登陆后由服务器返回
    public static final String X_HEARTONLINE_AUTH_TOKEN = "x-heartonline-auth-token";

    //userId 用户id，登陆后由服务器返回
    public static final String X_HEARTONLINE_AUTH_ID = "x-heartonline-auth-id";

    //时间戳，登陆后由服务器返回
    public static final String X_HEARTONLINE_AUTH_TIMESTAMP = "x-heartonline-auth-timestamp";

    //客户端系统  Android／iOS／windows／mac
    public static final String X_HEARTONLINE_CLIENT_PLATFORM = "x-heartonline-client-platform";

    //客户端版本
    public static final String X_HEARTONLINE_CLIENT_VERSION = "x-heartonline-client-version";

    //客户端设备型号 Pc端不用 Iphone6s  Huawei mate8
    public static final String X_HEARTONLINE_CLIENT_DEVICE = "x-heartonline-client-device";

    //设备id Pc端不用
    public static final String X_HEARTONLINE_CLIENT_ID = "x-heartonline-client-id";

    //应用版本号
    public static final String X_HEARTONLINE_APPLICATION_VERSION = "x-heartonline-application-version";

    //应用名 心会诊医生端iOS 心在线患者端Android 心门诊pc端
    public static final String X_HEARTONLINE_APPLICATION_NAME = "x-heartonline-application-name";


    public Map<String,String> getHeaderAsMap(){
        return header;
    }

    public HttpHeader(Map<String, String> header) {
        this.header = header;
    }

    public HttpHeader() {
    }

}
