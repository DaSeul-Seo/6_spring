package com.guestbook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.guestbook.jdbcutil.JdbcUtil;

public class GuestBookDAOImpl implements GuestBookDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int cnt = 0;
	
	public GuestBookDAOImpl() {
		conn = JdbcUtil.getConnection();
	}
	
	String GETLIST = "SELECT * FROM GUESTBOOK ORDER BY NO DESC";
	String INSERT = "INSERT INTO GUESTBOOK VALUES(SEQ_GUESTBOOK_NO.NEXTVAL, ?, ?, ?, SYSDATE)";
	String DELETE = "DELETE FROM GUESTBOOK WHERE PASSWORD=?";
	
	@Override
	public List<GuestBookVO> getList() {
		List<GuestBookVO> list = new ArrayList<GuestBookVO>();
		
		try {
			pstmt = conn.prepareStatement(GETLIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String content = rs.getString("content");
				Date reg_date = rs.getDate("reg_date");
				
				GuestBookVO vo = new GuestBookVO(no, name, password, content, reg_date);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, null);
		}		
		return list;
	}

	@Override
	public void insert(GuestBookVO vo) {
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContent());
			
			cnt = pstmt.executeUpdate();
			if(cnt<=0) {
				System.out.println("INSERT ERROR : ROLLBACK!");
				conn.rollback();
			} else {
				System.out.println("INSERT SUCCESS : COMMIT!");
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, null);
		}
	}

	@Override
	public void delete(GuestBookVO vo) {
		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, vo.getPassword());
			
			cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println("DELETE ERROR");
			}
		} catch (SQLException e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, null);
		}
	}
}
