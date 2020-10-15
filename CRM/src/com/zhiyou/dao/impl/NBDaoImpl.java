package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.NBDao;
import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.util.DBUtil;

public class NBDaoImpl implements NBDao{

	@Override
	public List<Department> allDepartment(int page) {
		String sql="select * from department limit ?,5";
		return DBUtil.DQL(sql, Department.class, page);
	}

	@Override
	public List<User> allUser(int page) {
		String sql="select * from user limit ?,5";
		return DBUtil.DQL(sql, User.class, page);
	}

	@Override
	public List<Notice> allNotice(int page) {
		String sql="select * from notice limit ?,5";
		return DBUtil.DQL(sql, Notice.class, page);
	}

	@Override
	public int sumD() {
		String sql="select * from department";
		return DBUtil.DQL(sql, Department.class).size();
	}

	@Override
	public int sumU() {
		String sql="select * from user";
		return DBUtil.DQL(sql, User.class).size();
	}

	@Override
	public int sumN() {
		String sql="select * from notice";
		return DBUtil.DQL(sql, Notice.class).size();
	}

	@Override
	public List<Role> allRole() {
		String sql="select * from role ";
		return DBUtil.DQL(sql, Role.class);
	}




}
