package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Message;
import com.zhiyou.model.User;

public interface MsgService {
	void writeMsg(Message msg);

	List<User> allUser();

	List<Message> allCG(int page);

	int sum();

	List<Message> allSJ(int page);

	int sum2();

	//
	void updateCG(int id);

	void deleteCG(int id);

	//
	void updateSJ(int id);

	void deleteSJ(int id);
	//
	List<Message> allLJ(int page);
	int sum3();
	void deleteLJ(int id);
	//
	List<User> selectFJ(String name,int page);
	int sumFJ(String name);
	List<Message> selectFJ2();
	List<Message> selectCG2();
	//
	List<Message> allGet(int page);
	int sumGet();
	void deleteGet(int id);
	void updateGet(int id);
	//
	Message selectById(int id);
	void update(Message msMessage);
}
