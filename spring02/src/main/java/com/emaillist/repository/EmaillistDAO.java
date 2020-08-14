package com.emaillist.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.emaillist.vo.EmaillistVO;

public class EmaillistDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmaillistVO> getList(){
		List<EmaillistVO> list = sqlSession.selectList("emaillist.insert");
		return list;
	}
	
	public int insert(EmaillistVO vo) {
		return sqlSession.insert("emaillist.insert", vo);
	}
	
	public EmaillistVO get(int no) {
		EmaillistVO vo = sqlSession.selectOne("emaillist.get", no);
		System.out.println(vo.toString());
		return vo;
	}
}
