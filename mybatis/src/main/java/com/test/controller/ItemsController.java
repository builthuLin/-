package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.pojo.Items;

public class ItemsController implements Controller {

	/**
	 * 入门程序
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

		for (int i = 1; i <= 5; i++) {
			Items items = new Items();
			items.setName("Mac Pro " + i);
			items.setPrice(i * 1000);
			items.setDetail("苹果电脑 Mac Pro " + i);
			itemsList.add(items);
		}

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute,在jsp界面通过itemList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		modelAndView.setViewName("view/itemsList");

		return modelAndView;
	}

}
