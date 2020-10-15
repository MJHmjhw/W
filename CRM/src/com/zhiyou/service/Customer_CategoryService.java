package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Customer_Category;

public interface Customer_CategoryService {
	List<Customer_Category> allGory(int page);
	void addGory(Customer_Category category);
	void deleteGory(int id);
	void updateGory(Customer_Category category);
	int sum();
	Customer_Category selectById(int id);
	List<Customer_Category> selectF(String name,int page);
	int sum2(String name);
	int selectByName(String name);
}	
