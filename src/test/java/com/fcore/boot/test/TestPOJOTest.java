package com.fcore.boot.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fcore.boot.Application;
import com.fcore.boot.controller.IndexController;
import com.fcore.boot.entity.TestPOJO;
import com.fcore.boot.service.TestServices;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestPOJOTest {

	private static Logger log = LoggerFactory.getLogger(TestPOJOTest.class);

	@Autowired
	private TestServices testServices;

	@Test
	public void testGet() {
		List<TestPOJO> pojos = testServices.showDao(20);
		for (TestPOJO pojo : pojos) {
			log.info(pojo.toString());
		}
	}
	
	@Test
	public void testSave(){
		TestPOJO pojo = new TestPOJO();
		pojo.setAge(100);
		pojo.setName("zzzz");
		testServices.save(pojo);
	}
}
