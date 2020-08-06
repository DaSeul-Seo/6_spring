package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbcUtil.JdbcUtil;

public class BookShopDAOImpl implements BookShopDao {
	// 쿼리를 나눈다
	@Override
	public List<BookShopVo> getList() {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 제네릭
		List<BookShopVo> list = new ArrayList<BookShopVo>();

		try {			
			// 3. SQL문 준비 / 바인딩 / 실행
			conn = JdbcUtil.getConnection();
			String query = "select \r\n" + 
					"    b.book_id, \r\n" + 
					"    b.title, \r\n" + 
					"    b.pubs, \r\n" + 
					"    b.pub_date, \r\n" + 
					"    a.author_name\r\n" + 
					"from book b, author a\r\n" + 
					"where b.author_id = a.author_id" ;
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			// 4.결과처리
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pub_date = rs.getString("pub_date");
				String author_name = rs.getString("author_name");
				
				// 한 줄 한 줄 list에 넣는다.
				BookShopVo vo = new BookShopVo(book_id, title, pubs, pub_date, author_name);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			JdbcUtil.close(rs, pstmt, conn);
		}	
		return list;
	}

	@Override
	public List<BookShopVo> get(BookShopVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
}
