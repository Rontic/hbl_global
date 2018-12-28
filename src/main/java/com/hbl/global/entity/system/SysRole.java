package com.hbl.global.entity.system;

import  com.hbl.global.entity.BaseEntity;
import java.util.List;

/**
* 实体
*
* @author yuanjunchun
*/
public class SysRole extends BaseEntity {

//全局唯一标识 
private static final long serialVersionUID = 4785771589352373351L;

//(主键)
private String roleId;

private Integer roleOrder;

private String roleName;

private String roleType;

private String roleTypeName;

private String memberStatus;

private String memberStatusName;
//
private String roleRemark;
//角色ID数组
private String[] roleIds;
// 角色关联权限ID数组
private String[] permissionIds = null;

//角色关联模块ID数组
private String[] moduleIds;

// 角色关联权限信息List
private List<String> permissionIdList;


/**
 * 构造函数
 */
public SysRole() {
    super();
}

/**
 * 构造函数
 * 
 * @param roleId
 *            角色ID
 * @param roleOrder
 *            角色序号
 * @param name
 *            角色名
 */
public SysRole(String roleId,Integer roleOrder,String roleName) {
    super();
    this.setRoleId(roleId);
    this.setRoleOrder(roleOrder);
    this.setRoleName(roleName);
}

/**
 * 构造函数
 * 
 * @param roleOrder
 *            角色序号
 * @param name
 *            角色名
 */
public SysRole(Integer roleOrder,String roleName) {
    super();
    this.setRoleOrder(roleOrder);
    this.setRoleName(roleName);
}


/**
* 获取(主键)
* @return  
*/
public String getRoleId(){
 return this.roleId;
}

/**
* 设置(主键)
* @param roleId 
*/
public void setRoleId(String roleId){
 this.roleId = roleId;
}

/**
* 获取
* @return  
*/
public Integer getRoleOrder(){
 return this.roleOrder;
}

/**
* 设置
* @param roleOrder 
*/
public void setRoleOrder(Integer roleOrder){
 this.roleOrder = roleOrder;
}

/**
* 获取
* @return  
*/
public String getRoleName(){
 return this.roleName;
}

/**
* 设置
* @param roleName 
*/
public void setRoleName(String roleName){
 this.roleName = roleName;
}

/**
* 获取
* @return  
*/
public String getRoleRemark(){
 return this.roleRemark;
}

/**
* 设置
* @param roleRemark 
*/
public void setRoleRemark(String roleRemark){
 this.roleRemark = roleRemark;
}

public String[] getRoleIds() {
	return roleIds;
}

public void setRoleIds(String[] roleIds) {
	this.roleIds = roleIds;
}



public String[] getPermissionIds() {
	return permissionIds;
}

public void setPermissionIds(String[] permissionIds) {
	this.permissionIds = permissionIds;
}

public List<String> getPermissionIdList() {
	return permissionIdList;
}

public void setPermissionIdList(List<String> permissionIdList) {
	this.permissionIdList = permissionIdList;
}

public String[] getModuleIds() {
	return moduleIds;
}

public void setModuleIds(String[] moduleIds) {
	this.moduleIds = moduleIds;
}

public String getRoleType() {
	return roleType;
}

public void setRoleType(String roleType) {
	this.roleType = roleType;
}

public String getMemberStatus() {
	return memberStatus;
}

public void setMemberStatus(String memberStatus) {
	this.memberStatus = memberStatus;
}

public String getRoleTypeName() {
	return roleTypeName;
}

public void setRoleTypeName(String roleTypeName) {
	this.roleTypeName = roleTypeName;
}

public String getMemberStatusName() {
	return memberStatusName;
}

public void setMemberStatusName(String memberStatusName) {
	this.memberStatusName = memberStatusName;
}





}

