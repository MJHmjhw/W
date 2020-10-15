package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Cus_Link;
import com.zhiyou.dao.impl.Cus_LinkDaoImpl;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link;
import com.zhiyou.service.Cus_LinkService;

public class Cus_LinkServiceImpl implements Cus_LinkService{
	private Cus_Link dao=new Cus_LinkDaoImpl();
	@Override
	public List<Customer_Link> allCus_link(int page) {
		return dao.allCus_link((page-1)*5);
	}

	@Override
	public void addCus_link(Customer_Link customer_Link) {
		dao.addCus_link(customer_Link);
	}

	@Override
	public void deleteCus_link(int id) {
	dao.deleteCus_link(id);
		
	}

	@Override
	public void updateCus_link(Customer_Link customer_Link) {
		dao.updateCus_link(customer_Link);
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		return dao.sum();
	}

	@Override
	public int sum2(String name) {
		// TODO Auto-generated method stub
		return dao.sum2(name);
	}

	@Override
	public List<Customer> selectCus() {
		return dao.selectCus();
	}

	@Override
	public Customer_Link selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public List<Customer_Link> selectF(String name, int page) {
		return dao.selectF(name, (page-1)*5);
	}

	@Override
	public int selectByName(String name) {
	List<Customer_Link> list=dao.selectByname(name);
	System.out.println(list.size());
		if (list.size()==0) {
			return 0;
		}
		return 1;
	}

		
}
