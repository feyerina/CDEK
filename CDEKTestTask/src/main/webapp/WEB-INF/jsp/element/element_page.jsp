<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Element Page</title>
</head>
<body>
<spring:url value="/element/add" var="addURL" />
 <a href="${addURL }">Add Element</a>

 <h1>Users List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>s
   <th>Name</th>
  </tr>
  <c:forEach items="${listElement }" var="element" >
   <tr>
    <td>${element.id }</td>
    <td>${element.name }</td>    
   </tr>    
  </c:forEach>
 </table>
</body>
</html>