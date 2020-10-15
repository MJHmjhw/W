package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;

public interface NoticeDao {
List<Notice> allNotice(int page);
int sum();

void addNotice(Notice notice);
void deleteNotice(int id);
void updateNotice(Notice notice);
Notice selectById(int id);

List<Notice> selectF(int page,String name);
int sum2(String name);
List<Department> departments();
Department selectByIdD(int id);
List<Notice> selectSubject(String name);
}
