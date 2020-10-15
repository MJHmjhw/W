package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Department;

public interface DepService {
	List<Department> allDepartment(int page);
	void updateDepartment(Department department);
	void deleteDepartment(int id);
	void addDepartment(Department department);
	List<Department> selectById(int id);
	int sum();
	List<Department> selectF(String name,int page);
	int sum2(String name);
	Department seletcById(int id);
	int selectByName(String name);
}
