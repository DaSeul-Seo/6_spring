package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.ListCommand;

@WebServlet("/bookshop/*")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookController 호출");
		// 파라미터(action) 넘겨서 값이 list는 list처리
		String action = req.getParameter("action");
		String viewName = "/WEB-INF/bookshop/booklist.jsp";
		
		try {
			if(action.equals("booklist")) {
				ListCommand listcmd = new ListCommand();
				listcmd.execute(req, resp);
				viewName = "/WEB-INF/bookshop/booklist.jsp";
			}
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
