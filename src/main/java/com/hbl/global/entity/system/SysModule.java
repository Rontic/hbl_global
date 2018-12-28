package com.hbl.global.entity.system;

import com.hbl.global.entity.BaseEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * 模块实体
 * @author founder
 * 
 */
public class SysModule extends BaseEntity {

    private static final long serialVersionUID = -6157347352662144458L;

    //(主键)
    private String moduleId;

    //
    private String parentId;

    //
    private String fullIndex;

    //
    private String moduleName;

    //
    private Integer moduleLevel;

    //
    private String isLeaf;

    //
    private String moduleIcon;

    //
    private Integer moduleOrder;

    //
    private String moduleRemark;

    //
    private String moduleUrl;
    
    List<SysPermiss> permissionList = new ArrayList<SysPermiss>();

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFullIndex() {
		return fullIndex;
	}

	public void setFullIndex(String fullIndex) {
		this.fullIndex = fullIndex;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getModuleLevel() {
		return moduleLevel;
	}

	public void setModuleLevel(Integer moduleLevel) {
		this.moduleLevel = moduleLevel;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getModuleIcon() {
		return moduleIcon;
	}

	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}

	public Integer getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(Integer moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public String getModuleRemark() {
		return moduleRemark;
	}

	public void setModuleRemark(String moduleRemark) {
		this.moduleRemark = moduleRemark;
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public List<SysPermiss> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<SysPermiss> permissionList) {
		this.permissionList = permissionList;
	}
	
	

}
