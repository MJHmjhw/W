package com.zhiyou.service;

import java.util.List;import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link;

public interface Cus_LinkService {
	//���е���ϵ��
	List<Customer_Link> allCus_link(int page);
	//�����ϵ��
	void  addCus_link(Customer_Link customer_Link);
	//ɾ����ϵ��
	void   deleteCus_link(int id);
	//������ϵ��
	void updateCus_link(Customer_Link customer_Link);
	int sum();
	int sum2(String name);
List<Customer> selectCus();
Customer_Link selectById(int id);
List<Customer_Link> selectF(String name,int page);
int selectByName(String name);
}
