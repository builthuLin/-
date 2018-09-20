package com.test.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.test.pojo.User;
import com.test.pojo.UserCustom;
import com.test.pojo.UserQueryVo;


public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	
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
	public void testFindUserByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.findUserByName("小明");
		
		sqlSession.close();
		
		System.out.println(list);
	}
	
	@Test
	public void testFindUserByList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setId(4);
		userCustom.setUsername("大锤");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		
		sqlSession.close();
		
		System.out.println(list);
	}
	
	@Test
	public void testFindUserByHashMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Map<String, Object> map = new HashMap<>();
	    map.put("id", 2);
		
		List<User> list = userMapper.findUserByHashMap(map);
		
		sqlSession.close();
		
		System.out.println(list);
	}
	
	@Test
	public void testFindUserCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	    
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setId(4);
		userCustom.setUsername("大锤");
		userQueryVo.setUserCustom(userCustom);
		
		int count = userMapper.findUserCount(userQueryVo);
		
		sqlSession.close();
		System.out.println("=============================共" + count + "条记录");
	}
	
	@Test
	public void testfindUserByIdResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
			
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		User user = userMapper.findUserByIdResultMap(4);
		sqlSession.close();
		System.out.println(user);
			
	}
	
	@Test
	public void testfindUserListChange() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("王大锤");
		userCustom.setPassword("root");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserListChange(userQueryVo);
		sqlSession.close();
		System.out.println(list);
	}
	
	@Test
	public void testfindUserByListMore() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		/*userCustom.setUsername("张小明");*/
		userCustom.setPassword("123456");
		//向sql查询条件传入List或数组
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(3);
		ids.add(5);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserListChange(userQueryVo);
		sqlSession.close();
		System.out.println(list);
	}

}
