package com.zhiyou.dao.impl;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zhiyou.dao.DepDao;
import com.zhiyou.model.Department;
import com.zhiyou.util.DBUtil;

public class DepDaoImpl implements DepDao{


	@Override
	public List<Department> allDepartment(int page) {
		String sql="select * from department limit ?,5";
		return DBUtil.DQL(sql, Department.class, page);
	}

	@Override
	public void updateDepartment(Department department) {
		String sql="update department set department_name=?,department_desc=?,status=?,remark=?, create_time=?,creater=?,update_time=?,updater=? where department_id=?";
		DBUtil.DML(sql, department.getDepartment_name(),department.getDepartment_desc(),
				department.getStatus(),department.getRemark(),department.getCreate_time(),
				department.getCreater(),department.getUpdate_time(),department.getUpdater(),
				department.getDepartment_id());
		
	}

	@Override
	public void deleteDepartment(int id) {
		String sql="delete from department where department_id=?";
		DBUtil.DML(sql, id);
		
	}

	@Override
	public void addDepartment(Department department) {
		String sql="insert into department values(null,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql, department.getDepartment_name(),department.getDepartment_desc(),
				department.getStatus(),department.getRemark(),department.getCreate_time(),
				department.getCreater(),department.getUpdate_time(),department.getUpdater());
		
	}

	@Override
	public List<Department> selectById(int id) {
		String sql="select * from department where department_id=?";
		return DBUtil.DQL(sql, Department.class, id);
	}

	@Override
	public int sum() {
		String sql="select * from department ";
		return DBUtil.DQL(sql, Department.class).size();
	}

	@Override
	public List<Department> selectF(String name, int page) {
		String sql="select * from department where department_name like concat('%',?,'%')limit ?,5";
		return DBUtil.DQL(sql, Department.class, name,page);
	}

	@Override
	public int sum2(String name) {
		String sql="select * from department where department_name like concat('%',?,'%')";
		return DBUtil.DQL(sql, Department.class, name).size();
	}

	@Override
	public Department seletcById(int id) {
		String sql="select * from department where department_id=?";
		return DBUtil.DQL(sql, Department.class, id).get(0);
	}

	@Override
	public List<Department> selectDept() {
		String sql="select * from department ";
		return DBUtil.DQL(sql, Department.class);
	}

	@Override
	public List<Department> selectByName(String name) {
		String sql="select * from department where department_name=?";
		return DBUtil.DQL(sql, Department.class, name);
	}

}
