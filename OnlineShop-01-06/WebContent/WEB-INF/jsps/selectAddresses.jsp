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
<td>address</td>
<td>phone</td>
<td>name</td>
<td>defaultadress</td>
</tr>

<c:forEach items="${list}" var="list"><!--foreach(int a:arr) -->
<tr>
<td>${list.username}</td>
<td>${list.address}</td>
<td>${list.phone}</td>
<td>${list.name}</td>
<td>${list.defaultadress}</td>
<td>
<a href="${pageContext.request.contextPath}/rest/addressescontroller/deleteAddressesByList/${list}">删除</a>
<a href="${pageContext.request.contextPath}/rest/addressescontroller/updateAddressesByList/${list.username}">修改</a> 
<a href="${pageContext.request.contextPath}/rest/addressescontroller/insertIntoAddressesByList">添加地址</a>  
</td>
</tr>
</c:forEach>

</table>

</body>
</html>