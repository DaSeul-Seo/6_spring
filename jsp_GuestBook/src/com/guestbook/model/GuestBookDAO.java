package com.guestbook.model;

import java.util.List;

public interface GuestBookDAO {
	
	public List<GuestBookVO> getList();
	public void insert(GuestBookVO vo);
	public void delete(GuestBookVO vo);
	
}
