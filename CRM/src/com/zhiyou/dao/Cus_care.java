package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Care;

public interface Cus_care {
List<Customer_Care> allCare(int page);
 void deleteCare(int id);
 void addCare(Customer_Care care);
 void updateCare(Customer_Care care);
 Customer_Care selectById(int id);
 int sum();
 int sum2(String nString);
 List<Customer_Care> selectF(String name,int page);
 List<Customer> allCus();
 List<Customer_Care> selectByName(String name);
 
}
