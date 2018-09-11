package com.test.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.test.mapper.UserDao;
import com.test.mapper.UserDaoImpl;
import com.test.pojo.User;

public class UserDaoImplTest {
	/**
	 * junit单元测试
	 */
	private SqlSessionFactory sqlSessionFactory;
	
    //此方法在执行testFindUserById之前
	@Before
	public void setUp() throws Exception {
	//mybatis配置文件
	String resource = "SqlMapConfig.xml";
	
	//得到配置文件流
	InputStream inputStream = Resources.getResourceAsStream(resource);
	
	//创建会话工厂，传入mybatis的配置文件信息
	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
	}

	@Test
	public void testFindUserById() {
		//创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用UserDao的方法
	    User user =	userDao.findUserById(2);
	    System.out.println(user);
	}
	
	@Test
	public void testFindUserByName() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.findUserByName("大锤");
		System.out.println(list);
	}

}
