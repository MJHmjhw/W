package com.zhiyou.model;

import java.sql.Timestamp;
import java.util.Date;

public class Customer_Category {
	private Integer customer_category_id;
	private String customer_category_name;
	private String customer_category_desc;
	private Integer status;
	private String remark;
	private Timestamp create_time;
	private Integer creater;
	private Timestamp update_time;
	private Integer updater;
	public Customer_Category(Integer customer_category_id, String customer_category_name, String customer_category_desc,
			Integer status, String remark, Timestamp create_time, Integer creater, Timestamp update_time,
			Integer updater) {
		super();
		this.customer_category_id = customer_category_id;
		this.customer_category_name = customer_category_name;
		this.customer_category_desc = customer_category_desc;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}
	public Customer_Category() {
		super();
	}
	@Override
	public String toString() {
		return "Customer_Category [customer_category_id=" + customer_category_id + ", customer_category_name="
				+ customer_category_name + ", customer_category_desc=" + customer_category_desc + ", status=" + status
				+ ", remark=" + remark + ", create_time=" + create_time + ", creater=" + creater + ", update_time="
				+ update_time + ", updater=" + updater + "]";
	}
	public Integer getCustomer_category_id() {
		return customer_category_id;
	}
	public void setCustomer_category_id(Integer customer_category_id) {
		this.customer_category_id = customer_category_id;
	}
	public String getCustomer_category_name() {
		return customer_category_name;
	}
	public void setCustomer_category_name(String customer_category_name) {
		this.customer_category_name = customer_category_name;
	}
	public String getCustomer_category_desc() {
		return customer_category_desc;
	}
	public void setCustomer_category_desc(String customer_category_desc) {
		this.customer_category_desc = customer_category_desc;
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
