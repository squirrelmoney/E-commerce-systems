<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
</head>
<body>
<table border="1">
<tr>
	<td>订单编号</td>
	<td>账号</td>	
	<td>运费</td>	
	<td>状态</td>	
</tr>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.oid}</td>
			<td>${list.username}</td>	
			<td>${list.freight}</td>	
			<td>${list.status}</td>					
		</tr>
	</c:forEach>
</table>	
</body>
</html>