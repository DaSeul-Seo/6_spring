package com.model;

import java.util.List;

public interface BookShopDao {
	
	// 쿼리를 나눈다
	public List<BookShopVo> getList();
	public List<BookShopVo> get(BookShopVo vo);
	public void insert();
	public void update();
	public void delete();
}
