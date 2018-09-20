package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.pojo.User;
import com.test.pojo.UserCustom;
import com.test.pojo.UserQueryVo;

public interface UserMapper {

	//根据Id查询用户,方法命名,输入参数和输出类型和mapper.xml得一致
	public User findUserById(int id);
	
	public List<User> findUserByName(String username);
	
	public void insertUser(User user);
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
	
	//用户信息综合查询,传递pojo包装对象
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);
	
	//用户信息综合查询,使用动态sqlfindUserByListMore
	public List<UserCustom> findUserListChange(UserQueryVo userQueryVo);
	
	//用户信息综合查询,使用动态sql,传入list
	public List<UserCustom> findUserByListMore(UserQueryVo userQueryVo);
	
	//传递hashmap
	public List<User> findUserByHashMap(Map<String, Object> map);

	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo);
	
	//使用resultMap返回映射
	public User findUserByIdResultMap(int id);
}
