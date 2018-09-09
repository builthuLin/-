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
}
