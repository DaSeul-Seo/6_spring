<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.GuestbookDaoImpl"%>
<%@ page import="com.javaex.vo.GuestbookVo"%>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	
	// 사용자가 입력한 내용 = vo
	GuestbookVo vo = new GuestbookVo(name, password, content);
	GuestbookDaoImpl dao = new GuestbookDaoImpl();
	dao.insert(vo);
	
	response.sendRedirect("list.jsp");
%>
