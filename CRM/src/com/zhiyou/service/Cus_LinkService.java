package com.zhiyou.service;

import java.util.List;import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link;

public interface Cus_LinkService {
	//所有的联系人
	List<Customer_Link> allCus_link(int page);
	//添加联系人
	void  addCus_link(Customer_Link customer_Link);
	//删除联系人
	void   deleteCus_link(int id);
	//更新联系人
	void updateCus_link(Customer_Link customer_Link);
	int sum();
	int sum2(String name);
List<Customer> selectCus();
Customer_Link selectById(int id);
List<Customer_Link> selectF(String name,int page);
int selectByName(String name);
}
