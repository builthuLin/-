package com.test.mapper;

import com.test.pojo.User;

public interface SSMUserDao{
	
	//根据id查询用户信息
	public User findUserById(int id);
	
	public int insertUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);
}
