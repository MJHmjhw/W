package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.NBDao;
import com.zhiyou.dao.impl.NBDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.NBSerivce;

public class NBServiceImpl implements NBSerivce{
	private NBDao dao=new NBDaoImpl();

	@Override
	public List<Department> allDepartment(int page) {
		return dao.allDepartment(page);
	}

	@Override
	public List<User> allUser(int page) {
		return dao.allUser((page-1)*5);
	}

	@Override
	public List<Notice> allNotice(int page) {
		return dao.allNotice((page-1)*5);
	}

	@Override
	public int sumD() {
		return dao.sumD();
	}

	@Override
	public int sumU() {
		return dao.sumU();
	}

	@Override
	public int sumN() {
		return dao.sumN();
	}

	@Override
	public List<Role> allRole() {
		List<Role> list = dao.allRole();
		return list;
	}

}
