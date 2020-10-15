package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.RoleDao;
import com.zhiyou.model.Role;
import com.zhiyou.util.DBUtil;

public class RoleDaoImpl implements RoleDao{

	@Override
	public List<Role> allRole(int page) {
		
		return DBUtil.DQL("select * from role limit ?,5", Role.class,page);
	}

	@Override
	public void updateRole(Role role) {
      String sql="update role set role_name=?,role_permission=?,status=?,"
      		+ "remark=?,create_time=?,creater=?,update_time=?,updater=? where role_id=?";
      DBUtil.DML(sql, role.getRole_name(),role.getRole_permission(),role.getStatus(),role.getRemark(),role.getCreate_time(),role.getCreater()
    		  ,role.getUpdate_time(),role.getUpdater(),role.getRole_id());
	}

	@Override
	public void deleteRole(int id) {
		String sql="delete from role where role_id=?";
		DBUtil.DML(sql, id);
	}

	@Override
	public void addRole(Role role) {
		String sql="insert into role values(null,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql,role.getRole_name(),role.getRole_permission(),role.getStatus(),role.getRemark(),role.getCreate_time(),role.getCreater(),role.getUpdate_time(),role.getUpdater());
	}

	@Override
	public List<Role> selectById(int id) {
String sql="select * from role where role_id=?";
		return DBUtil.DQL(sql, Role.class, id);
	}

	@Override
	public int sum() {
		return DBUtil.DQL("select * from role", Role.class).size();
	}

	@Override
	public List<Role> selectF(String name,int page) {
		String sql="select * from role where role_name like concat('%',?,'%')limit ?,5";
		return DBUtil.DQL(sql, Role.class, name,page);
	}

	@Override
	public int sum2(String name) {
		String sql="select * from role where role_name like concat('%',?,'%')";

		return DBUtil.DQL(sql, Role.class,name).size();
	}

	@Override
	public List<Role> selectByName(String name) {
		String sql="select * from role where role_name=?";
		return DBUtil.DQL(sql, Role.class, name);
	}

}
