package com.test.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.pojo.ItemsCustom;
import com.test.service.ItemsService;

@Controller
public class ItemsCustomController {
	
	@Autowired
	private ItemsService itemsService;

	@RequestMapping("/queryItemsListTest")
	public ModelAndView queryItemsListTest() {
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("view/itemsList");
		return modelAndView;
		
	}
	
	@RequestMapping("/editItems")
	public ModelAndView editItems(@RequestParam(value="id",required=true)Integer id) {
		System.out.println("<=================================>"+"接收前端传入参数id为："+ id);
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		System.out.println("<=================================>"+"调用service层，返回"+itemsCustom.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustom", itemsCustom);
        modelAndView.setViewName("view/editItems");
        System.out.println("<=================================>"+"得到返回ModelAndView："+modelAndView.getViewName());
		return modelAndView;
		
	}
	@RequestMapping("/editItemsSubmit")
	public ModelAndView editItemsSubmit() {
		System.out.println("<====================================>"+"进入修改保存方法");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
		
	}
	
	@RequestMapping("deleteItems")
	public ModelAndView deleteItems(@RequestParam(value="id",required=true)Integer id) {
		int result = itemsService.deleteItems(id);
		ModelAndView modelAndView = new ModelAndView();
		if(result > 0) {
			modelAndView.setViewName("success");
		}else {
			modelAndView.setViewName("error");
		}
		return modelAndView;
		
	}
}
