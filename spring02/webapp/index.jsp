<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String contextPath = request.getContextPath();
response.sendRedirect("/spring02/webapp/WEB-INF/views/form.jsp");
%>

</body>
</html>