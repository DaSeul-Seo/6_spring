package com.guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.model.GuestBookDAOImpl;
import com.guestbook.model.GuestBookVO;

public class InsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertCommand");
		
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String content = request.getParameter("content");
		
		GuestBookVO vo = new GuestBookVO(0, name, password, content, null);
		GuestBookDAOImpl dao = new GuestBookDAOImpl();
		dao.insert(vo);
		request.setAttribute("vo", vo);
	}
}
