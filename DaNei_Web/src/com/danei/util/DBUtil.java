package com.danei.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


public class DBUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection conn=null; 
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/employee?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="123456";
		conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public static void close(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception, SQLException   {
		Connection conn=getConnection();
		System.out.println("数据库连接成功！");
	}

}
