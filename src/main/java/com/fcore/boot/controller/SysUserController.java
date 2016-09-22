package com.fcore.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fcore.boot.bean.CommonConstants;
import com.fcore.boot.entity.SysUser;

@Controller
@RequestMapping(value=CommonConstants.ROOT_VIEWS+"/sysUser")
public class SysUserController extends BaseController{

	private static Logger log = LoggerFactory.getLogger(SysUserController.class);

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("msg", "测试消息");
		log.info("测试日志记录");
		return "index";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model,SysUser user) {
		return "/views/sysUser/list";
	}
	
	
	

}
