package com.test.pojo;

import java.util.Date;
import java.util.List;

public class Orders {
	
	private int id;
	private int userid;
	private String number;
	private Date createtime;
	private String notes;
	private User user;
	//添加List<orderDetail> orderDetails属性(orders信息不重复)
	//最终会将订单信息映射到orders中，订单所对应的订单明细信息映射到Orders中的orderDetails属性中
	private List<Orderdetail> orderdetails;
	
	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	//添加订单关联的用户信息
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userid=" + userid + ", number=" + number + ", createtime=" + createtime
				+ ", notes=" + notes + ", user=" + user + ", orderdetails=" + orderdetails + "]";
	}
	
	
	

}
