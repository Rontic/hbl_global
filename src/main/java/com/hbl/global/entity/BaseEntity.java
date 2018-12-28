package com.hbl.global.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基础表
 */
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// 创建者
	private String createUser;

	// 创建时间
	private Date createTime;

	// 更新者
	private String updateUser;

	// 更新时间
	private Date updateTime;

	private String ids[];

    // 逻辑删除标记
    private String delFlg;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }
}
