package com.test.dao;

import java.util.List;

import com.test.pojo.User;

public interface UserMapper {

	//根据Id查询用户,方法命名,输入参数和输出类型和mapper.xml得一致
	public User findUserById(int id);
	
	public List<User> findUserByName(String username);
	
	public void insertUser(User user);
	
	public void deleteUser(int id);
}
