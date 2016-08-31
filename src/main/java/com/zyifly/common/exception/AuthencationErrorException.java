package com.zyifly.common.exception;

import javax.ws.rs.NotSupportedException;
import java.util.Map;

/**
 * Created by zhaoyifei on 16/8/31.
 */
public class AuthencationErrorException extends HttpException {

    public AuthencationErrorException(String code) {
        super(code);
    }
}
