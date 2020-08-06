package com.model;

import java.util.List;

public interface AuthorDAO {
	
	public List<BookShopVo> getList();
	public void insert();
}
