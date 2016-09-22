package com.fcore.boot.sysTest;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcore.boot.config.UserRealm;
import com.fcore.boot.entity.SysUser;
import com.fcore.boot.service.SysUserService;
import com.fcore.boot.utils.DateTimeUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SysUserTest {
	private static Logger log = LoggerFactory.getLogger(SysUserTest.class);

	@Autowired
	private SysUserService userService;
	@Autowired
	private UserRealm userRealm;

	@Before
	public void init() {
		log.info("提示信息：测试初始化!");
	}

	@Test
	public void addSysUser() {
		SysUser user = new SysUser();
		user.setIsDelete(1);
		user.setLoginName("zjk");
		user.setUserName("张居开");
		user.setSalt(UUID.randomUUID().toString());
		user.setPassword(userRealm.shiroMd5("123456", user.getSalt(), 2));
		long id = userService.add(user);
		assertTrue(id > 0);
	}

	@Test
	public void getUser() {
		SysUser sysUser = userService.getById(1l);
		assertTrue(sysUser!=null);
	}
	
	@Test
	public void UpdateUser() {
		SysUser sysUser = userService.getById(1l);
		String createTime = DateTimeUtil.getNowDateStr(DateTimeUtil.yyyy_MM_dd_HH_mm_ss);
		sysUser.setCreateTime(createTime);
		userService.update(sysUser);
		sysUser = userService.getById(1l);
		assertEquals(sysUser.getCreateTime(),createTime);
	}
}
