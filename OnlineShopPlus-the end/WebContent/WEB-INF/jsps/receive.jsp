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
<form action="${pageContext.request.contextPath}/OrderdetailsController/updateByoid.do" method="post">
账号：<input id="username" type="text" value="${username}" readonly="readonly">
订单号：<input id="oid" name="oid" type="text" value="${oid}" readonly="readonly">
<sql:setDataSource
	var="OnlineShop"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/OnlineShop"
	user="root"
	password="123"
/>	
收货地址：<sql:query var="result" dataSource="${OnlineShop}" sql="select * from addresses where username='${username}'"/>

			<select name="aid">
				<c:forEach var="re" items="${result.rows}">
					<option selected value="${re.aid}">
						<c:out value="${re.address}"></c:out>
					</option>
				</c:forEach>
			</select>
<input type="submit" value="提交">
</form>
</body>
</html>