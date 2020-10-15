package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.Cus_care;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Care;
import com.zhiyou.util.DBUtil;

public class Cus_careDaoImpl implements Cus_care {

	@Override
	public List<Customer_Care> allCare(int page) {
		String sql = "select * from customer_care limit ?,5";
		return DBUtil.DQL(sql, Customer_Care.class, page);
	}

	@Override
	public void deleteCare(int id) {
		String sql = "delete from customer_care  where customer_care_id=? ";
		DBUtil.DML(sql, id);
	}

	@Override
	public void addCare(Customer_Care care) {
		String sql="insert into customer_care values(null,?,?,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql, care.getCustomer_id(),care.getCare_subject(),care.getCare_type(),care.getStatus(),care.getRemark(),care.getNext_time(),care.getCreate_time(),care.getCreater(),care.getUpdate_time(),care.getUpdater());
		
	}

	@Override
	public void updateCare(Customer_Care care) {
		String sql="update customer_care set customer_id=?,care_subject=?,care_type=?,status=?,remark=?,next_time=?,create_time=?,creater=?,update_time=?,updater=? where customer_care_id=?";
		DBUtil.DML(sql, care.getCustomer_id(),care.getCare_subject(),care.getCare_type(),care.getStatus(),care.getRemark(),care.getNext_time(),care.getCreate_time(),care.getCreater(),care.getUpdate_time(),care.getUpdater(),care.getCustomer_care_id());

	}

	@Override
	public Customer_Care selectById(int id) {
		String sql="select * from customer_care where customer_care_id=?";
		return DBUtil.DQL(sql, Customer_Care.class, id).get(0);
	}

	@Override
	public int sum() {
		String sql = "select * from customer_care";
		return DBUtil.DQL(sql, Customer_Care.class).size();
	}

	@Override
	public int sum2(String nString) {
		String sql="select * from customer_care where customer_id like concat('%',?,'%')";
		return DBUtil.DQL(sql, Customer_Care.class, nString).size();
	}

	@Override
	public List<Customer_Care> selectF(String name, int page) {
		String sql="select * from customer_care where customer_id like concat('%',?,'%')limit ?,5";
		return DBUtil.DQL(sql, Customer_Care.class, name,page);
	}

	@Override
	public List<Customer> allCus() {
		String sql="select * from customer ";
		return DBUtil.DQL(sql, Customer.class);
	}

	@Override
	public List<Customer_Care> selectByName(String name) {
		String sql="select * from customer_care where care_subject = ?";
		return DBUtil.DQL(sql, Customer_Care.class, name);
	}

}
