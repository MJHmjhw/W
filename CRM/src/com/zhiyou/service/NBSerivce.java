package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface NBSerivce {
	//部门信息
	List<Department> allDepartment(int page);
	//员工信息
	List<User> allUser(int page);
	//公告信息
	List<Notice> allNotice(int page);
	int sumD();
	int sumU();
	int sumN();
	List<Role> allRole();
}
