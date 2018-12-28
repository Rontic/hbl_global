package com.hbl.global.entity.system;

/**
 * Created by 李文武 on 2018/3/3.
 */
public class LoginInfo {
    private String userId;

    private String password;

    private String keyword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
