package com.hbl.global.entity.system;

import com.hbl.global.entity.BaseEntity;

import java.util.Arrays;

/**
* 实体
*
* @author zhanyuqiang
*/
public class SysPermiss extends BaseEntity {

	private static final long serialVersionUID = 771719985857477669L;

	//(主键)
	private String permissionId;
	
	//
	private String moduleId;
	
	//
	private String permissionName;
	
	private String permissionType;
	
	private String moduleName;
	//
	private String permissionRemark;
	
	private String permissionUrl;

	private String[] permissionIds;
	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionRemark() {
		return permissionRemark;
	}

	public void setPermissionRemark(String permissionRemark) {
		this.permissionRemark = permissionRemark;
	}

	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	public String[] getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String[] permissionIds) {
		this.permissionIds = permissionIds;
	}
	

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((moduleId == null) ? 0 : moduleId.hashCode());
		result = prime * result
				+ ((permissionId == null) ? 0 : permissionId.hashCode());
		result = prime * result + Arrays.hashCode(permissionIds);
		result = prime * result
				+ ((permissionName == null) ? 0 : permissionName.hashCode());
		result = prime
				* result
				+ ((permissionRemark == null) ? 0 : permissionRemark.hashCode());
		result = prime * result
				+ ((permissionUrl == null) ? 0 : permissionUrl.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof SysPermiss)) {
			return false;
		}
		SysPermiss other = (SysPermiss) obj;
		if (moduleId == null) {
			if (other.moduleId != null) {
				return false;
			}
		} else if (!moduleId.equals(other.moduleId)) {
			return false;
		}
		if (permissionId == null) {
			if (other.permissionId != null) {
				return false;
			}
		} else if (!permissionId.equals(other.permissionId)) {
			return false;
		}
		if (!Arrays.equals(permissionIds, other.permissionIds)) {
			return false;
		}
		if (permissionName == null) {
			if (other.permissionName != null) {
				return false;
			}
		} else if (!permissionName.equals(other.permissionName)) {
			return false;
		}
		if (permissionRemark == null) {
			if (other.permissionRemark != null) {
				return false;
			}
		} else if (!permissionRemark.equals(other.permissionRemark)) {
			return false;
		}
		if (permissionUrl == null) {
			if (other.permissionUrl != null) {
				return false;
			}
		} else if (!permissionUrl.equals(other.permissionUrl)) {
			return false;
		}
		return true;
	}

}

