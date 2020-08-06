<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="delete.jsp" method="get">
    <table>
      <tr>
        <td>비밀번호</td>
        <td><input type="password" name="password"></td>
        <td><input type="submit" value="확인"></td>
        <td><a href="">메인으로 돌아가기</a></td>
      </tr>
      <input type="hidden" name="no" value="<%= request.getParameter("no") %>">
      <input type="hidden" name="dbPassWord" value="<%= request.getParameter("dbPassWord") %>">
    </table>
  </form>
</body>
</html>