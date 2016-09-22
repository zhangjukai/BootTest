package com.fcore.boot.service;

import com.fcore.boot.entity.SysUser;

public interface SysUserService extends BaseService<SysUser,Long>{

	public SysUser getUserByLoginName(String loginName);

}
