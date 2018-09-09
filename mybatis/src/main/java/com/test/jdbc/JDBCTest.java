package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ͨ��ԭ��jdbc�ܽ�����
 * @author Administrator
 *
 */
public class JDBCTest {

	public static void main(String[] args) {
		//���ݿ�����
		Connection connection = null;
		//ʹ��Ԥ����������ݿ�
		PreparedStatement preparedStatement = null;
		//�����
		ResultSet resultSet = null;
		
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			
			//ͨ�������������ȡ���ݿ�����
			connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "root");
			//����sql��� ?��ʾռλ��
		    String sql = "select * from user where username = ?";
			//��ȡԤ����statement
			preparedStatement = connection.prepareStatement(sql);
			//���ò�������һ������Ϊsql����в�������ţ���1��ʼ�����ڶ�������Ϊ���õĲ���ֵ
			preparedStatement.setString(1, "�ַ�");
			//�����ݿⷢ��sqlִ�в�ѯ����ѯ�������
			resultSet =  preparedStatement.executeQuery();
			//������ѯ�����
			while(resultSet.next()){
				System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�����ͷ���Դ
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
