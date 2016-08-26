package com.fcore.boot.mapper;

import java.util.List;

import com.fcore.boot.entity.TestPOJO;

public interface TestMapper {
	
	public List<TestPOJO> get(Integer age);
}
