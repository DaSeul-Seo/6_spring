<%
String viewName = "/WEB-INF/views/list.jsp";
RequestDispatcher view = request.getRequestDispatcher(viewName);
view.forward(request, response);
%>