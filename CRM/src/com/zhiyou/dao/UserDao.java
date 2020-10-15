package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface UserDao {
	// 登录的方法
	List<User> selectByName(String name,String password);
	// 查询全部
	List<User> selectAll(int page);
	//
	int sum();
	//删除用户
	void delete(int id);
	//添加用户
	void add(User user);
	//修改用户
	List<User>  selectById(int id);
	//模糊查询
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
