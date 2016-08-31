package com.zyifly.authentication.data;

/**
 * Created by zhaoyifei on 16/8/30.
 */
public class AuthenticationPayload {
    private String username;
    private String password;

    public AuthenticationPayload() {

    }

    public AuthenticationPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
