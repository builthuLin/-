package com.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pojo.User;

public class SSMUserMapperTest{

	private ApplicationContext applicationContext;
	
	private SSMUserMapper ssmUserMapper;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	    ssmUserMapper = (SSMUserMapper) applicationContext.getBean("SSMUserMapper");
	}

	@Test
	public void testFindUserById() {
	    User user = ssmUserMapper.findUserById(2);
	    System.out.println(user);
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(2);
		user.setUsername("胡冰卿");
		user.setPassword("123456");
		user.setNotes("");
	    int ret = ssmUserMapper.updateUser(user);
	    if(ret > 0) {
	    	System.out.println("修改成功");
	    }else {
	    	System.out.println("修改失败");
	    }
	    
	    
	}

}
