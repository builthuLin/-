package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pojo.Items;

/**
 * 注解开发Handler
 * @author Administrator
 *使用@Controller标识这是一个控制器
 */
@Controller
public class ItemsController2 {

	/*@RequestMapping实现对queryItems方法和url进行映射
	 * 一般建议将url和方法名写成一样
	 */
	@RequestMapping("/queryItemsList")
	public ModelAndView queryItemsList() {
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

		for (int i = 1; i <= 18; i++) {
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
		modelAndView.setViewName("itemsList");

		return modelAndView;
		
	}
}
