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
<td>oid</td>
<td>cid</td>
<td>quantity</td>
<td>warehouse</td>
<td>destination</td>
</tr>

<c:forEach items="${list}" var="list"><!--foreach(int a:arr) -->
<tr>
<td>${list.oid}</td>
<td>${list.cid}</td>
<td>${list.quantity}</td>
<td>${list.warehouse}</td>
<td>${list.destination}</td>
<td>
<a href="${pageContext.request.contextPath}/orderdetailscontroller/deleteOrderdetailsById.do?oid=${list.oid}&&cid=${list.cid}">删除</a>
<a href="${pageContext.request.contextPath}/rest/orderdetailscontroller/updateOrderdetailsById/${list.oid}/${list.cid}">修改</a> 
<a href="${pageContext.request.contextPath}/rest/orderdetailscontroller/insertIntoOrderdetails">添加商品</a>  
</td>
</tr>
</c:forEach>

</table>

</body>
</html>