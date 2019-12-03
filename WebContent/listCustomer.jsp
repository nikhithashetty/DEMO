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
 <table border=1>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
              
               <th>Address</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${Customer}" var="customer">
                <tr>
                    <td><c:out value="${customer.cust_id}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                
                    <td><c:out value="${customer.address}" /></td>
                    <td><a href="CustomerServlet?action=edit&id=<c:out value="${customer.cust_id}"/>">Update</a></td>
                    <td><a href="CustomerServlet?action=delete&id=<c:out value="${customer.cust_id}"/>">Delete</a></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="Customer.jsp">Add customers</a>
</body>
</html>