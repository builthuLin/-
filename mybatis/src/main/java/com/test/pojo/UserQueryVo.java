package com.test.pojo;

import java.util.List;

//用户包装类型
public class UserQueryVo {
	
	//传入多个id
	private List<Integer> ids;
	
    public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	//商品详情
}
