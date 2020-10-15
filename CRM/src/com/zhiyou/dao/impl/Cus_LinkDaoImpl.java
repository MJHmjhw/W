package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.Cus_Link;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link;
import com.zhiyou.util.DBUtil;

public class Cus_LinkDaoImpl implements Cus_Link{

	@Override
	public List<Customer_Link> allCus_link(int page) {
		String sql="select * from customer_link limit ?,5";
		return DBUtil.DQL(sql, Customer_Link.class, page);
	}

	@Override
	public void addCus_link(Customer_Link  customer_Link) {
		String sql="insert into customer_link values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 DBUtil.DML(sql, customer_Link.getCustomer_id(),customer_Link.getLink_name(),customer_Link.getLink_is_male(),customer_Link.getLink_position(),customer_Link.getLink_mobile(),customer_Link.getLink_age(),customer_Link.getLink_relation(),customer_Link.getStatus(),customer_Link.getRemark(),customer_Link.getNext_time(),customer_Link.getCreate_time(),customer_Link.getCreater(),customer_Link.getUpdate_time(),customer_Link.getUpdater());
	}

	@Override
	public void deleteCus_link(int id) {
		String sql="delete from customer_link where link_id=?";
		DBUtil.DML(sql, id);		
	}

	@Override
	public void updateCus_link(Customer_Link customer_Link) {
		String sql="update customer_link set customer_id=?,link_name=?,link_is_male=?,link_position=?,link_mobile=?,link_age=?,link_relation=?,status=?,remark=?,next_time=?,create_time=?,creater=?,update_time=?,updater=? where link_id=?";
		 DBUtil.DML(sql, customer_Link.getCustomer_id(),customer_Link.getLink_name(),customer_Link.getLink_is_male(),customer_Link.getLink_position(),customer_Link.getLink_mobile(),customer_Link.getLink_age(),customer_Link.getLink_relation(),customer_Link.getStatus(),customer_Link.getRemark(),customer_Link.getNext_time(),customer_Link.getCreate_time(),customer_Link.getCreater(),customer_Link.getUpdate_time(),customer_Link.getUpdater(),customer_Link.getLink_id());
	}

	@Override
	public int sum() {
		String sql="select * from customer_link ";
		return DBUtil.DQL(sql, Customer_Link.class).size();
	}

	@Override
	public int sum2(String name) {
		String sql="select * from customer_link where customer_id like concat('%',?,'%')";

		return DBUtil.DQL(sql, Customer_Link.class, name).size();
	}

	@Override
	public List<Customer> selectCus() {
		String sql="select * from customer ";
		return DBUtil.DQL(sql, Customer.class);
	}

	@Override
	public Customer_Link selectById(int id) {
		String sql="select * from customer_link where link_id=?";
		return DBUtil.DQL(sql, Customer_Link.class,id).get(0);
	}

	@Override
	public List<Customer_Link> selectF(String name, int page) {
		String sql="select * from customer_link where customer_id like concat('%',?,'%')limit ?,5";
		return DBUtil.DQL(sql, Customer_Link.class, name,page);
	}

	@Override
	public List<Customer_Link> selectByname(String name) {
		String sql="select * from customer_link where link_name = ?";
		return DBUtil.DQL(sql, Customer_Link.class,name);
	}

}
