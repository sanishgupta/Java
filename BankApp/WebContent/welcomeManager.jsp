<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("uname") %></title>
</head>
<body>
<table align="right" width="100"><tr><td><h2><u><a href=>Logout</a></u></h2></td></tr></table>
<h1>Welcome <%=session.getAttribute("uname") %></h1>

<h2><a href='OpenAccount.jsp'>Open Account</a></h2>
<h2><a href=>Close Account</a></h2>
<h2><a href=>Check Balance</a></h2>
<h2><a href=>List of Account's</a></h2>

</body>
</html>