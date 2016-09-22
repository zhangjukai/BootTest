package com.fcore.boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcore.boot.dao.SysUserDao;
import com.fcore.boot.entity.SysUser;
import com.fcore.boot.service.SysUserService;

@Service
public class SysUserServiceImp extends BaseServiceImpl<SysUser, Long> implements SysUserService {

	@Autowired
	private SysUserDao userDao;

	@Autowired
	public void setBaseDao() {
		super.setBaseDao(userDao);
	}

	@Override
	public SysUser getUserByLoginName(String loginName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		List<SysUser> users = userDao.getByParams(params);
		SysUser user = null;
		if (users != null && users.size() > 0) {
			user = users.get(0);
		}
		return user;
	}
}
