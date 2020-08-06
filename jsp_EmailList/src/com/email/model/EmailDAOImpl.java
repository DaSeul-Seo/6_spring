package com.email.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.email.jdbcUtil.JdbcUtil;

import oracle.jdbc.OracleConnection.CommitOption;

public class EmailDAOImpl implements EmailDAO {
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int cnt = 0;
	
	@Override
	public List<EmailVO> getList() {
		List<EmailVO> list = new ArrayList<EmailVO>();
		
		try {
			conn = JdbcUtil.getConnection();
			String query = "select * from emaillist order by no asc";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String last_name = rs.getString("last_name");
				String first_name = rs.getString("first_name");
				String email = rs.getString("email");
				
				EmailVO vo = new EmailVO(no, last_name, first_name, email);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public void insert(EmailVO vo) {
		try {
			conn = JdbcUtil.getConnection();
			String query = "insert into emaillist values(seq_emaillist_no.nextval, ?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getLast_name());
			pstmt.setString(2, vo.getFirst_name());
			pstmt.setString(3, vo.getEmail());
			// 업데이트
			cnt = pstmt.executeUpdate();
			if(cnt<=0) {
				System.out.println("INSERT ERROR : Rollback");
				conn.rollback();
			} else {
				System.out.println("INSERT SUCCESS : Commit");
				conn.commit();
			}

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}
		
	}
}
