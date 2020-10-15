package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link;

public interface Cus_Link {
	// 所有的联系人
	List<Customer_Link> allCus_link(int page);

	// 添加联系人
	void addCus_link(Customer_Link customer_Link);

	// 删除联系人
	void deleteCus_link(int id);

	// 更新联系人
	void updateCus_link(Customer_Link customer_Link);

	//
	int sum();

	int sum2(String name);
	

	List<Customer> selectCus();
	Customer_Link selectById(int id);
	List<Customer_Link> selectF(String name,int page);
	List<Customer_Link> selectByname(String name);
}
