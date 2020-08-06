package com.guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.model.GuestBookDAOImpl;
import com.guestbook.model.GuestBookVO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteCommand");
		
		String password = request.getParameter("password");
		
		GuestBookVO vo = new GuestBookVO(0, null, password, null, null);
		GuestBookDAOImpl dao = new GuestBookDAOImpl();
		dao.delete(vo);
	}
}
