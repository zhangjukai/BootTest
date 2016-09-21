package com.fcore.boot.config;

import javax.servlet.ServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.util.SavedRequest;
import org.springframework.stereotype.Component;

import com.fcore.boot.entity.SysUser;


/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

	public UserRealm() {
		setName("UserRealm");
		// 采用MD5加密
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("md5");
		matcher.setHashIterations(2);
		setCredentialsMatcher(matcher);
	}

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
		//查询数据库查询数据
	/*	List<SysPermission> sysPermissions = sysPermissionService.getListByUserId(sysUser.getId());
		List<String> permissions = new ArrayList<String>();
		for(SysPermission rolePermission:sysPermissions){
			permissions.add(rolePermission.getValue());
		}*/
		//返回授权信息
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		/*authorizationInfo.addStringPermissions(permissions);*/
		return authorizationInfo;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String loginName = upt.getUsername();
		SysUser user = null;

		if (user == null) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, upt.getPassword(),ByteSource.Util.bytes(user.getSalt()), getName());
		return info;
	}
	
	/**
	 * 清除缓存
	 * 每次修改权限后调用
	 */
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
	
	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 更新用户信息缓存.
	 */
	public void clearCachedAuthenticationInfo() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCachedAuthenticationInfo(principals);
	}

	/**
	 * 清除用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	/**
	 * 清除用户信息缓存.
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	/**
	 * 清空所有认证缓存
	 */
	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
	
	/**
	 * MD5加密
	 * @param password
	 * @param salt
	 * @return
	 */
	public String shiroMd5(String password,String salt,int hashIteration){
		Md5Hash md5Hash = new Md5Hash(password, salt, hashIteration);
		String password_md5 = md5Hash.toString();
		return password_md5;
	}
	
	/**
	 * 获取shiro记录的上次请求地址
	 * @param request
	 * @return
	 */
	public static SavedRequest getSavedRequest(ServletRequest request) {  
	    SavedRequest savedRequest = null;  
	    Subject subject = SecurityUtils.getSubject();  
	    Session session = subject.getSession(false);  
	    if (session != null) {  
	        savedRequest = (SavedRequest) session.getAttribute("shiroSavedRequest");  
	    }  
	    return savedRequest;  
	}  
	
	public static void main(String[] args) {
		UserRealm realm = new UserRealm();
		System.out.println(realm.shiroMd5("123456@123","zhoujing",2));
	}
}
