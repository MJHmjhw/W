package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Customer_CategoryDao;
import com.zhiyou.dao.impl.Customer_CategoryDaoImpl;
import com.zhiyou.model.Customer_Category;
import com.zhiyou.service.Customer_CategoryService;

public class Customer_CategoreServiceImpl implements Customer_CategoryService{
Customer_CategoryDao dao=new Customer_CategoryDaoImpl();
	@Override
	public List<Customer_Category> allGory(int page) {
		return dao.allGory((page-1)*5);
	}

	@Override
	public void addGory(Customer_Category category) {
		dao.addGory(category);
		
	}

	@Override
	public void deleteGory(int id) {
		dao.deleteGory(id);
		
	}

	@Override
	public void updateGory(Customer_Category category) {
		dao.updateGory(category);
		
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public Customer_Category selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public List<Customer_Category> selectF(String name, int page) {
		// TODO Auto-generated method stub
		return dao.selectF(name, (page-1)*5);
	}

	@Override
	public int sum2(String name) {
		// TODO Auto-generated method stub
		return dao.sum2(name);
	}

	@Override
	public int selectByName(String name) {
		List<Customer_Category> list=dao.selectByName(name);
		if (list.size()==0) {
			return 0;
		}
		return 1;
	}

}
