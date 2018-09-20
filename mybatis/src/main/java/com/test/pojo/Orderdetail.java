package com.test.pojo;

public class Orderdetail {

	private int id;
	private int ordersid;
	private int itemsid;
	private int itemsnum;

	// 订单明细对应的商品信息
	private Items items;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}

	public int getItemsid() {
		return itemsid;
	}

	public void setItemsid(int itemsid) {
		this.itemsid = itemsid;
	}

	public int getItemsnum() {
		return itemsnum;
	}

	public void setItemsnum(int itemsnum) {
		this.itemsnum = itemsnum;
	}

	@Override
	public String toString() {
		return "Orderdetail [id=" + id + ", ordersid=" + ordersid + ", itemsid=" + itemsid + ", itemsnum=" + itemsnum
				+ "]";
	}

}
