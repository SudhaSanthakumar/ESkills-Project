<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
Welcome to User message Page!!!


${user }<br>
${user.userName }<br>

<c:forEach items="${usersList}" var="user">
        <li><a href="${pageContext.request.contextPath}/${user_role}/showUser/${user.userId}">${user.userName}</a></li>
</c:forEach>

<a href="${pageContext.request.contextPath}/${user_role}/addUser"><button name="addUser">Add User</button></a>

</body>
</html>