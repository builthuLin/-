package com.test.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pojo.User;

public class SSMUserDaoImplTest {

	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		//得到spring容器
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	
	}

	//整合spring和mybatis，用原生dao实现查询测试
	@Test
	public void testFindUserById() {
		SSMUserDao ssmUserDao = (SSMUserDao) applicationContext.getBean("userDao");
	    User user = ssmUserDao.findUserById(2);
	    System.out.println(user);
	}
	
	@Test
	public void testInsertUser() {
		SSMUserDao ssmUserDao = (SSMUserDao) applicationContext.getBean("userDao");
		User user = new User();
		user.setUsername("林凝钰");
		user.setPassword("root123");
		user.setNotes("");
	    int ret = ssmUserDao.insertUser(user);
	    if(ret > 0) {
	    	System.out.println("新增成功=========="+user);
	    }else {
	    	System.out.println("新增失败=========="+ret);
	    }
	    
	}
	
	@Test
	public void testUpdateUser() {
		SSMUserDao ssmUserDao = (SSMUserDao) applicationContext.getBean("userDao");
		User user = new User();
		user.setId(2);
		user.setUsername("胡依娜");
		user.setPassword("123456");
		user.setNotes("");
	    int ret = ssmUserDao.updateUser(user);
	    if(ret > 0) {
	    	System.out.println("修改成功=========="+user);
	    }else {
	    	System.out.println("修改失败=========="+ret);
	    }
	}
	
	@Test
	public void testDeleteUser() {
		SSMUserDao ssmUserDao = (SSMUserDao) applicationContext.getBean("userDao");
		int ret = ssmUserDao.deleteUser(15);
		if(ret > 0) {
	    	System.out.println("删除成功=========="+ret);
	    }else {
	    	System.out.println("删除失败=========="+ret);
	    }
	}

}
