package com.fcore.boot.entity;

import java.io.Serializable;

public class SysRole extends BaseEntity implements Serializable {
	/**
	*@Fields roleName :角色名称
	*/
	private String roleName;
	/**
	*@Fields description :描述
	*/
	private String description;
	
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
	
}

