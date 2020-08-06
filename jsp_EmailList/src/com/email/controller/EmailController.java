package com.email.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.email.command.InsertCommand;
import com.email.command.ListCommand;

@WebServlet("/email/*")
public class EmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 설정
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println("EmailController 호출");
		String action = request.getParameter("action");
		String viewName = "/WEB-INF/email/form.jsp";
		
		try {
			if(action.equals("list")) {
				ListCommand listcmd = new ListCommand();
				listcmd.execute(request, response);
				viewName = "/WEB-INF/email/list.jsp";
			}
			if(action.equals("insert")) {
				InsertCommand insertcmd = new InsertCommand();
				insertcmd.execute(request, response);
				viewName = "/WEB-INF/email/insert.jsp";
			}
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
