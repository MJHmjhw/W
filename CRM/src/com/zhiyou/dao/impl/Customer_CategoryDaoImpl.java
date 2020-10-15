package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.Customer_CategoryDao;
import com.zhiyou.model.Customer_Category;
import com.zhiyou.util.DBUtil;

public class Customer_CategoryDaoImpl implements Customer_CategoryDao{

	@Override
	public List<Customer_Category> allGory(int page) {
		String sql="select * from customer_category limit ?,5;";
		return DBUtil.DQL(sql, Customer_Category.class,page);
	}

	@Override
	public void addGory(Customer_Category category) {
		String sql="insert into customer_category values(null,?,?,?,?,?,?,?,?)";
		 DBUtil.DML(sql,category.getCustomer_category_name(),category.getCustomer_category_desc(),category.getStatus(),category.getRemark(),category.getCreate_time(),category.getCreater(),category.getUpdate_time(),category.getUpdater());
	}

	@Override
	public void deleteGory(int id) {
		String sql="delete from customer_category where customer_category_id=?";
		DBUtil.DML(sql, id);
		
	}

	@Override
	public void updateGory(Customer_Category category) {
		String sql="update customer_category set customer_category_name=?,customer_category_desc=?,status=?,remark=?,create_time=?,creater=?,update_time=?,updater=? where customer_category_id=?";
		DBUtil.DML(sql, category.getCustomer_category_name(),category.getCustomer_category_desc(),category.getStatus(),category.getRemark(),category.getCreate_time(),category.getCreater(),category.getUpdate_time(),category.getUpdater());
		
	}

	@Override
	public int sum() {
		String sql="select * from customer_category ;";
		return DBUtil.DQL(sql, Customer_Category.class).size();
	}

	@Override
	public Customer_Category selectById(int id) {
		String sql="select * from customer_category where customer_category_id=?";
		return DBUtil.DQL(sql, Customer_Category.class, id).get(0);
	}

	@Override
	public List<Customer_Category> selectF(String name, int page) {
		String sql="select * from   customer_category where customer_category_name like concat('%',?,'%') limit ?,5";
		return DBUtil.DQL(sql, Customer_Category.class, name,page);
	}

	@Override
	public int sum2(String name) {
		String sql="select * from   customer_category where customer_category_name like concat('%',?,'%') ";
		return DBUtil.DQL(sql, Customer_Category.class, name).size();
	}

	@Override
	public List<Customer_Category> selectByName(String name) {
		String sql="select * from Customer_Category where customer_category_name= ?";
		return DBUtil.DQL(sql, Customer_Category.class, name);
	}
	
}
