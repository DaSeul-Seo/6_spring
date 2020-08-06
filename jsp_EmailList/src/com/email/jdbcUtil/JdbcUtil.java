package com.email.jdbcUtil;

import java.sql.*;

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
			// TODO Auto-generated catch block
			System.out.println("Driver Search ERROR");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Conn ERROR");
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		if(conn !=null) {
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
