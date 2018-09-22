package com.test.mapper;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.test.pojo.User;

public class SSMUserDaoImpl extends SqlSessionDaoSupport implements SSMUserDao{

	@Override
	public User findUserById(int id) {
		//继承SqlSessionDaoSupport,通过this.sqlSession()得到sqlSession
		SqlSession sqlSession = this.getSqlSession();
		
		User user = sqlSession.selectOne("test.findUserById", id);
		return user;
	}

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = this.getSqlSession();	
		return sqlSession.insert("test.insertUser", user);
	}

	@Override
	public int updateUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.update("test.updateUser", user);
		
	}

	@Override
	public int deleteUser(int id) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.delete("test.deleteUser", id);
	}

		
		
}
