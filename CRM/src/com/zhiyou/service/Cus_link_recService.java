package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.model.User;

public interface Cus_link_recService {
	// 查询所有记录
	List<Customer_Link_Record> selectAll(int page);

	//删除记录
	void deleteRec(int id);
	//添加记录
	void  addRec(Customer_Link_Record cus_L_Rec);
	//记录总数
	int sum();
	//顾客表查询
	List<Customer> selectCus();
	//
	User sUser(int id);	
	//
	void updateRec(Customer_Link_Record cus_L_Rec);
	//
	Customer_Link_Record selectById(int id);
	//
	List<Customer_Link_Record> selectF(String name,int page);
	//
	int sum2(String name);
	int selectByName(String name);
	
}
