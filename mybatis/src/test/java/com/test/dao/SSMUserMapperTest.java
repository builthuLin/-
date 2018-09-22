package com.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pojo.User;

public class SSMUserMapperTest {

	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
	    User user = userMapper.findUserById(2);
	    System.out.println(user);
	}

}
