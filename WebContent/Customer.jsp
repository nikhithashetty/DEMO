<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CustomerServlet" method="post">
Customer id:--<input type="text" name="id"/></br>
Customer name:--<input type="text" name="name"></br>
Customer Address:--<input type="text" name="address"></br>
<button name="btn" value="submit" >Submit</button>
</form>
</body>
</html>





