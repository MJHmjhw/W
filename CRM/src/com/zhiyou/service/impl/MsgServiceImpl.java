package com.zhiyou.service.impl;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zhiyou.dao.MsgDao;
import com.zhiyou.dao.impl.MsgDaoImpl;
import com.zhiyou.model.Message;
import com.zhiyou.model.User;
import com.zhiyou.service.MsgService;

public class MsgServiceImpl implements MsgService{
	private MsgDao dao=new MsgDaoImpl();

	@Override
	public void writeMsg(Message msg) {
		dao.writeMsg(msg);
	}

	@Override
	public List<User> allUser() {
		return dao.allUser();
	}

	@Override
	public List<Message> allCG(int page) {
		return dao.allCG((page-1)*5);
	}

	@Override
	public int sum() {
		return dao.sum();
	}

	@Override
	public List<Message> allSJ(int page) {
		return dao.allSJ((page-1)*5);
	}

	@Override
	public int sum2() {
		return dao.sum2();
	}

	@Override
	public void updateCG(int id) {
	dao.updateCG( id);
		
	}

	@Override
	public void deleteCG(int id) {
		dao.deleteCG(id);
		
	}
//*****************************************
	@Override
	public void updateSJ(int id) {
		dao.updateSJ(id);
		
	}

	@Override
	public void deleteSJ(int id) {
		dao.deleteSJ(id);
		
	}
//****************************************
	@Override
	public List<Message> allLJ(int page) {
		return dao.allLJ((page-1)*5);
	}
	@Override
	public int sum3() {
		return dao.sum3();
	}
	@Override
	public void deleteLJ(int id) {
		dao.deleteLJ(id);
	}

	@Override
	public List<User> selectFJ(String name, int page) {
		return dao.selectFJ(name, (page-1)*5);
	}

	@Override
	public int sumFJ(String name) {
		return dao.sumFJ(name);
	}

	@Override
	public List<Message> selectFJ2() {
		return dao.selectFJ2();
	}

	@Override
	public List<Message> selectCG2() {
		
		return dao.selectCG2();
	}

	@Override
	public List<Message> allGet(int page) {
		// TODO Auto-generated method stub
		return dao.allGet((page-1)*5);
	}

	@Override
	public int sumGet() {
		// TODO Auto-generated method stub
		return dao.sumGet();
	}

	@Override
	public void deleteGet(int id) {
		dao.deleteGet(id);
		
	}


	@Override
	public void updateGet(int id) {
		dao.updateGet(id);
		
	}

	@Override
	public Message selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public void update(Message message) {
		dao.update(message);
		
	}

}
