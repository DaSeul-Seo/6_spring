package com.guestbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.command.DeleteCommand;
import com.guestbook.command.InsertCommand;
import com.guestbook.command.ListCommand;

@WebServlet("/guestbook/*")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글설정
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println("GuestBookController");
		String action = request.getParameter("action");
		String viewName = "/WEB-INF/views/list.jsp";
		
		try {
			if(action.equals("list")) {
				ListCommand listcmd = new ListCommand();
				listcmd.execute(request, response);
				viewName = "/WEB-INF/views/list.jsp";
			}
			if(action.equals("add")) {
				InsertCommand insertcmd = new InsertCommand();
				insertcmd.execute(request, response);
				viewName = "/WEB-INF/views/list.jsp";
			}
			if(action.equals("deleteform")) {
				viewName = "/WEB-INF/views/deleteform.jsp";
//				response.sendRedirect("/guestbook?action=deleteform");
			}
			if(action.equals("delete")) {
				DeleteCommand deletecmd = new DeleteCommand();
				deletecmd.execute(request, response);
				viewName = "/WEB-INF/views/list.jsp";
			}
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
