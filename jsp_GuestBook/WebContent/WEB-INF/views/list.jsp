﻿<%@page import="com.guestbook.model.GuestBookVO"%>
<%@page import="java.util.List"%>
<%@page import="com.guestbook.model.GuestBookDAOImpl"%>
<% 
	GuestBookDAOImpl dao = new GuestBookDAOImpl();
	List<GuestBookVO> list = dao.getList();
	System.out.println(list.toString());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/guestbook?action=add" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br/>
	<%
		for(GuestBookVO vo : list) {
	%>
	<table width=510 border=1>
		<tr>
			<td><%=vo.getNo() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getReg_date() %></td>
			<td><a href="<%=request.getContextPath() %>/guestbook?action=deleteform">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getContent() %></td>
		</tr>
	</table>
    <br/>
       <%
		}
       %>
</body>
</html>