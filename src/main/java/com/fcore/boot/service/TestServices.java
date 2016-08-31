package com.fcore.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcore.boot.entity.TestPOJO;
import com.fcore.boot.mapper.TestMapper;

@Service
public class TestServices {

	@Autowired
    private TestMapper testMapper; 
	
	
	public String show(){
        return "hello world!";
    }

    public List<TestPOJO> showDao(int age){
        return testMapper.get(age);
    }
    
    public void save(TestPOJO pojo){
    	testMapper.save(pojo);
    }
}
