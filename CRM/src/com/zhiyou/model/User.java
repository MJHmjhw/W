package com.zhiyou.model;

import java.sql.Timestamp;

public class User {
	private Integer user_id;
	private Integer department_id;
	private Integer role_id;
	private String username;
	private Boolean is_male;
	private String mobile;
	private Integer age;
	private String address;
	private Boolean is_admin;
	private Boolean is_system;
	private String password;
	private String tel;
	private String id_num;
	private String email;
	private String hobby;
	private Integer education;
	private String card_num;
	private String nation;
	private Integer marry;
	private Integer status;
	private String remark;
	private Timestamp create_time;
	private Integer creater;
	private Timestamp update_time;
	private Integer updater;
	public User() {
	
	}
	public User(Integer user_id, Integer department_id, Integer role_id, String username, Boolean is_male2,
			String mobile, Integer age, String address, Boolean is_admin, Boolean is_system, String password,
			String tel, String id_num, String email, String hobby, Integer education2, String card_num, String nation,
			Integer marry, Integer status, String remark, Timestamp create_time, Integer creater, Timestamp update_time,
			Integer updater) {
		super();
		this.user_id = user_id;
		this.department_id = department_id;
		this.role_id = role_id;
		this.username = username;
		this.is_male = is_male2;
		this.mobile = mobile;
		this.age = age;
		this.address = address;
		this.is_admin = is_admin;
		this.is_system = is_system;
		this.password = password;
		this.tel = tel;
		this.id_num = id_num;
		this.email = email;
		this.hobby = hobby;
		this.education = education2;
		this.card_num = card_num;
		this.nation = nation;
		this.marry = marry;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
		this.creater = creater;
		this.update_time = update_time;
		this.updater = updater;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getIs_male() {
		return is_male;
	}
	public void setIs_male(Boolean is_male) {
		this.is_male = is_male;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
	}
	public Boolean getIs_system() {
		return is_system;
	}
	public void setIs_system(Boolean is_system) {
		this.is_system = is_system;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getId_num() {
		return id_num;
	}
	public void setId_num(String id_num) {
		this.id_num = id_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getMarry() {
		return marry;
	}
	public void setMarry(Integer marry) {
		this.marry = marry;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", department_id=" + department_id + ", role_id=" + role_id + ", username="
				+ username + ", is_male=" + is_male + ", mobile=" + mobile + ", age=" + age + ", address=" + address
				+ ", is_admin=" + is_admin + ", is_system=" + is_system + ", password=" + password + ", tel=" + tel
				+ ", id_num=" + id_num + ", email=" + email + ", hobby=" + hobby + ", education=" + education
				+ ", card_num=" + card_num + ", nation=" + nation + ", marry=" + marry + ", status=" + status
				+ ", remark=" + remark + ", create_time=" + create_time + ", creater=" + creater + ", update_time="
				+ update_time + ", updater=" + updater + "]";
	}

	
	
}
