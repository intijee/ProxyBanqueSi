<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<form method="POST" , action ="j_spring_security_check">
		
		<table>
			<tr>
				<td>Login :</td>
				<td><input type = "text" name ="j_username"/></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type = "text" name ="j_password"/></td>
			</tr>
			<tr>
				<td><input type = "submit" value ="Se Connecter"/></td>
			</tr>
		</table>
	
	
		</form>
	</div>

</body>
</html>