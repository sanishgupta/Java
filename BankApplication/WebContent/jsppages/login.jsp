<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%! String msg ; %>
<form action="validation.do"  method="get">
<% msg = request.getParameter("msg"); 
	if(msg != null) {%>
		<h1><%=msg %></h1>
		<h1>${msg}</h1>
	<%} %>


<table>
<tr><td>User Name</td><td> :</td> <td><input type="text" name="uname" value="${request.uname }" size="20" /></td></tr>
<tr><td>Password </td><td>:</td><td><input type="password" name="passwd" value="${request.passwd}" size="20" /></td></tr>

<tr><td></td><td><input type="submit" value="Login"/></td><td></td></tr>
</table>
</form>
</body>
</html>