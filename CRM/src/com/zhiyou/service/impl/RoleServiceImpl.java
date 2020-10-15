package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.RoleDao;
import com.zhiyou.dao.impl.RoleDaoImpl;
import com.zhiyou.model.Role;
import com.zhiyou.service.RoleService;

public class RoleServiceImpl implements RoleService{
	private RoleDao dao=new RoleDaoImpl();

	@Override
	public List<Role> allRole(int page) {
		
		return dao.allRole((page-1)*5);
	}

	@Override
	public void updateRole(Role role) {
		dao.updateRole(role);
		
		
	}

	@Override
	public void deleteRole(int id) {
		dao.deleteRole(id);
		
	}

	@Override
	public void addRole(Role role) {
		dao.addRole(role);
		
	}

	@Override
	public Role selectById(int id) {
		return dao.selectById(id).get(0);
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public List<Role> selectF(String name,int page) {
		return dao.selectF(name,(page-1)*5);
	}

	@Override
	public int sum2(String name) {
		return dao.sum2(name);
	}

	@Override
	public int selectByName(String name) {
		List<Role>list=dao.selectByName(name);
		if (list.size()==0) {
			return 0;
		}
		return 1;
	}

}
