package com.test.pojo;

//通过该类映射订单和用户查询的结果
public class OrdersCustom extends Orders{

	//添加用户属性
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "OrdersCustom [username=" + username + ", password=" + password + "]";
	}
	
}
