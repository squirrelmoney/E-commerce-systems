<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/commoditycontroller/insertCommodity.do">
cid:<input type="text" name="cid" id="cid" >
name<input type="text" name="name" id="name">
price:<input type="text" name="price" id="price">
points:<input type="text" name="points" id="points">
cost:<input type="text" name="cost" id="cost">
<input type="submit" name="submit">
</form>
</body>
</html>