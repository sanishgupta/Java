<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("uname") %></title>
</head>
<body >
<h1>Account Opening form</h1>
<table align="right" width="100"><tr><td><h2><u><a href=>Logout</a></u></h2></td></tr></table>
<FORM action='OpenAccountForm.do' method='get'  > 

<table> 
<tr><td> 
First Name </td><td>:</td> <td><input type=text name=fname size='20' > <br></td></tr> 
<tr><td>Last Name </td> <td>:</td><td> <input type=text name=lname size='20' > <br></td></tr> 
<tr><td>Password  </td> <td>: </td><td><input type=password name=passwd size='20' > <br></td></tr> 
<tr><td>Age </td> <td>:</td><td> <input type=text name=age size='3' > <br></td></tr>  
<tr><td>Gender	</td><td> : </td><td><input type='radio' name='sex' value='male' /> Male 
<input type='radio' name='sex' value='female' /> Female <br></td></tr> 
<tr><td>Maritual Status </td><td>:</td><td> <input type='radio' name='matstatus' value='male' /> Married  
<input type='radio' name='matstatus' value='female' /> Unmarried <br></td></tr>
<tr><td>Address</td><td> : </td><td><textarea rows='10' cols='10' name='address'></textarea></td></tr> 
<tr><td>City </td><td>:</td> <td><select name='city'> 
<option>Delhi</option>  
<option>Bhopal</option> 
<option>Banglore</option> 
<option>Mumbai</option> 
</select> 
<br/></td></tr>  
<tr><td>Country </td><td>: </td><td><select name='country'> 
<option>India</option> 
<option>US</option>  
<option>UK</option> 
<option>England</option>  
</select> 
<br/></td></tr> 
<tr><td><input type=submit value='Submit' ></td><td></td> 
<td><input type=reset value='Reset' ></td>  
</tr></table></FORM>
</body>
</html>