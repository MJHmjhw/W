package com.zhiyou.service.impl;


import java.util.List;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.impl.UserDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.DBUtil;

public class UserServiceImpl implements UserService{
	 private UserDao dao=new UserDaoImpl();

	@Override
	public User selectByName(String username, String password) {
		List<User> list = dao.selectByName(username, password);
		return list.size()==0?null:list.get(0);
		
	}

	@Override
	public List<User> selectAll(int page) {
		return dao.selectAll((page-1)*5);
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public void add(User user) {
		dao.add(user);
		
	}

	@Override
	public User selectById(int id) {
		List<User> list = dao.selectById(id);
		
	 return list.size()!=0?list.get(0):null;		
	}

	@Override
	public List<User> selectF(String name, int page) {
		return dao.selectF(name, (page-1)*5);
	}

	@Override
	public int Fsum(String name) {
		
		return dao.Fsum(name);
	}

	@Override
	public void update(User user) {
		dao.update(user);	
	}

	@Override
	public List<Department> selectAllDep() {
		return dao.selectAllDep();
	}

	@Override
	public List<Role> selectAllRole() {
		return dao.selectAllRole();
	}
	@Override
	public int selectDept(String deptname) {
		return dao.selectDept(deptname).get(0).getDepartment_id();
	}


	@Override
	public int selectRole(String rolename) {
		return dao.selectRole(rolename).get(0).getRole_id();
	}

	@Override
	public List<Role> seList() {
		return dao.seList();
	}

	@Override
	public Department selectD(String name) {
		return dao.selectD(name);
	}

	@Override
	public Role selectR(String name) {
		return dao.selectR(name);
	}

	@Override
	public Department selectD(int id) {
		return dao.selectD(id);
	}

	@Override
	public Role selectR(int id) {
		return dao.selectR(id);
	}

	@Override
	public int selectByName(String name) {
		System.out.println(name);
	List<User> list=dao.selectByName();
	for (User user : list) {
		if(name.equals(user.getUsername())){
			return 1;
		}
	}
	return 0;
	}
	}
