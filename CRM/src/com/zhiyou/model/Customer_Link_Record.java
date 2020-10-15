package com.zhiyou.model;

import java.sql.Timestamp;
import java.util.Date;

public class Customer_Link_Record {
	private Integer record_id;
	private Integer customer_id;
	private String link_type;
	private String link_subject;
	private String link_nexttime;
	private Integer status;
	private String remark;
	private Timestamp next_time;
	private Timestamp create_time;
	private Integer creater;
	private Timestamp update_time;
	private Integer updater;
	public Customer_Link_Record(Integer record_id, Integer customer_id, String link_type, String link_subject,
			String link_nexttime, Integer status, String remark, Timestamp next_time, Timestamp create_time,
			Integer creater, Timestamp update_time, Integer updater) {
		super();
		this.record_id = record_id;
		this.customer_id = customer_id;
		this.link_type = link_type;
		this.link_subject = link_subject;
		this.link_nexttime = link_nexttime;
		this.status = status;
		this.remark = remark;
		this.next_time = next_time;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}
	public Customer_Link_Record() {
		super();
	}
	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getLink_type() {
		return link_type;
	}
	public void setLink_type(String link_type) {
		this.link_type = link_type;
	}
	public String getLink_subject() {
		return link_subject;
	}
	public void setLink_subject(String link_subject) {
		this.link_subject = link_subject;
	}
	public String getLink_nexttime() {
		return link_nexttime;
	}
	public void setLink_nexttime(String link_nexttime) {
		this.link_nexttime = link_nexttime;
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
	public Timestamp getNext_time() {
		return next_time;
	}
	public void setNext_time(Timestamp next_time) {
		this.next_time = next_time;
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
		return "Customer_Link_Record [record_id=" + record_id + ", customer_id=" + customer_id + ", link_type="
				+ link_type + ", link_subject=" + link_subject + ", link_nexttime=" + link_nexttime + ", status="
				+ status + ", remark=" + remark + ", next_time=" + next_time + ", create_time=" + create_time
				+ ", creater=" + creater + ", update_time=" + update_time + ", updater=" + updater + "]";
	}
	
	
}
