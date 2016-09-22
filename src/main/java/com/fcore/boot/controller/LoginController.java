package com.fcore.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fcore.boot.bean.CommonConstants;

@Controller
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * Go login.jsp
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(@ModelAttribute("message") String message) {
		System.out.println("message:"+message);
		return "login";
	}
	
	/**
	 * Go login
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("passWord");

		UsernamePasswordToken upt = new UsernamePasswordToken(loginName, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(upt);
		} catch (UnknownAccountException uae) {
			redirectAttributes.addFlashAttribute("message", CommonConstants.NO_USER_MSG);
		} catch (IncorrectCredentialsException ice) {
			redirectAttributes.addFlashAttribute("message", CommonConstants.PWD_ERROR_MSG);
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			redirectAttributes.addFlashAttribute("message", CommonConstants.USER_INFO_ERROR_MSG);
		}
		// 验证是否登录成功
		if (subject.isAuthenticated()) {
			return "redirect:/views/";
		} else {
			upt.clear();
			return "redirect:/login";
		}

	}
	
	/**
	 * Exit
	 * @return
	 */
	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/index";
	}
}
