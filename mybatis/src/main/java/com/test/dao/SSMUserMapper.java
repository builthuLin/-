package com.test.dao;

import com.test.pojo.User;

public interface SSMUserMapper {

	//根据Id查询用户,方法命名,输入参数和输出类型和mapper.xml得一致
	public User findUserById(int id);
	
	public int updateUser(User user);
}
