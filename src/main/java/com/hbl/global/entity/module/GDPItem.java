package com.hbl.global.entity.module;

import java.util.Date;

public class GDPItem {
    private String gdpId;
    private String yearAmount;
    private String travelAmount;
    private String gdpYear;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    public String getGdpId() {
        return gdpId;
    }

    public void setGdpId(String gdpId) {
        this.gdpId = gdpId;
    }

    public String getGdpYear() {
        return gdpYear;
    }

    public void setGdpYear(String gdpYear) {
        this.gdpYear = gdpYear;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getYearAmount() {
        return yearAmount;
    }

    public void setYearAmount(String yearAmount) {
        this.yearAmount = yearAmount;
    }

    public String getTravelAmount() {
        return travelAmount;
    }

    public void setTravelAmount(String travelAmount) {
        this.travelAmount = travelAmount;
    }
}
