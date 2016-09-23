package com.fcore.boot.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {
	/**
	*@Fields id :ID
	*/
	private Long id;
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
	
	private int pageNumber;
	
	private int pageSize;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(long updateUserId) {
		this.updateUserId = updateUserId;
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

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
