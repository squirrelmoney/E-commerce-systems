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
warehouse:<input type="text" name="warehouse" id="warehouse" value="${list.warehouse}">
destination:<input type="text" name="destination" id="destination" value="${list.destination}">
<input type="submit" name="submit">
</form>

</body>
</html>