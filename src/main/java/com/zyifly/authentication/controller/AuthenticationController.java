package com.zyifly.authentication.controller;


import com.alibaba.fastjson.JSON;
import com.zyifly.authentication.data.AuthenticationPayload;
import com.zyifly.common.base.BaseController;
import com.zyifly.common.data.HttpHeader;
import com.zyifly.common.data.ResponseResult;
import com.zyifly.common.exception.AuthencationErrorException;
import com.zyifly.common.timing.LoadCodeTask;
import com.zyifly.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by zhaoyifei on 16/8/30.
 */
@SuppressWarnings("unchecked")
@RestController
@Api(value = "/authentication-api", description = "认证")
@RequestMapping(produces = "application/json;charset=UTF-8")
@Controller
public class AuthenticationController extends BaseController<AuthenticationController> {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "认证", notes = "认证", produces = MediaType.APPLICATION_JSON)
    public ResponseResult login(@RequestBody(required = true) String json) {
        AuthenticationPayload payload = JSON.parseObject(json, AuthenticationPayload.class);
//        AuthenticationPayload payload = new AuthenticationPayload("aaaa","dd");
        long now = new Date().getTime();
        response.setHeader(HttpHeader.X_HEARTONLINE_AUTH_TOKEN, MD5Util.getMd5(now+payload.getUsername()));
        response.setHeader(HttpHeader.X_HEARTONLINE_AUTH_ID, payload.getUsername());
        response.setHeader(HttpHeader.X_HEARTONLINE_AUTH_TIMESTAMP, now+"");
        return new ResponseResult();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "认证", notes = "认证", produces = MediaType.APPLICATION_JSON)
    public ResponseResult getList() {

        if(request.getHeader(HttpHeader.X_HEARTONLINE_AUTH_TIMESTAMP) == null){
            throw new AuthencationErrorException("40306");
        }
        if(request.getHeader(HttpHeader.X_HEARTONLINE_AUTH_ID) == null){
            throw new AuthencationErrorException("40307");
        }
        if(request.getHeader(HttpHeader.X_HEARTONLINE_AUTH_TOKEN) == null){
            throw new AuthencationErrorException("40305");
        }

        long time = Long.parseLong(request.getHeader(HttpHeader.X_HEARTONLINE_AUTH_TIMESTAMP));
        long now = new Date().getTime();
        if(now-time>30*60*1000){
            throw new AuthencationErrorException("40303");
        }
        String username = request.getHeader(HttpHeader.X_HEARTONLINE_AUTH_ID);
        if(!MD5Util.getMd5(time+username).equals(request.getHeader(HttpHeader.X_HEARTONLINE_AUTH_TOKEN))){
            throw new AuthencationErrorException("40302");
        }
        response.setHeader(HttpHeader.X_HEARTONLINE_AUTH_TOKEN, MD5Util.getMd5(now+username));
        response.setHeader(HttpHeader.X_HEARTONLINE_AUTH_ID, username);
        response.setHeader(HttpHeader.X_HEARTONLINE_AUTH_TIMESTAMP, now+"");
        return new ResponseResult();
    }
}
