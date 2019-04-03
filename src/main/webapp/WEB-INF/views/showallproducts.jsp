<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<body>
<h2>All-Product-Details</h2>
<table border="2">
<tr><td>PCode</td><td>Name</td><td>Price</td><td>Pic</td></tr>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.pcode}</td>
<td>${product.pname}</td>
<td>${product.price}</td>
<td><img src="imageDisplay?pcode=${product.pcode}" width="50" height="50"/></td>
</c:forEach>
</table>
<a href="index.jsp">Home</a>
</body>
</html>
