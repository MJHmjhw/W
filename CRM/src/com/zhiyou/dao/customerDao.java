package com.zhiyou.dao;

import java.util.List;
import com.zhiyou.model.Customer;

public interface customerDao {

	//查询总数
	int sum();
	//查询全部
	List<Customer> selectAll(int page);
	//增加
	void add(Customer customer);
	//删除
	void delete(int id);
	//修改
	void update(Customer customer);
	//根据id查询
	List<Customer> selectByID(int id);
	//模糊查询
	List<Customer> selectDim(String str,int y);
	List<Customer> selectDim(String str);
	List<Customer> selectByName(String name);
	List<Customer> selectByPhone(String phone);
	
}
