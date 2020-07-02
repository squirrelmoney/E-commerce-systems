<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="3">
<tr>
<td>订单编号</td>
<td>商品编号</td>
<td>数量</td>
<td>发货地址</td>
<td>收货地址</td>
</tr>
  <c:forEach items="${list}" var="list">
  <tr>
  <td>${list.oid}</td>
  <td>${list.cid}</td>
  <td>${list.number}</td>
  <td>${list.wid}</td>
  <td>${list.aid}</td>
   
  <td> 
    <a href="${pageContext.request.contextPath}/rest/CustomerController/customerorders">返回</a>
  </td>
 </tr>
  </c:forEach>
 </table>
</body>
</html>