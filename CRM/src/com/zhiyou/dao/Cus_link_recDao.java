package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.model.User;

public interface Cus_link_recDao {
	// ��ѯ���м�¼
	List<Customer_Link_Record> selectAll(int page);
	//ɾ����¼
	void deleteRec(int id);
	//��Ӽ�¼
	void  addRec(Customer_Link_Record cus_L_Rec);
	//��¼����
	int sum();
	List<Customer> selectCus();
	//��ȡ�޸���
	User sUser(int id);
	//������ϵ��¼
	void updateRec(Customer_Link_Record cus_L_Rec);
	//����ID�޸�
	Customer_Link_Record selectById(int id);
	//
	List<Customer_Link_Record> selectF(String name,int page);
	//
	int sum2(String name);
	List<Customer_Link_Record> selectByName(String name);
}
