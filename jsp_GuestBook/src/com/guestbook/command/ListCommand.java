package com.guestbook.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.model.GuestBookDAOImpl;
import com.guestbook.model.GuestBookVO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ListCommand");
		
		GuestBookDAOImpl dao = new GuestBookDAOImpl();
		List<GuestBookVO> list = dao.getList();
		request.setAttribute("list", list);
	}
}
