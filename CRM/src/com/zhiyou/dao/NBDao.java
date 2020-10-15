package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface NBDao {
	//������Ϣ
	List<Department> allDepartment(int page);
	//Ա����Ϣ
	List<User> allUser(int page);
	//������Ϣ
	List<Notice> allNotice(int page);
	int sumD();
	int sumU();
	int sumN();
	List<Role> allRole();
}
