package com.fcore.boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcore.boot.bean.Pager;
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

	@Override
	public Pager findForPager(SysUser user) {
		Pager pager = new Pager();
		if (user.getPageSize() == 0) {
			user.setPageSize(pager.getPageSize());
		}
		if (user.getPageNumber() == 0) {
			user.setPageNumber(1);
		}
		List<SysUser> list = userDao.getList(user);
		int count = userDao.getCount(user);
		pager.setList(list);
		pager.setTotalCount(count);
		return pager;
	}
}
