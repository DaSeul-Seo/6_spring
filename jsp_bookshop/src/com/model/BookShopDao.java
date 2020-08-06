package com.model;

import java.sql.*;
import java.util.ArrayList;

import com.jdbcUtil.JdbcUtil;

public class BookShopDao {
	private static BookShopDao instance;
	
	public BookShopDao() {}
	
	public static BookShopDao getInstance() {
		if(instance == null) {
			instance = new BookShopDao();
		}
		return instance;
	}
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	String SQL_JOIN = "SELECT B.BOOK_ID, B.TITLE, B.PUBS, B.PUB_DATE, A.AUTHOR_NAME FROM BOOK B, AUTHOR A WHERE B.BOOK_ID = A.AUTHOR_ID";
	String SQL_SELECTALL = "SELECT B.BOOK_ID, B.TITLE, B.PUBS, B.PUB_DATE, A.AUTHOR_NAME FROM BOOK B JOIN AUTHOR A ON B.BOOK_ID = A.AUTHOR_ID where b.title LIKE '%' || ? || '%'";
	
	public ArrayList<BookShopVo> getList() {
		ArrayList<BookShopVo> list = new ArrayList<>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_JOIN);
			while(rs.next()) {
				BookShopVo vo = new BookShopVo();
				vo.setBook_id(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPubs(rs.getString(3));
				vo.setPub_date(rs.getDate(4));
				vo.setAuthor_name(rs.getString(5));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return list;	
	}
	
	public void select() {
		
	}
}
