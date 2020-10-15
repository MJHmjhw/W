package com.zhiyou.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

	private static final String URL="jdbc:mysql:///";
	private static final String DB_NAME="crm";
	private static final String USERNAME="root";
	private static final String PASSWORD="123456";
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通用增删改,接收一条sql,以及任意占位符的参数
	 */
	public static void DML(String sql,Object...objects){
		try {
			con=DriverManager.getConnection(URL+DB_NAME,USERNAME,PASSWORD);
			ps=con.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]); // 传递了所有占位符的参数
			}
			ps.execute();		//执行sql
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * @param sql	 查询语句
	 * @param class1 反射,通过其知道查询的类是哪一个
	 * @param objects 查询的条件参数
	 * @return list对象集合
	 */
		
	public static <E>List<E> DQL(String sql,Class<E> class1,Object...objects){
		List<E> list = new ArrayList<>();
		try {
			con=DriverManager.getConnection(URL+DB_NAME,USERNAME,PASSWORD);
			ps=con.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]); // 传递了所有占位符的参数
			}
			rs=ps.executeQuery();	//执行sql,获得结果集对象
			// 获取数据库所有列的名称
			ResultSetMetaData data = rs.getMetaData();
			// 创建一个字符串数组,用来存储所有列的名称
			String[] array=new String [data.getColumnCount()];
			for (int i = 0; i < array.length; i++) {
				array[i]=data.getColumnLabel(i+1);	//将所有列名存在数组之中
			}
			while(rs.next()){	//判断是否有下一条记录
				E e = class1.newInstance();  //通过传入的calss 创建了一个对象
				for (String string : array) {
					Object o = rs.getObject(string);	//通过列名获取了列中的数据
					Field field = class1.getDeclaredField(string); //使用反射通过列名获得model类属性
					field.setAccessible(true); 	//让属性可以访问
					field.set(e, o);  //将属性的值放入到对象 e之中
				}
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return list;
	}
	
	
	
}
