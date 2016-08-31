package com.zyifly.authentication.data;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by zhaoyifei on 16/8/31.
 */
public class TestAuthentication {

    @Test
    public void testJSON(){
        String json = "{username: \"15810707559\",password: \"DDDD\"}";
        AuthenticationPayload payload = JSON.parseObject(json, AuthenticationPayload.class);
    }
}
