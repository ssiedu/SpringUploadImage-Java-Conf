<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
<h3>Product-Details</h3>
<hr>
	<pre>
	Code	${product.pcode}
	Name	${product.pname}
	Price	${product.price}
	<img src="imageDisplay?pcode=${product.pcode}" width="100" height="100"/>
	</pre>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>