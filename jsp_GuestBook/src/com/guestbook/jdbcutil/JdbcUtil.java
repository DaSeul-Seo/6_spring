package com.guestbook.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String password = "hr";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Search Error!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Conn Error");
			e.printStackTrace();
		}
		return conn;	
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	public static void close(ResultSet rs) {
		if(rs !=null) {
			try {rs.close();}
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	public static void close(Statement stmt) {
		if(stmt !=null) {
			try {stmt.close();}
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		close(rs);
		close(stmt);
		close(conn);
	}
}
