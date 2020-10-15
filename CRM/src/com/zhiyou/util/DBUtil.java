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
	 * ͨ����ɾ��,����һ��sql,�Լ�����ռλ���Ĳ���
	 */
	public static void DML(String sql,Object...objects){
		try {
			con=DriverManager.getConnection(URL+DB_NAME,USERNAME,PASSWORD);
			ps=con.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]); // ����������ռλ���Ĳ���
			}
			ps.execute();		//ִ��sql
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
	 * @param sql	 ��ѯ���
	 * @param class1 ����,ͨ����֪����ѯ��������һ��
	 * @param objects ��ѯ����������
	 * @return list���󼯺�
	 */
		
	public static <E>List<E> DQL(String sql,Class<E> class1,Object...objects){
		List<E> list = new ArrayList<>();
		try {
			con=DriverManager.getConnection(URL+DB_NAME,USERNAME,PASSWORD);
			ps=con.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]); // ����������ռλ���Ĳ���
			}
			rs=ps.executeQuery();	//ִ��sql,��ý��������
			// ��ȡ���ݿ������е�����
			ResultSetMetaData data = rs.getMetaData();
			// ����һ���ַ�������,�����洢�����е�����
			String[] array=new String [data.getColumnCount()];
			for (int i = 0; i < array.length; i++) {
				array[i]=data.getColumnLabel(i+1);	//������������������֮��
			}
			while(rs.next()){	//�ж��Ƿ�����һ����¼
				E e = class1.newInstance();  //ͨ�������calss ������һ������
				for (String string : array) {
					Object o = rs.getObject(string);	//ͨ��������ȡ�����е�����
					Field field = class1.getDeclaredField(string); //ʹ�÷���ͨ���������model������
					field.setAccessible(true); 	//�����Կ��Է���
					field.set(e, o);  //�����Ե�ֵ���뵽���� e֮��
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
