package com.fcore.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static Logger log = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("msg", "测试消息");
		log.info("测试日志记录");
		return "index";
	}

}
