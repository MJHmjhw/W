package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Message;
import com.zhiyou.model.User;

public interface MsgDao {
	void writeMsg(Message msg);
	List<User> allUser();
	List<Message> allCG(int page);
	int sum();
	List<Message> allSJ(int page);
	int sum2();
	//草稿件删除到垃圾箱
	void updateCG(int id);
	void deleteCG(int id);
	//发件删除到垃圾箱
	void updateSJ(int id);
	void deleteSJ(int id);
	//垃圾箱所有
	List<Message> allLJ(int page);
	int sum3();
	void deleteLJ(int id);
	//模糊查询FJ
	List<User> selectFJ(String name,int page);
	List<Message> selectFJ2();
	int sumFJ(String name);
	//模糊查询CG
	List<Message> selectCG2();
	//收件箱
	List<Message> allGet(int page);
	int sumGet();
	void updateGet(int id);
	void deleteGet(int id);
	//草稿箱回显
	Message selectById(int id);
	void update(Message message);
	
}
