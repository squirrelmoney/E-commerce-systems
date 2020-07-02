<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>username</td>
<td>name</td>
<td>phone</td>
<td>points</td>
</tr>
<c:forEach items="${list}" var="list"><!--foreach(int a:arr) -->
<tr>
<td>${list.username}</td>
<td>${list.name}</td>
<td>${list.phone}</td>
<td>${list.points}</td>
<td>
<a href="${pageContext.request.contextPath}/rest/userdetailscontroller/deleteUserdetailsById/${list.username}">删除</a>
<a href="${pageContext.request.contextPath}/rest/userdetailscontroller/updateUserdetailsById/${list.username}">修改</a>  
</td>
</tr>
</c:forEach>

</table>

</body>
</html>