<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.GuestbookDao"%>
<%@ page import="com.javaex.dao.GuestbookDaoImpl"%>
<%@ page import="com.javaex.vo.GuestbookVo"%>

<%
	request.setCharacterEncoding("UTF-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String password = request.getParameter("password");
	String dbpassword = request.getParameter("dbPassWord");
	
	GuestbookVo vo = new GuestbookVo();
	vo.setNo(no);
	vo.setPassword(password);
	
	GuestbookDao dao = new GuestbookDaoImpl();
	
  if(dbpassword.equals(dbpassword)) {
    dao.delete(vo);
    response.sendRedirect("list.jsp");
  }else{
    System.out.print("에러 발생:"+this.getServletName());
  }
	
%>

