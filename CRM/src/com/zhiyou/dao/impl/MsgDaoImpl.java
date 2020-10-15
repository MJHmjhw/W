package com.zhiyou.dao.impl;

import java.util.List;import com.sun.swing.internal.plaf.metal.resources.metal;
import com.zhiyou.dao.MsgDao;
import com.zhiyou.model.Message;
import com.zhiyou.model.User;
import com.zhiyou.util.DBUtil;

public class MsgDaoImpl implements MsgDao {

	@Override
	public void writeMsg(Message msg) {
		String sql = "insert into message values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql, msg.getSubject(), msg.getContent(), msg.getSender(), msg.getSend_delete(), msg.getSend_status(),
				msg.getSave_time(), msg.getSend_time(), msg.getSend_update_time(), msg.getReceiver(),
				msg.getReceive_delete(), msg.getReceive_status(), msg.getReceive_update_time());
	}

	@Override
	public List<User> allUser() {
		String sql = "select * from user ";
		return DBUtil.DQL(sql, User.class);
	}

	@Override
	public List<Message> allCG(int page) {
		String sql = "select * from message where send_status = 0 and send_delete=2 limit ?,5;";
		return DBUtil.DQL(sql, Message.class, page);
	}

	@Override
	public int sum() {
		String sql = "select * from message where send_status=0 and send_delete=2 ;";
		return DBUtil.DQL(sql, Message.class).size();
	}

	// *********************************************
	@Override
	public List<Message> allSJ(int page) {
		String sql = "select * from message where send_status = 2 and send_delete=2 limit ?,5;";
		return DBUtil.DQL(sql, Message.class, page);
	}

	@Override
	public int sum2() {
		String sql = "select * from message where send_status = 2 and send_delete=2";
		return DBUtil.DQL(sql, Message.class).size();
	}

	// **********************************************
	@Override
	public void updateCG(int id) {
		String sql = "update message set send_delete=0,send_status=3 where message_id=?";
		DBUtil.DML(sql,id);
	}

	@Override
	public void deleteCG(int id) {
		String sql="delete from  message where message_id=?";
		DBUtil.DML(sql, id);
		
	}
	//***************************************************

	@Override
	public void updateSJ(int id) {
		String sql = "update message set send_delete=0,send_status=3 where message_id=?";
		DBUtil.DML(sql,id);
		
	}

	@Override
	public void deleteSJ(int id) {
		String sql="delete from  message where message_id=?";
		DBUtil.DML(sql, id);
		
	}
//****************************************************
	@Override
	public List<Message> allLJ(int page) {
		String sql="select * from message where send_delete=0 limit ?,5;";
		return DBUtil.DQL(sql, Message.class, page);
	}

	@Override
	public int sum3() {
		String sql="select * from message where send_delete=0 ;";
		return DBUtil.DQL(sql, Message.class).size();
	}

	@Override
	public void deleteLJ(int id) {
		String sql="delete message where message_id=?";
		DBUtil.DML(sql, id);
		
	}

	@Override
	public List<User> selectFJ(String name,int page) {
		String sql="select * from user where username like concat('%',?,'%') limit ?,5";
		return DBUtil.DQL(sql, User.class, name,page);
	}

	@Override
	public int sumFJ(String name) {
		String sql="select * from user where username like concat('%',?,'%')";
		return DBUtil.DQL(sql, User.class, name).size();
	}

	@Override
	public List<Message> selectFJ2() {
		String sql="select * from message where send_delete=2 and send_status=2";
		return DBUtil.DQL(sql, Message.class);
	}


	@Override
	public List<Message> selectCG2() {
		String sql="select * from message where  send_delete=2 and send_status=0";
		return DBUtil.DQL(sql, Message.class);
	}

	@Override
	public List<Message> allGet(int page) {
		String sql="select * from message where send_delete=2 and send_status=2 limit ?,5";
		return DBUtil.DQL(sql, Message.class, page);
	}

	@Override
	public int sumGet() {
		String sql="select * from message where send_delete=2 and send_status=2";
		return DBUtil.DQL(sql, Message.class).size();
	}

	@Override
	public void deleteGet(int id) {
		String sql="delete from message where message_id=?";
		DBUtil.DML(sql,id);
	}

	@Override
	public void updateGet(int id) {
		String sql="update message set send_delete=0 where message_id=?";
		DBUtil.DML(sql,id);
		
	}

	@Override
	public Message selectById(int id) {
		String sql="select * from message where message_id=?";
		return DBUtil.DQL(sql, Message.class, id).get(0);
	}

	@Override
	public void update(Message msg) {
		String sql="update message set subject=?,content=?,sender=?,send_delete=2,send_status=2,save_time=?,send_time=?,send_update_time=?,receiver=?,receive_delete=?,receive_status=0,receive_update_time=? where message_id=?";
		DBUtil.DML(sql, msg.getSubject(),msg.getContent(),msg.getSender(),msg.getSend_delete(),msg.getSend_status(),msg.getSave_time(),msg.getSend_time(),msg.getSend_update_time(),msg.getReceiver(),msg.getReceive_delete(),msg.getReceive_status(),msg.getReceive_update_time(),msg.getMessage_id());
	}




}
