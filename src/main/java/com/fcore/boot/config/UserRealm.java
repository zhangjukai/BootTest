package com.fcore.boot.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;


/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

	public UserRealm() {
		setName("UserRealm");
	}

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return null;
	}
}
