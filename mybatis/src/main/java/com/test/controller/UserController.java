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
	 * ����id��ѯ�û���Ϣ
	 */
	@Test
	public void findUserById() throws IOException {
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����,����mybatis�����ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ͨ��sqlsession�������ݿ�
		//��һ��������namespace + "." + statementid
		//�ڶ���������ָ����ӳ���ļ���ƥ���paramterType���͵Ĳ���
		//�����ָ����ӳ���ļ���ƥ���resultType���͵Ķ���
		User user = sqlSession.selectOne("test.fingUserById", 1); 
		System.out.println(user);
		
		//�ͷ���Դ
		sqlSession.close();
	}
	
	/**
	 * �����û�����ģ����ѯ�û��б�
	 * @throws IOException 
	 */
	@Test
	public void findUserByName() throws IOException {
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����,����mybatis�����ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
	    
		java.util.List<User> list = sqlSession.selectList("test.findUserByName", "С��");
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * �����û�
	 * @throws IOException 
	 */
	@Test
	public void insertUser() throws IOException {
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//�����Ự����,����mybatis�����ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("��С��");
		user.setPassword("123456");
		user.setNotes("");
		//�ύuser��ӳ���ļ��е�resultType��ָ������һ��
		int ret = sqlSession.insert("test.insertUser", user);
		
		//�ύ����
		sqlSession.commit();
		System.out.println("===================================="+ret+user.getId());
		sqlSession.close();
	}
}
