package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Cus_link_recDao;
import com.zhiyou.dao.impl.Cus_link_recDaoImpl;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.model.User;
import com.zhiyou.service.Cus_link_recService;

public class Cus_link_recServiceImpl implements Cus_link_recService{
private Cus_link_recDao dao=new  Cus_link_recDaoImpl();
	@Override
	//查询所有记录
	public List<Customer_Link_Record> selectAll(int page) {
		return dao.selectAll((page-1)*5);
	}

	@Override
	//删除记录
	public void deleteRec(int id) {
		dao.deleteRec(id);
	}

	@Override
	public void addRec(Customer_Link_Record cus_L_Rec) {
			dao.addRec(cus_L_Rec);
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public List<Customer> selectCus() {
		return dao.selectCus();
	}

	@Override
	public User sUser(int id) {
		return dao.sUser(id);
	}

	@Override
	public void updateRec(Customer_Link_Record cus_L_Rec) {
		dao.updateRec(cus_L_Rec);
		
	}

	@Override
	public Customer_Link_Record selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public List<Customer_Link_Record> selectF(String name, int page) {

		return dao.selectF(name, (page-1)*5);
	}

	@Override
	public int sum2(String  name) {
		return dao.sum2(name);
	}

	@Override
	public int selectByName(String name) {
	List<Customer_Link_Record> list=dao.selectByName(name);
	if (list.size()==0) {
		return 0;
	}
		return 1;
	}
	

}
