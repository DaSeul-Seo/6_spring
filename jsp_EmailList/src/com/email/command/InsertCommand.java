package com.email.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.email.model.EmailDAOImpl;
import com.email.model.EmailVO;

public class InsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertCommand");
		
		String last_name = request.getParameter("ln");
		String first_name = request.getParameter("fn");
		String email = request.getParameter("email");
		
		EmailVO vo = new EmailVO(0, last_name, first_name, email);
		EmailDAOImpl dao = new EmailDAOImpl();
		dao.insert(vo);
		request.setAttribute("vo", vo);
	}
}
