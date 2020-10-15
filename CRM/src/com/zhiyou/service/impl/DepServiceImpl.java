package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.DepDao;
import com.zhiyou.dao.impl.DepDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.service.DepService;

public class DepServiceImpl implements DepService {
	private DepDao dao = new DepDaoImpl();

	@Override
	public List<Department> allDepartment(int page) {

		return dao.allDepartment((page - 1) * 5);
	}

	@Override
	public void updateDepartment(Department department) {
		dao.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(int id) {
		dao.deleteDepartment(id);
	}

	@Override
	public void addDepartment(Department department) {
		dao.addDepartment(department);

	}

	@Override
	public List<Department> selectById(int id) {

		return dao.selectById(id);
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public List<Department> selectF(String name, int page) {
		return dao.selectF(name, (page - 1) * 5);
	}

	@Override
	public int sum2(String name) {

		return dao.sum2(name);
	}

	@Override
	public Department seletcById(int id) {
		String sql = "select * from department where id=?";
		return dao.seletcById(id);
	}

	@Override
	public int selectByName(String name) {
		List<Department> list = dao.selectByName(name);
		if (list.size() == 0) {
			return 0;
		}
		return 1;
	}

}
