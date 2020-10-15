package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.customerDao;
import com.zhiyou.model.Customer;
import com.zhiyou.util.DBUtil;

public class customerDaoImpl implements customerDao{

	
	//总数
	@Override
	public int sum() {
		String sql = "select * from customer";
		return DBUtil.DQL(sql, Customer.class).size();
	}

	//每一页显示8条数据
	@Override
	public List<Customer> selectAll(int page) {
		String sql = "select * from customer limit ? , 8 ";
		return DBUtil.DQL(sql, Customer.class, page);
	}

	@Override
	public void add(Customer customer) {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql,customer.getCustomer_state_id(),
				customer.getCustomer_source_id(),
				customer.getUser_id(),
				customer.getCustomer_category_id(),
				customer.getCustomer_name(),
				customer.getCustomer_is_male(),
				customer.getCustomer_mobile(),
				customer.getCustomer_qq(),
				customer.getCustomer_address(),
				customer.getCustomer_email(),
				customer.getCustomer_remark(),
				customer.getCustomer_position(),
				customer.getCustomer_blog(),
				customer.getCustomer_tel(),
				customer.getCustomer_birth(),
				customer.getCustomer_company(),
				customer.getStatus(),
				customer.getRemark(),
				customer.getCreate_time(),
				customer.getCreater(),
				customer.getUpdate_time(),
				customer.getUpdater()
				);
	}

	@Override
	public void delete(int id) {
		String sql = "delete from customer where customer_id = ? ";
		DBUtil.DML(sql, id);
	}

	@Override
	public void update(Customer customer) {
		String sql = "update customer set customer_state_id = ? ,"
				+ "customer_source_id = ? ,user_id = ? ,customer_category_id = ? ,"
				+ "customer_name = ? ,customer_is_male = ? ,"
				+ "customer_mobile = ? ,customer_qq = ? ,"
				+ "customer_address = ? ,customer_email = ?,"
				+ "customer_remark = ?, customer_position = ? ,customer_blog = ? ,"
				+ "customer_tel = ? ,customer_birth = ? ,customer_company = ? ,"
				+ "status = ? ,remark = ? ,create_time = ? ,creater = ? ,"
				+ "update_time = ? ,updater = ? where customer_id = ? ";
		DBUtil.DML(sql, customer.getCustomer_state_id(),
				customer.getCustomer_source_id(),
				customer.getUser_id(),
				customer.getCustomer_category_id(),
				customer.getCustomer_name(),
				customer.getCustomer_is_male(),
				customer.getCustomer_mobile(),
				customer.getCustomer_qq(),
				customer.getCustomer_address(),
				customer.getCustomer_email(),
				customer.getCustomer_remark(),
				customer.getCustomer_position(),
				customer.getCustomer_blog(),
				customer.getCustomer_tel(),
				customer.getCustomer_birth(),
				customer.getCustomer_company(),
				customer.getStatus(),
				customer.getRemark(),
				customer.getCreate_time(),
				customer.getCreater(),
				customer.getUpdate_time(),
				customer.getUpdater(),
				customer.getCustomer_id()
				);
	}

	@Override
	public List<Customer> selectByID(int id) {
		String sql = "select * from customer where customer_id = ? ";
		return DBUtil.DQL(sql, Customer.class, id);
	}

	@Override
	public List<Customer> selectDim(String str, int y) {
		String sql = "select * from customer where customer_name like concat('%',?,'%') limit ?,8";
		return DBUtil.DQL(sql, Customer.class, str,y);
	}

	@Override
	public List<Customer> selectDim(String str) {
		
		return DBUtil.DQL("select * from customer where customer_name like concat('%',?,'%')", Customer.class, str);
	}

	@Override
	public List<Customer> selectByName(String name) {
		String sql="select * from customer where customer_name=?";
		return DBUtil.DQL(sql, Customer.class, name);
	}

	@Override
	public List<Customer> selectByPhone(String phone) {
		String sql="select * from customer where customer_mobile =?";
		return DBUtil.DQL(sql, Customer.class, phone);
	}

}
