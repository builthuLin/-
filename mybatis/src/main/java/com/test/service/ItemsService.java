package com.test.service;

import java.util.List;

import com.test.pojo.ItemsCustom;
import com.test.pojo.ItemsQueryVo;

public interface ItemsService {

	//查询商品列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);
	
	//根据id查询商品信息
	public ItemsCustom findItemsById(Integer id);
	
	//修改商品信息
    public int updateItems(Integer id, ItemsCustom itemsCustom);
    
    //新增商品
    public int insertItems(ItemsCustom itemsCustom);
    
    //删除商品
    public int deleteItems(Integer id);
	
}