<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="n7.fr.metier.Materiel" %>
<% List<String> paths = (List<String>)request.getAttribute("paths"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<h1>Hello world</h1>
	<%for (String path : paths) {%>
	<li> <%= path %> </li>
	<%} %>
</ul>

<img src=<%=paths.get(13)%>>
</body>
</html> 