package com.fcore.boot.entity;

import java.io.Serializable;

public class SysRolePer implements Serializable {
	/**
	*@Fields sysRoleId :角色ID
	*/
	private long sysRoleId;
	/**
	*@Fields sysPerId :权限ID
	*/
	private long sysPerId;
	
	public long getSysRoleId() {
		return sysRoleId;
	}
	public void setSysRoleId(long sysRoleId) {
		this.sysRoleId = sysRoleId;
	}
	public long getSysPerId() {
		return sysPerId;
	}
	public void setSysPerId(long sysPerId) {
		this.sysPerId = sysPerId;
	}
	
}

