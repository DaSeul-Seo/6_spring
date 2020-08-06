package com.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BookShopDao;
import com.model.BookShopVo;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ListCommand 호출");
		
		BookShopDao dao = BookShopDao.getInstance();
		ArrayList<BookShopVo> list = dao.getList();
		System.out.println("list.size() => " + list.size());
		req.setAttribute("list", list);
	}
}
