package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.DepDao;
import com.zhiyou.dao.NoticeDao;
import com.zhiyou.dao.impl.NoticeDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.service.NoticeService;

public class NoticeServiceImpl implements NoticeService{
	private NoticeDao dao=new NoticeDaoImpl();

	@Override
	public List<Notice> allNotice(int page) {
		
		return dao.allNotice((page-1)*3);
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public void addNotice(Notice notice) {
dao.addNotice(notice);		
	}

	@Override
	public void deleteNotice(int id) {
dao.deleteNotice(id);		
	}

	@Override
	public void updateNotice(Notice notice) {
		dao.updateNotice(notice);
		
	}

	@Override
	public Notice selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public List<Notice> selectF(int page, String name) {
		return dao.selectF((page-1)*3, name);
	}

	@Override
	public int sum2(String name) {
		return dao.sum2(name);
	}

	@Override
	public List<Department> departments() {
		
		return dao.departments();
	}

	@Override
	public List<Department> selectDept() {
	return dao.departments();
	}

	@Override
	public Department selectByIdD(int id) {
		
		return dao.selectByIdD(id);
	}

	@Override
	public int selectSubject(String name) {
	List<Notice> list=dao.selectSubject(name);
	if (list.size()==0) {
		return 0;
	}	
	return 1;
	}

}
