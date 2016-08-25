package com.fcore.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	
	@RequestMapping("/")
    public String start() {
		return "Hello World!";
    }
	
	public static void main(String[] args) {
		//启动程序
		SpringApplication.run(Application.class, args);
	}
}
