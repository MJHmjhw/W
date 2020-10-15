package com.zhiyou.dao;

import java.util.List;
import com.zhiyou.model.*;

public interface Customer_CategoryDao {
	List<Customer_Category> allGory(int page);
	void addGory(Customer_Category category);
	void deleteGory(int id);
	void updateGory(Customer_Category category);
	int sum();
	Customer_Category selectById(int id);
	List<Customer_Category> selectF(String name,int page);
	int sum2(String name);
	List<Customer_Category> selectByName(String name);
	
}
