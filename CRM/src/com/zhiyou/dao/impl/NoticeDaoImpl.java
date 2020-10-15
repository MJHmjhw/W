package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.NoticeDao;
import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao{

	@Override
	public List<Notice> allNotice(int page) {
		String sql="select * from notice limit ?,3";
		return DBUtil.DQL(sql, Notice.class, page);
	}

	@Override
	public int sum() {
		String sql="select * from notice";
		return DBUtil.DQL(sql, Notice.class).size();
	}

	@Override
	public void addNotice(Notice notice) {
		String sql="insert into notice values(null,?,?,?,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql, notice.getReceive_id(),notice.getSubject(),notice.getText(),
				notice.getPub_time(),notice.getExpire_time(),notice.getStatus()
				,notice.getRemark(),notice.getCreate_time(),notice.getCreater(),notice.getUpdate_time(),notice.getUpdater());
		
	}

	@Override
	public void deleteNotice(int id) {
		String sql="delete from notice where notice_id=?";
		DBUtil.DML(sql, id);
	}

	@Override
	public void updateNotice(Notice notice) {
		String sql="update notice set receive_id=?,subject=?,text=?,pub_time=?,expire_time=?,status=?,remark=?,create_time=?,creater=?,update_time=?,updater=? where notice_id=? ";
		System.out.println("12312312");
		DBUtil.DML(sql,notice.getReceive_id(),notice.getSubject(),notice.getText(), notice.getPub_time(),notice.getExpire_time(),notice.getStatus()
				,notice.getRemark(),notice.getCreate_time(),notice.getCreater(),notice.getUpdate_time(),notice.getUpdater(),notice.getNotice_id());
	}

	@Override
	public Notice selectById(int id) {
		String sql="select* from notice where notice_id=?";
		return DBUtil.DQL(sql, Notice.class, id).get(0);
	}

	@Override
	public List<Notice> selectF(int page, String name) {
		String sql="select * from notice where subject like concat('%',?,'%')limit ?,3";
		return DBUtil.DQL(sql, Notice.class, name,page);
	}

	@Override
	public int sum2(String name) {
		String sql="select * from notice where subject like concat('%',?,'%')";

		return DBUtil.DQL(sql, Notice.class,name).size();
	}

	@Override
	public List<Department> departments() {
		String sql="select * from department";
		return DBUtil.DQL(sql, Department.class);
	}

	@Override
	public Department selectByIdD(int id) {
		String sql="select * from department where department_id=?";
		return DBUtil.DQL(sql, Department.class, id).get(0);
	}

	@Override
	public List<Notice> selectSubject(String name) {
		String sql="select * from notice where subject =?";
		return DBUtil.DQL(sql, Notice.class , name);
	}
	
}
