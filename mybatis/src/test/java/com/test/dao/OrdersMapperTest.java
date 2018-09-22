package com.test.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.test.pojo.Orders;
import com.test.pojo.OrdersCustom;
import com.test.pojo.User;

public class OrdersMapperTest {

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
	public void testFindOrdersUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<OrdersCustom> list = ordersMapper.findOrdersUser();
		sqlSession.close();
		System.out.println(list);
		
	}
	
	@Test
	public void testFindOrdersUserResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<Orders> list = ordersMapper.findOrdersUserResultMap();
		sqlSession.close();
		System.out.println(list);
	}

	
	@Test
	public void testFindOrdersAndDetailResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<Orders> list = ordersMapper.findOrdersAndDetailResultMap();
		sqlSession.close();
		System.out.println(list);
	}
	
	
	@Test
	public void testFindUserAndItemsResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<User> list = ordersMapper.findUserAndItemsResultMap();
		sqlSession.close();
		System.out.println(list);
	}
	
	/*========================================实现延迟加载=======================================*/
	/* 使用延迟加载方法，先去查询简单语句，从而再去查询相关语句
	 * 1、在程序中去遍历查询出的List<Orders>，当我们调用Orders中的getUser方法时，开始延迟加载
	 * 2、延迟加载时，去调用UserMapper.xml中的findUserById这个方法获取用户信息
	 */
	@Test
	public void testFindOrdersUserLazyLoading() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		//查询订单信息（单表）
		List<Orders> list = ordersMapper.findOrdersUserLazyLoading();
		//遍历上边的订单列表
		for(Orders orders : list) {
			//执行getUser去查询用户加载，这里实现按需加载
			User user = orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();
		System.out.println(list);
	}
	
	//一级缓存测试,mybatis默认支持一级缓存
	@Test
	public void testCache1() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//第一次发起请求，查询用户信息,不存在缓存数据则缓存
		User user1 = userMapper.findUserById(2);
		System.out.println(user1);
		
		//如果sqlSession去执行commit操作(执行插入、更新、删除)，会清空sqlSession中一级缓存，实现缓存数据的更新
		user1.setUsername("李四");
		userMapper.updateUser(user1);
		//执行commit操作,清空缓存
		sqlSession.commit();
		
		//第二次发起请求，查询用户信息,缓存数据存在则读取缓存数据，不存在则读取数据库数据
		User user2 = userMapper.findUserById(2);
		System.out.println(user2);
		
		sqlSession.close();
	}
	
	//二级缓存测试，需要自行设置二级缓存开关
	@Test
	public void testCache2() {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		//第一次发起请求，查询用户信息,不存在缓存数据则缓存
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		User user1 = userMapper1.findUserById(2);
		System.out.println(user1);
		
		//执行关闭操作，将sqlSession中的数据写到二级缓存区域
		sqlSession1.close();
		
		//使用sqlSession3执行commit()操作
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user = userMapper3.findUserById(2);
		user.setUsername("李四");
		userMapper3.updateUser(user);
		//执行提交，清空缓存,mapper.xml配置
		/*<!-- useCache设置二级缓存是否禁用，默认为true不禁用，false为禁用 -->
	    <!-- flushCache刷新缓存，true为刷新缓存，执行commit()操作需要 -->*/
		sqlSession3.commit();
		sqlSession3.close();
		
		//第二次发起请求，查询用户信息,缓存数据存在则读取缓存数据，不存在则读取数据库数据
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = userMapper2.findUserById(2);
		System.out.println(user2);
		
		sqlSession2.close();
	}
	
	//======================================mybatis整合ehcache实现分布缓存,实现cache接口==========================================
	@Test
	public void testEhCache() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
	}
	

}
