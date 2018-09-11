package com.test.mapper;

import java.util.List;

import com.test.pojo.User;

public interface UserDao {
	/**
	 * 原生dao接口以及实现类
	 * @param id
	 * @return
	 */
	//根据id查询用户信息
	public User findUserById(int id);
	//根据用户名模糊查询
	public List<User> findUserByName(String username);
	//添加用户信息
	public void insertUser(User user);
	//删除用户信息
    public void deleteUser(int id);
    //更新用户信息
    public void updateUser(User user);
}
