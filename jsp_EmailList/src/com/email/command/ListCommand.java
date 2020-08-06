package com.email.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.email.model.EmailDAOImpl;
import com.email.model.EmailVO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ListCommand");
		
		EmailDAOImpl dao = new EmailDAOImpl();
		List<EmailVO> list = dao.getList();
		request.setAttribute("list", list);
	}

}
