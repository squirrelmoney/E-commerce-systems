<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/orderdetailscontroller/updateOrderdetails.do">
oid:<input type="text" name="oid" id="oid" value="${list.oid}" readonly="readonly">
cid<input type="text" name="cid" id="cid" value="${list.cid}">
quantity:<input type="text" name="quantity" id="quantity" value="${list.quantity}">
wid:<input type="text" name="wid" id="wid" value="${list.wid}">
aid:<input type="text" name="aid" id="aid" value="${list.aid}">
<input type="submit" name="submit">
</form>

</body>
</html>