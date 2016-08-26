package com.fcore.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fcore.boot.entity.TestPOJO;
import com.fcore.boot.service.TestServices;

@Controller
public class IndexController {

	private static Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private TestServices testServices;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("msg", "测试消息");
		List<TestPOJO> pojos = testServices.showDao(20);
		for (TestPOJO pojo : pojos) {
			log.info(pojo.toString());
		}
		log.info("测试日志记录");
		return "index";
	}

}
