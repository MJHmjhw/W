package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.Cus_link_recDao;
import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.model.User;
import com.zhiyou.util.DBUtil;

public class Cus_link_recDaoImpl implements Cus_link_recDao{

	@Override
	public List<Customer_Link_Record> selectAll(int page) {
	String sql="select * from customer_link_record limit ?,5";
		return DBUtil.DQL(sql, Customer_Link_Record.class, page);
	}

	@Override
	public void deleteRec(int id) {
		String sql="delete from customer_link_record where record_id=?";
		 DBUtil.DML(sql, id);;
	}

	@Override
	public void addRec(Customer_Link_Record cus_L_Rec) {
		String sql="insert into customer_link_record values(null,?,?,?,?,?,?,?,?,?,?,?)";
		DBUtil.DML(sql, cus_L_Rec.getCustomer_id(),cus_L_Rec.getLink_type(),cus_L_Rec.getLink_subject(),cus_L_Rec.getLink_nexttime(),cus_L_Rec.getStatus(),cus_L_Rec.getRemark(),cus_L_Rec.getNext_time(),cus_L_Rec.getCreate_time(),cus_L_Rec.getCreater(),cus_L_Rec.getUpdate_time(),cus_L_Rec.getUpdater());
		
	}

	@Override
	public int sum() {
		return DBUtil.DQL("select * from customer_link_record", Customer_Link_Record.class).size();
	}
	@Override
	public List<Customer> selectCus() {
		String sql="select * from customer";
		return DBUtil.DQL(sql, Customer.class);
	}

	@Override
	public User sUser(int id) {
		String sql="select * from user where user_id=?";
		return DBUtil.DQL(sql, User.class, id).get(0);
	}

	@Override
	public void updateRec(Customer_Link_Record cus_L_Rec) {
		String sql="update customer_link_record set customer_id=?,link_type=?,link_subject=?,remark=?,link_nexttime=?,status=?,remark=?,next_time=?,create_time=?,creater=?,update_time=?,updater=? where record_id=?";
		DBUtil.DML(sql, cus_L_Rec.getCustomer_id(),cus_L_Rec.getLink_type(),cus_L_Rec.getLink_subject(),cus_L_Rec.getRemark(),cus_L_Rec.getLink_nexttime(),cus_L_Rec.getStatus(),cus_L_Rec.getRemark(),cus_L_Rec.getNext_time(),cus_L_Rec.getCreate_time(),cus_L_Rec.getCreater(),cus_L_Rec.getUpdate_time(),cus_L_Rec.getUpdater(),cus_L_Rec.getRecord_id());
		
	}

	@Override
	public Customer_Link_Record selectById(int id) {
		String sql="select * from customer_link_record where record_id=?";
		return DBUtil.DQL(sql, Customer_Link_Record.class, id).get(0);
	}

	@Override
	public List<Customer_Link_Record> selectF(String name, int page) {
		String sql="select * from customer_link_record where record_id like concat('%',?,'%') limit ?,5";
		return DBUtil.DQL(sql, Customer_Link_Record.class, name,page);
	}

	@Override
	public int sum2(String name) {
		String sql="select * from customer_link_record where record_id like concat('%',?,'%')  ";
		return DBUtil.DQL(sql, Customer_Link_Record.class,name).size();
	}

	@Override
	public List<Customer_Link_Record> selectByName(String name) {
		String sql="select * from customer_link_record where link_type=?";
		return DBUtil.DQL(sql, Customer_Link_Record.class, name);
	}

}
