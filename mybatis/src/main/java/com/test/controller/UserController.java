package com.test.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.test.pojo.User;

public class UserController {

	/*
	 * 根据id查询用户信息
	 */
	@Test
	public void findUserById() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlsession操作数据库
		//第一个参数：namespace + "." + statementid
		//第二个参数：指定和映射文件中匹配的paramterType类型的参数
		//结果是指定和映射文件中匹配的resultType类型的对象
		User user = sqlSession.selectOne("test.fingUserById", 1); 
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}
	
	/**
	 * 根据用户名称模糊查询用户列表
	 * @throws IOException 
	 */
	@Test
	public void findUserByName() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
	    
		java.util.List<User> list = sqlSession.selectList("test.findUserByName", "小明");
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * 新增用户
	 * @throws IOException 
	 */
	@Test
	public void insertUser() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("王小军");
		user.setPassword("123456");
		user.setNotes("");
		//提交user和映射文件中的resultType所指的类型一致
		int ret = sqlSession.insert("test.insertUser", user);
		
		//提交事物
		sqlSession.commit();
		System.out.println("===================================="+ret+user.getId());
		sqlSession.close();
	}
}
