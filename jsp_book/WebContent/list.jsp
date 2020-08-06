<%@page import="com.model.BookShopDAOImpl"%>
<%@page import="com.model.BookShopVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<%
	BookShopDAOImpl dao = new BookShopDAOImpl();
	List<BookShopVo> list = dao.getList();
	System.out.println(list.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>책 정보 리스트</h1>
	<%-- list에서 하나씩 빼서 테이블를 채운다--%>
	<% 
		for(BookShopVo vo : list) {
	%>
		<table border="1" cellpadding="5" cellspacing="2">
			<tr>
				<td align=right width="110">Book Id: </td>
				<td width="170"><%=vo.getBook_id() %></td>
			</tr>
			<tr>
				<td align=right >Book Title: </td>
				<td><%=vo.getTitle() %></td>
			</tr>
			<tr>
				<td align=right>Pubs: </td>
				<td><%=vo.getPubs() %></td>
			</tr>
			
			<tr>
				<td align=right>Pubs Date: </td>
				<td><%=vo.getPub_date() %></td>
			</tr>
			
			<tr>
				<td align=right>Author Name: </td>
				<td><%=vo.getAuthor_name() %></td>
			</tr>
		</table>
		<br>
	<%		
		}
	%>
	<p>
		<a href="form.jsp?no">추가메일 등록</a>
	</p>
	<br>
</body>
</html>