package com.fcore.boot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.fcore.boot.entity.SysUser;

public class BaseAction {
	public  SysUser getSessionUser(){
		Subject subject = SecurityUtils.getSubject();
		return (SysUser) subject.getSession().getAttribute("sessionUser");
	}
}
