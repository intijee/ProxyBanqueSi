<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home SSB</title>
<!-- JQuery libraries-->
<script type="text/javascript" src='<c:url value="/scripts/jquery.js"/>'></script>

<!-- Bootstrap libraries-->
<script type="text/javascript" src='<c:url value="/scripts/bootstrap.js"/>'></script>
<link rel="stylesheet" type="text/css" href='<c:url value="/style/bootstrap.css"/>'>


<!-- ref vers feuilles css -->
<link rel="stylesheet" type="text/css" href='<c:url value="/style/style.css"/>'>


<!-- ref vers feuilles js -->
<script type="text/javascript" src='<c:url value="/scripts/script.js"/>'></script>

</head>
<body>
	<div class="container-fluid" style="background-image: url('style/images/New-York-City.jpg'); ">
	<div class="row">
	<div  class="container" ">
	<div  class="col-xs-4" ></div>
		<div  class="col-xs-4" style="margin-top: 5%;">
			
			<h1 id="title1" style="color:#ffda28 ;  font-size: xx-large; text-align: center;"  >$KY-<br/>$CRAPPER <br/>BANK</h1>
			
		</div>
	<div  class="col-xs-4" ></div>
	</div>
		<div  class="container" style="height: 100%;">
				<div class="row">
	
					<div align="center">
					
						<form method="POST" , action ="j_spring_security_check">
						<table>
							<tr>
								<td>Login :</td>
								<td><input class="form-control" type = "text" name ="j_username"/></td>
							</tr>
							<tr>
								<td>Password :</td>
								<td><input class="form-control" type = "text" name ="j_password"/></td>
							</tr>
							<tr>
								<td><input class="btn btn-primary" type = "submit" value ="Connexion"/></td>
							</tr>
						</table>
						</form>
						
					</div>
			</div>
		</div>
	</div>

<br/>
	
</div>


</body>
</html>