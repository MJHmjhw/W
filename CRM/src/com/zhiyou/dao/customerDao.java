package com.zhiyou.dao;

import java.util.List;
import com.zhiyou.model.Customer;

public interface customerDao {

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
	List<Customer> selectByID(int id);
	//ģ����ѯ
	List<Customer> selectDim(String str,int y);
	List<Customer> selectDim(String str);
	List<Customer> selectByName(String name);
	List<Customer> selectByPhone(String phone);
	
}
