package com.fcore.boot.entity;

import java.io.Serializable;

public class SysRole implements Serializable {
	/**
	*@Fields id :ID
	*/
	private long id;
	/**
	*@Fields roleName :角色名称
	*/
	private String roleName;
	/**
	*@Fields description :描述
	*/
	private String description;
	/**
	*@Fields createUserId :创建人ID
	*/
	private long createUserId;
	/**
	*@Fields createTime :创建时间
	*/
	private String createTime;
	/**
	*@Fields updateUserId :修改人ID
	*/
	private long updateUserId;
	/**
	*@Fields updateTime :修改时间
	*/
	private String updateTime;
	/**
	*@Fields isDelete :删除状态
	*/
	private int isDelete;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}
	public long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(long updateUserId) {
		this.updateUserId = updateUserId;
	}
}

