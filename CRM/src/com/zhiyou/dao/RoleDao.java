package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Role;

public interface RoleDao {
List<Role> allRole(int page);
void updateRole(Role role);
void deleteRole(int id);
void addRole(Role role);
List<Role> selectById(int id);
int sum();
List<Role> selectF(String name,int page);
int sum2(String name);
List<Role> selectByName(String name);
}
