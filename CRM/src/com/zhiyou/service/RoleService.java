package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Role;

public interface RoleService {
	List<Role> allRole(int page);
	void updateRole(Role role);
	void deleteRole(int id);
	void addRole(Role role);
	Role selectById(int id);
	int sum();
	List<Role> selectF(String name,int page);
	int sum2(String name);
	int selectByName(String name);
}
