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
	//�ݸ��ɾ����������
	void updateCG(int id);
	void deleteCG(int id);
	//����ɾ����������
	void updateSJ(int id);
	void deleteSJ(int id);
	//����������
	List<Message> allLJ(int page);
	int sum3();
	void deleteLJ(int id);
	//ģ����ѯFJ
	List<User> selectFJ(String name,int page);
	List<Message> selectFJ2();
	int sumFJ(String name);
	//ģ����ѯCG
	List<Message> selectCG2();
	//�ռ���
	List<Message> allGet(int page);
	int sumGet();
	void updateGet(int id);
	void deleteGet(int id);
	//�ݸ������
	Message selectById(int id);
	void update(Message message);
	
}
