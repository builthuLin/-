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
	 * 根据用户id查询记录
	 */
	@Test
	public void findUserById() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlsession操作数据库
		//第一个参数：映射文件中statement的id,等于namespace + "." + statementid
		//第二个参数：指定和映射文件中所匹配parameterType类型的参数
		User user = sqlSession.selectOne("test.findUserById", 1); 
		System.out.println(user);
		
		//释放会话
		sqlSession.close();
	}
	
	/**
	 * 根据用户名模糊查询
	 * @throws IOException 
	 */
	@Test
	public void findUserByName() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
	    
		java.util.List<User> list = sqlSession.selectList("test.findUserByName", "林枫");
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * 新添用户
	 * @throws IOException 
	 */
	@Test
	public void insertUser() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("黄小明");
		user.setPassword("123456");
		user.setNotes("");
		//user和映射文件中resultType所指定的类型一致
		int ret = sqlSession.insert("test.insertUser", user);
		
		//提交事务
		sqlSession.commit();
		System.out.println("===================================="+ret+"自增id:"+user.getId());
		sqlSession.close();
	}
	
	/**
	 * 删除用户
	 * @throws IOException 
	 */
	@Test
	public void deleteUser() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int ret = sqlSession.delete("test.deleteUser", 1);
		
		sqlSession.commit();
		if(ret > 0) {
			System.out.println("====================================删除成功");
		}else {
			System.out.println("====================================删除失败");
		}
		sqlSession.close();
	}
	
	/**
	 * 更新用户
	 * @throws IOException 
	 */
	@Test
	public void updateUser() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//必须设置id
		User user = new User();
		user.setUsername("王大锤");
		user.setPassword("root");
		user.setNotes("");
		user.setId(4);
		
		int ret = sqlSession.update("test.updateUser", user);
		
		sqlSession.commit();
		if(ret > 0) {   
			System.out.println("======================更新成功");
		}else {
			System.out.println("======================更新失败");
		}
		sqlSession.close();
	}
	

}
