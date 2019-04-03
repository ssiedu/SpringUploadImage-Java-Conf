<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Product-Entry-Form</h3>
	<hr>
	<form action="saveproduct" method="post" enctype="multipart/form-data">
	<pre>
		PCode	<input type="text" name="pcode"/>
		PName	<input type="text"" name="pname"/>
		Price	<input type="text" name="price"/>
				<input type="file" name="file"/>
				<input type="submit" value="Save"/>
	</pre>
	</form>
	<hr>
	
	<a href="index.jsp">Home</a>

</body>
</html>