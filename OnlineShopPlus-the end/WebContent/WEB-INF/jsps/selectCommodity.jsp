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
<td>cid</td>
<td>name</td>
<td>price</td>
<td>points</td>
<td>cost</td>
</tr>
<c:forEach items="${list}" var="list"><!--foreach(int a:arr) -->
<tr>
	<td>${list.cid}</td>
	<td>${list.name}</td>
	<td>${list.price}</td>
	<td>${list.points}</td>
	<td>${list.cost}</td>
	<td>
	<a href="${pageContext.request.contextPath}/commoditycontroller/deleteCommodityById.do?cid=${list.cid}">删除</a>
	<a href="${pageContext.request.contextPath}/rest/commoditycontroller/updateCommodityById/${list.cid}">修改</a> 
	<a href="${pageContext.request.contextPath}/rest/commoditycontroller/insertIntoCommodity/${list.cid}">添加商品</a>  
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>