<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <style>
  .loginform{
  	display:table;
  	margin-left:auto;
  	margin-right:auto;
  	
  }
  </style>
</head>
<body>
<div class="container-fluid">
 <jsp:include page="header.jsp"></jsp:include>
 <div class="loginform">
<form action="${pageContext.request.contextPath}/uu"  method="POST">
  <div class="form-group">
    <label for="userName">UserName</label>
    <input type="text" name="userName" class="form-control" id="" placeholder="User Name">
   
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password" class="form-control" id="" placeholder="Password">
  </div>
   <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
</body>
</html>