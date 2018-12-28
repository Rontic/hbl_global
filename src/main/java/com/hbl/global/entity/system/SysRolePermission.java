package com.hbl.global.entity.system;

import com.hbl.global.entity.BaseEntity;

import java.util.Date;

/**
* 实体
*
* @author yuanjunchun
*/
public class SysRolePermission extends BaseEntity {

//全局唯一标识 
private static final long serialVersionUID = -3644064709642818684L;

//(主键)
private String rolePermissionId;

//
private String roleId;

//
private String permissionId;

//
private String delFlg;

//
private Date createTime;

//
private String createUser;

//
private Date updateTime;

//
private String updateUser;

/**
* 获取(主键)
* @return  
*/
public String getRolePermissionId(){
 return this.rolePermissionId;
}

/**
* 设置(主键)
* @param rolePermissionId 
*/
public void setRolePermissionId(String rolePermissionId){
 this.rolePermissionId = rolePermissionId;
}

/**
* 获取
* @return  
*/
public String getRoleId(){
 return this.roleId;
}

/**
* 设置
* @param roleId 
*/
public void setRoleId(String roleId){
 this.roleId = roleId;
}

/**
* 获取
* @return  
*/
public String getPermissionId(){
 return this.permissionId;
}

/**
* 设置
* @param permissionId 
*/
public void setPermissionId(String permissionId){
 this.permissionId = permissionId;
}

/**
* 获取
* @return  
*/
public String getDelFlg(){
 return this.delFlg;
}

/**
* 设置
* @param delFlg 
*/
public void setDelFlg(String delFlg){
 this.delFlg = delFlg;
}

/**
* 获取
* @return  
*/
public Date getCreateTime(){
 return this.createTime;
}

/**
* 设置
* @param createTime 
*/
public void setCreateTime(Date createTime){
 this.createTime = createTime;
}

/**
* 获取
* @return  
*/
public String getCreateUser(){
 return this.createUser;
}

/**
* 设置
* @param createUser 
*/
public void setCreateUser(String createUser){
 this.createUser = createUser;
}

/**
* 获取
* @return  
*/
public Date getUpdateTime(){
 return this.updateTime;
}

/**
* 设置
* @param updateTime 
*/
public void setUpdateTime(Date updateTime){
 this.updateTime = updateTime;
}

/**
* 获取
* @return  
*/
public String getUpdateUser(){
 return this.updateUser;
}

/**
* 设置
* @param updateUser 
*/
public void setUpdateUser(String updateUser){
 this.updateUser = updateUser;
}


}
