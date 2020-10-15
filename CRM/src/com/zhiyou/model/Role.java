package com.zhiyou.model;

import java.sql.Timestamp;

public class Role {
private  Integer role_id;
private  String role_name;
private   Integer role_permission;
private   Integer status;
private   String remark;
private   Timestamp create_time;
private   Integer creater;
private   Timestamp update_time;
private   Integer updater;
public Integer getRole_id() {
	return role_id;
}
public void setRole_id(Integer role_id) {
	this.role_id = role_id;
}
public String getRole_name() {
	return role_name;
}
public void setRole_name(String role_name) {
	this.role_name = role_name;
}
public Integer getRole_permission() {
	return role_permission;
}
public void setRole_permission(Integer role_permission) {
	this.role_permission = role_permission;
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
	return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_permission=" + role_permission
			+ ", status=" + status + ", remark=" + remark + ", create_time=" + create_time + ", creater=" + creater
			+ ", update_time=" + update_time + ", updater=" + updater + "]";
}
public Role(Integer role_id, String role_name, Integer role_permission, Integer status, String remark,
		Timestamp create_time, Integer creater,Timestamp update_time2, Integer updater) {
	super();
	this.role_id = role_id;
	this.role_name = role_name;
	this.role_permission = role_permission;
	this.status = status;
	this.remark = remark;
	this.create_time = create_time;
	this.creater = creater;
	this.update_time = update_time2;
	this.updater = updater;
}
public Role() {
}
}
