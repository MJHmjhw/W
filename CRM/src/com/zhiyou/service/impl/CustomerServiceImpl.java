package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.impl.customerDaoImpl;
import com.zhiyou.dao.customerDao;

import com.zhiyou.model.Customer;
import com.zhiyou.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private customerDao dao = new customerDaoImpl();

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public List<Customer> selectAll(int page) {
		return dao.selectAll((page - 1) * 8);
	}

	@Override
	public void add(Customer customer) {
		dao.add(customer);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void update(Customer customer) {
		dao.update(customer);
	}

	@Override
	public Customer selectByID(int id) {
		List<Customer> list = dao.selectByID(id);
		return list.size() != 0 ? list.get(0) : null;
	}

	@Override
	public List<Customer> selectDim(String str, int y) {
		List<Customer> list = dao.selectDim(str, (y - 1) * 8);
		return list;
	}

	@Override
	public List<Customer> selectDim(String str) {
		return dao.selectDim(str);
	}

	@Override
	public int selectByName(String name) {
		List<Customer> list = dao.selectByName(name);
		if (list.size() == 0) {
			return 0;
		}
		return 1;

	}

	@Override
	public int selectByPhone(String phone) {
		List<Customer> list=dao.selectByPhone(phone);
		if (list.size()==0) {
			return 0;
		}
		return 1;
	}

}
