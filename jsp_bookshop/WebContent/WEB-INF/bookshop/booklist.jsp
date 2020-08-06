<%@page import="com.model.BookShopVo"%>
<%@page import="com.model.BookShopDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
<%!
BookShopDao dao = new BookShopDao();
ArrayList<BookShopVo> list = dao.getList();
%>
<h1>Book List</h1>
<hr />
Search : <input type="text" /><input type="button" value="search" />

<table border="1">
	<tr>
		<td>book_id</td>
		<td>title</td>
		<td>pubs</td>
		<td>pub_date</td>
		<td>author_name</td>
	</tr>
	<%
	
	for(int i = 0; i<list.size(); i++){
		int book_id = list.get(i).getBook_id();
		String title = list.get(i).getTitle();
		String pubs = list.get(i).getPubs();
		Date pub_date = list.get(i).getPub_date();
		String author_name = list.get(i).getAuthor_name();
	%>
	<tr>
		<td><%=book_id %></td>
		<td><%=title %></td>
		<td><%=pubs %></td>
		<td><%=pub_date %></td>
		<td><%=author_name %></td>
	</tr>
	<%
	} // end for
	%>
</table>

</body>
</html>