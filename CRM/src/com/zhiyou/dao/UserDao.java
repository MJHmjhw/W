package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface UserDao {
	// ��¼�ķ���
	List<User> selectByName(String name,String password);
	// ��ѯȫ��
	List<User> selectAll(int page);
	//
	int sum();
	//ɾ���û�
	void delete(int id);
	//����û�
	void add(User user);
	//�޸��û�
	List<User>  selectById(int id);
	//ģ����ѯ
	List<User>  selectF(String name,int page);
	int Fsum(String name);
	void update(User user);
	//
	List<Department> selectAllDep();
	List<Role> selectAllRole();
	List<Department> selectDept(String deptname);
	List<Role> selectRole(String rolename);
	List<Role> seList();
	Department selectD(String  name);
	Role selectR(String  name);
	Department selectD(int id);
	Role selectR(int id);
	//////////
	List<User> selectByName();
	
}
