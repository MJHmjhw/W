package com.zhiyou.model;

import java.sql.Timestamp;
import java.util.Date;

public class Customer_Source {
	private Integer customer_source_id;
	private String customer_source_name;
	private String customer_source_desc;
	private Integer status;
	private String remark;
	private Timestamp create_time;
	private Integer creater;
	private Timestamp update_time;
	private Integer updater;
	public Integer getCustomer_source_id() {
		return customer_source_id;
	}
	public void setCustomer_source_id(Integer customer_source_id) {
		this.customer_source_id = customer_source_id;
	}
	public String getCustomer_source_name() {
		return customer_source_name;
	}
	public void setCustomer_source_name(String customer_source_name) {
		this.customer_source_name = customer_source_name;
	}
	public String getCustomer_source_desc() {
		return customer_source_desc;
	}
	public void setCustomer_source_desc(String customer_source_desc) {
		this.customer_source_desc = customer_source_desc;
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
	@Override
	public String toString() {
		return "Customer_Source [customer_source_id=" + customer_source_id + ", customer_source_name="
				+ customer_source_name + ", customer_source_desc=" + customer_source_desc + ", status=" + status
				+ ", remark=" + remark + ", create_time=" + create_time + ", creater=" + creater + ", update_time="
				+ update_time + ", updater=" + updater + "]";
	}
	public Customer_Source(Integer customer_source_id, String customer_source_name, String customer_source_desc,
			Integer status, String remark, Timestamp create_time, Integer creater, Timestamp update_time,
			Integer updater) {
		super();
		this.customer_source_id = customer_source_id;
		this.customer_source_name = customer_source_name;
		this.customer_source_desc = customer_source_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}
	public Customer_Source() {
		super();
	}
	
	
}
