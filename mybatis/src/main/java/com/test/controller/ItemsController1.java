package com.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.test.pojo.Items;

public class ItemsController1 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用service查找数据库，查询商品列表
		List<Items> itemsList = new ArrayList<>();

		Items items1 = new Items();
		items1.setName("联想笔记本");
		items1.setPrice(6000f);
		items1.setDetail("ThinkPad T430 联想笔记本电脑");

		Items items2 = new Items();
		items2.setName("苹果手机");
		items2.setPrice(5000f);
		items2.setDetail("iphone6s plus苹果手机");

		itemsList.add(items1);
		itemsList.add(items2);

		for (int i = 5; i <= 10; i++) {
			Items items = new Items();
			items.setName("Mac Pro " + i);
			items.setPrice(i * 1000);
			items.setDetail("苹果电脑 Mac Pro " + i);
			itemsList.add(items);
		}
		//设置模型数据
		request.setAttribute("itemsList", itemsList);
		//设置转发的视图
		request.getRequestDispatcher("itemsList").forward(request, response);
		//使用此方法可以通过修改response,来设置响应的数据格式
		/*response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("json串");*/
	}

}
