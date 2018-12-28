package com.hbl.global.entity.system;

import com.hbl.global.entity.BaseEntity;

/**
 * 用户实体
 * 
 * @author founder
 * 
 */
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = -545813622026592640L;

  //(主键)
    private String userId;

    //
    private String password;

    //
    private String userName;

    //
    private String userRemark;

    private String userSex;

    private String userSexName;

    //
    private String userMobile;

    //
    private String userTel;

    //
    private String userEmail;

    // 用户ID数组
    private String[] userIds;

    private String roleIds;
    
    private String roleId;

    private int cityId;
    
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
	public String getUserSexName() {
		return userSexName;
	}

	public void setUserSexName(String userSexName) {
		this.userSexName = userSexName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String[] getUserIds() {
		return userIds;
	}

	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
