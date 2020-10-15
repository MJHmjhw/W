package com.zhiyou.model;

import java.sql.Timestamp;
import java.util.Date;

import com.sun.beans.editors.IntegerEditor;

public class Customer_State {
	private Integer customer_state_id;
	private String customer_state_name;
	private String customer_state_desc;
	private Integer status;
	private String remark;
	private Timestamp create_time;
	private Integer creater;
	private Timestamp update_time;
	private Integer updater;
	
	public Customer_State() {
		super();
	}
	public Customer_State(Integer customer_state_id, String customer_state_name, String customer_state_desc,
			Integer status, String remark, Timestamp create_time, Integer creater, Timestamp update_time,
			Integer updater) {
		super();
		this.customer_state_id = customer_state_id;
		this.customer_state_name = customer_state_name;
		this.customer_state_desc = customer_state_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}
	@Override
	public String toString() {
		return "Customer_State [customer_state_id=" + customer_state_id + ", customer_state_name=" + customer_state_name
				+ ", customer_state_desc=" + customer_state_desc + ", status=" + status + ", remark=" + remark
				+ ", create_time=" + create_time + ", creater=" + creater + ", update_time=" + update_time
				+ ", updater=" + updater + "]";
	}
	public Integer getCustomer_state_id() {
		return customer_state_id;
	}
	public void setCustomer_state_id(Integer customer_state_id) {
		this.customer_state_id = customer_state_id;
	}
	public String getCustomer_state_name() {
		return customer_state_name;
	}
	public void setCustomer_state_name(String customer_state_name) {
		this.customer_state_name = customer_state_name;
	}
	public String getCustomer_state_desc() {
		return customer_state_desc;
	}
	public void setCustomer_state_desc(String customer_state_desc) {
		this.customer_state_desc = customer_state_desc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Integer getCreater() {
		return creater;
	}
	public void setCreater(Integer creater) {
		this.creater = creater;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public Integer getUpdater() {
		return updater;
	}
	public void setUpdater(Integer updater) {
		this.updater = updater;
	}
	
	
}
