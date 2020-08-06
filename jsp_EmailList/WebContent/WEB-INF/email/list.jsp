<%@page import="com.email.model.EmailVO"%>
<%@page import="java.util.List"%>
<%@page import="com.email.model.EmailDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmailDAOImpl dao = new EmailDAOImpl();
	List<EmailVO> list = dao.getList();
	System.out.println(list.toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<!-- 메일정보 리스트 -->
	<%-- list에서 하나씩 빼서 테이블를 채운다--%>
	<%
		for(EmailVO vo : list){
	%>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right width="110">no</td>
			<td width="170"><%=vo.getNo() %></td>
		</tr>
		<tr>
			<td align=right>Last name</td>
			<td width="170"><%=vo.getLast_name() %></td>
		</tr>
		<tr>
			<td align=right>First name</td>
			<td width="170"><%=vo.getFirst_name() %></td>
		</tr>
		<tr>
			<td align=right>Email address</td>
			<td width="170"><%=vo.getEmail() %></td>
		</tr>
	</table>
	<br>
	<%
		}
	%>
	<p>
		<a href="<%=request.getContextPath()%>/email?action=form">추가메일 등록</a>
	</p>
	<br>
</body>
</html>