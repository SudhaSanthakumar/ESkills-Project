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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
Welcome to User Page!!!


${user }
${user.userName }
${currentUser }
<!--Textarea with icon prefix-->
<div class="md-form">
  <i class="fas fa-pencil-alt prefix"></i>
  <form action="${pageContext.request.contextPath}/user/${user.userId}/addMessage" method="post">
  <textarea name="message" id="form10" class="sm-textarea form-control" rows="3" cols="50"></textarea>
  
  <button class="btn btn-info btn-lg" type="submit">
          <span class="glyphicon glyphicon-plus-sign"></span> 
        </button>
       
    </form>
  
</div>
</body>
</html>