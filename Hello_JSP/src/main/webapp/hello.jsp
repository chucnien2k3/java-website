<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<%out.println("Đây là nhà của tao m hiểu không"); %>
	<p>Data: <%=new Date() %></p>
	<%!int cong=0; %>
	<p>Tong: <%=cong++ %></p>
</body>
</html>