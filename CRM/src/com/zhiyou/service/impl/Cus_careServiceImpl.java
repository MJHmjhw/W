package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Cus_care;
import com.zhiyou.dao.impl.Cus_careDaoImpl;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Care;
import com.zhiyou.service.Cus_careService;

public class Cus_careServiceImpl implements Cus_careService{
	private Cus_care dao=new Cus_careDaoImpl();
	@Override
	public List<Customer_Care> allCare(int page) {
		return dao.allCare((page-1)*5);
	}

	@Override
	public void deleteCare(int id) {
		dao.deleteCare(id);
	}

	@Override
	public void addCare(Customer_Care care) {
		dao.addCare(care);
		
	}

	@Override
	public void updateCare(Customer_Care care) {
		dao.updateCare(care);
	}

	@Override
	public Customer_Care selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public int sum2(String nString) {
		return dao.sum2(nString);
	}

	@Override
	public List<Customer_Care> selectF(String name, int page) {
		return dao.selectF(name, (page-1)*5);
	}

	@Override
	public List<Customer> allCus() {
		return dao.allCus();
	}

	@Override
	public int selectByName(String name) {
		List<Customer_Care> list=dao.selectByName(name);
		if (list.size()==0) {
			return 0;
		}
		return 1;
	}

}
