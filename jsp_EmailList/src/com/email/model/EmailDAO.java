package com.email.model;

import java.util.List;

public interface EmailDAO {
	
	public List<EmailVO> getList();
	public void insert(EmailVO vo);
}
