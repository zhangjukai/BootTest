package com.fcore.boot.entity;

import java.io.Serializable;

public class SysPermission implements Serializable {
	/**
	*@Fields id :ID
	*/
	private long id;
	/**
	*@Fields name :权限名称
	*/
	private String name;
	/**
	*@Fields value :权限值
	*/
	private String value;
	/**
	*@Fields href :url路径
	*/
	private String href;
	/**
	*@Fields parentId :上级菜单ID
	*/
	private long parentId;
	/**
	*@Fields flag :0:否 1:是
	*/
	private int isLast;
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
	*@Fields isDelete :删除状态 2：删除 1：正常
	*/
	private int isDelete;
	
	private String parentName;
	
	private String parentIds;
	//等级
	private int levelCode;
	//排序编号
	private int orderCode;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	public int getIsLast() {
		return isLast;
	}
	public void setIsLast(int isLast) {
		this.isLast = isLast;
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
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public int getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(int levelCode) {
		this.levelCode = levelCode;
	}
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
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

