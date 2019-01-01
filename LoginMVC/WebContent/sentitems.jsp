<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sentitems page</title>
</head>
<body>
	<%
		if (session.getAttribute("username") != null) {
	%>
	<div>
	  welcome <%= session.getAttribute("username") %>
	</div>
	<form action="inbox.jsp" method="post">
		<input type="submit" value="Sent Items">
	</form>
	<form action="Logout" method="post">
		<input type="submit" value="Log out">
	</form>
	<%
		} else {
	%>
	<jsp:forward page="error.jsp" />
	<%
		}
	%>
</body>
</html>