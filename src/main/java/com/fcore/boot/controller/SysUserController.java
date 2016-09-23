package com.fcore.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcore.boot.bean.CommonConstants;
import com.fcore.boot.bean.Pager;
import com.fcore.boot.entity.SysUser;
import com.fcore.boot.service.SysUserService;

@Controller
@RequestMapping(value=CommonConstants.ROOT_VIEWS+"/sysUser")
public class SysUserController extends BaseController{

	private static Logger log = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	private SysUserService userService;
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("msg", "测试消息");
		log.info("测试日志记录");
		return "index";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model,SysUser user) {
		Pager pager = userService.findForPager(user);
		model.addAttribute("pager", pager);
		model.addAttribute("user", user);
		return "/views/sysUser/list";
	}
	
	@RequestMapping(value="/edit")
	public String edit(Model model,SysUser user) {
		if(user.getId()!=null && user.getId()>0){
			user = userService.getById(user.getId());
		}
		model.addAttribute("user", user);
		return "/views/sysUser/edit";
	}
	
	
	@RequestMapping("save")
	@ResponseBody
	public void save(SysUser sysUser){
		log.info("保存数据");
	}
	

}
