package com.test.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

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
}
