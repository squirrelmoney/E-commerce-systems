<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addressescontroller/insertIAddresses.do?">
username:<input type="text" name="username" id="username">
address<input type="text" name="address" id="address" >
phone:<input type="text" name="phone" id="phone" >
name:<input type="text" name="name" id="name" >
defaultadress:<input type="text" name="defaultadress" id="defaultadress" >
<input type="submit" name="submit">
</form>
</body>
</html>