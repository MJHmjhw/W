package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.model.User;

public interface Cus_link_recService {
	// ��ѯ���м�¼
	List<Customer_Link_Record> selectAll(int page);

	//ɾ����¼
	void deleteRec(int id);
	//��Ӽ�¼
	void  addRec(Customer_Link_Record cus_L_Rec);
	//��¼����
	int sum();
	//�˿ͱ��ѯ
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
