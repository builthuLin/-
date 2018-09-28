package com.test.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.ItemsMapperCustom;
import com.test.pojo.Items;
import com.test.pojo.ItemsCustom;
import com.test.pojo.ItemsQueryVo;

public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) {
		//业务需要返回ItemsCustom,而mapper返回是Items
		Items items = itemsMapperCustom.findItemsById(id);
		
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的属性值拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public int updateItems(Integer id, ItemsCustom itemsCustom) {
		return id;
		//通常在service接口对业务进行校验
		
		//更新信息
		
	}

	@Override
	public int insertItems(ItemsCustom itemsCustom) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteItems(Integer id) {
		return itemsMapperCustom.deleteItems(id);
		
	}

}
