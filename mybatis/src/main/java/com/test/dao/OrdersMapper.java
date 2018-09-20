package com.test.dao;

import java.util.List;

import com.test.pojo.Orders;
import com.test.pojo.OrdersCustom;
import com.test.pojo.User;

public interface OrdersMapper {

	//查询订单关联用户,使用resultType
	public List<OrdersCustom> findOrdersUser();
	
	//查询订单关联用户,使用resultMap
	public List<Orders> findOrdersUserResultMap();
	
	//查询订单相关联的用户信息以及订单明细信息查询订单相关联的用户信息以及订单明细信息
	public List<Orders> findOrdersAndDetailResultMap();
	
	//查询用户的购买的商品信息
	public List<User> findUserAndItemsResultMap();
	
	//延迟加载查询订单关联的用户信息
	public List<Orders> findOrdersUserLazyLoading();
}
