package com.zhiyou.dao.impl;

import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectByName(String username, String password) {
		String sql = "select * from user where username=? and password=?";
		return DBUtil.DQL(sql, User.class, username, password);
	}

	@Override
	public List<User> selectAll(int page) {
		String sql = "select * from user limit ?,5 ";
		return DBUtil.DQL(sql, User.class, page);
	}

	@Override
	public int sum() {
		String sql = "select * from user ";
		return DBUtil.DQL(sql, User.class).size();
	}

	@Override
	public void delete(int id) {
		String sql = "delete from user where user_id=?";
		DBUtil.DML(sql, id);

	}

	@Override
	public void add(User user) {
		String sql = "insert into user values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql, user.getDepartment_id(), user.getRole_id(), user.getUsername(), user.getIs_male(),
				user.getMobile(), user.getAge(), user.getAddress(), user.getIs_admin(), user.getIs_system(),
				user.getPassword(), user.getTel(), user.getId_num(), user.getEmail(), user.getHobby(),
				user.getEducation(), user.getCard_num(), user.getNation(), user.getMarry(), user.getStatus(),
				user.getRemark(), user.getCreate_time(), user.getCreater(), user.getUpdate_time(), user.getUpdater());

	}

	@Override
	public void update(User user) {
		String sql = "update user set department_id = ?,role_id = ?,username = ?,is_male = ?,"
				+ "mobile = ?,age = ?,address = ?,is_admin = ?,is_system = ?,password=?,tel = ?,"
				+ "id_num = ?,email = ?,hobby = ?,education = ?,card_num = ?,nation = ?,marry = ?,"
				+ "status = ?,remark = ?,create_time = ?,creater = ?,update_time = ?,updater = ? where user_id = ?";
		DBUtil.DML(sql, user.getDepartment_id(),user.getRole_id(),user.getUsername(),user.getIs_male(),
				user.getMobile(),user.getAge(),user.getAddress(),user.getIs_admin(),user.getIs_system(),user.getPassword(),
				user.getTel(),user.getId_num(),user.getEmail(),user.getHobby(),user.getEducation(),user.getCard_num(),user.getNation(),
				user.getMarry(),user.getStatus(),user.getRemark(),user.getCreate_time(),user.getCreater(),
				user.getUpdate_time(),user.getUpdater(),user.getUser_id());
	}

	@Override
	public List<User> selectF(String name, int page) {
		String sql = "select * from user where user_id like concat('%',?,'%') or username like concat('%',?,'%') limit ?,5";
		List<User> list = DBUtil.DQL(sql, User.class, name, name, page);
		return list;
	}

	@Override
	public int Fsum(String name) {
		String sql = "select * from user where user_id like concat('%',?,'%') or username like concat('%',?,'%') ";
		int size = DBUtil.DQL(sql, User.class, name, name).size();
		return size;
	}

	@Override
	public List<User> selectById(int id) {
		String sql="select * from user where user_id=?";
		return DBUtil.DQL(sql, User.class, id);
	}
//查询部门表数据
	@Override
	public List<Department> selectAllDep() {
		String sql="select * from department";
		List<Department> list=DBUtil.DQL(sql, Department.class);
		return list;
	}




	//查询角色表中的所有数据
	@Override
	public List<Role> selectAllRole() {
		String sql="select * from role";
		List<Role> list=DBUtil.DQL(sql, Role.class);
		return list;
	}
	@Override
	public List<Department> selectDept(String deptname) {
		String sql = "select * from department where department_name = ?";
		List<Department> list = DBUtil.DQL(sql, Department.class, deptname);		
		return list;
	}


	@Override
	public List<Role> selectRole(String rolename) {
		String sql = "select * from role where role_name = ?";
		List<Role> list = DBUtil.DQL(sql, Role.class, rolename);
		return list;
	}

	@Override
	public List<Role> seList() {
		String sql="select * from role";
		return DBUtil.DQL(sql, Role.class);
	}

	@Override
	public Department selectD(String  name) {
		String sql="select * from department where department_name=?";
		return DBUtil.DQL(sql, Department.class, name).get(0);
	}

	@Override
	public Role selectR(String  name) {
		String sql="select * from role where role_name=?";
		return DBUtil.DQL(sql, Role.class, name).get(0);
	}

	@Override
	public Department selectD(int id) {
	String sql="select * from department where dapartment_id=?";
		return DBUtil.DQL(sql, Department.class, id).get(0);
	}

	@Override
	public Role selectR(int id) {
		String sql="select * from role where role_id=? ";
		return DBUtil.DQL(sql, Role.class, id).get(0);
	}

	@Override
	public List<User> selectByName() {
		String sql="select  * from user";
		return DBUtil.DQL(sql, User.class);
	}

	

}
