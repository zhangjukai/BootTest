package com.fcore.boot.entity;

import java.io.Serializable;


public class SysUserRole implements Serializable {
	/**
	*@Fields sysUserId :用户ID
	*/
	private long sysUserId;
	/**
	*@Fields sysRoleId :角色ID
	*/
	private long sysRoleId;
	public long getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(long sysUserId) {
		this.sysUserId = sysUserId;
	}
	public long getSysRoleId() {
		return sysRoleId;
	}
	public void setSysRoleId(long sysRoleId) {
		this.sysRoleId = sysRoleId;
	}
}

