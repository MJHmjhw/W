package com.zhiyou.service;

import java.util.List;
import com.zhiyou.model.Customer;

public interface CustomerService {

	//��ѯ����
	int sum();
	//��ѯȫ��
	List<Customer> selectAll(int page);
	//����
	void add(Customer customer);
	//ɾ��
	void delete(int id);
	//�޸�
	void update(Customer customer);
	//����id��ѯ
	Customer selectByID(int id);
	//ģ����ѯ
	List<Customer> selectDim(String str,int y);
	List<Customer> selectDim(String str);
	int selectByName(String name);
	int selectByPhone(String phone);
}
