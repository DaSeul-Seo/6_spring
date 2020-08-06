<%@page import="com.email.model.EmailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	EmailVO vo = (EmailVO)request.getAttribute("vo");
	System.out.println(vo.toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>등록이 완료되었습니다.</h1>
	<hr />
	<form>
		Last name(성): <%=vo.getLast_name() %><br>
		First name(이름): <%=vo.getFirst_name() %><br>
		Email address: <%=vo.getEmail() %><br>
	</form>
	<p>
		<a href="<%=request.getContextPath()%>/email?action=list">리스트 바로가기</a>
	</p>

</body>
</html>