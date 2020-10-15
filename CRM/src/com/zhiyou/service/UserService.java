package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface UserService {
	User selectByName(String username,String password);
	List<User> selectAll(int page);
	int sum();
	void delete(int id);
	void add(User user);
	User selectById(int id);
	List<User>  selectF(String name,int page);
	int Fsum(String name);
	void update(User user);
	List<Department> selectAllDep();
	List<Role> selectAllRole();
	int selectDept(String deptname);
	int selectRole(String rolename);
	List<Role> seList();
	Department selectD(String name);
	Role selectR(String name);
	Department selectD(int id);
	Role selectR(int id);
	int selectByName(String name);
}
