<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/logincontroller/InsertUser.do">
username:<input type="text" name="username" id="username">
password:<input type="text" name="password" id="password">
authority:<input  type="hidden" value="1" name="authority" id="authority">
<input type="submit" name="submit">
</form>
</body>
</html>