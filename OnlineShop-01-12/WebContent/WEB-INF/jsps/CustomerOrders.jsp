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
  <c:if test="${list.status==1}">
  <td>未发货</td>
  </c:if>
  <c:if test="${list.status==2}">
  <td>已发货<a href="${pageContext.request.contextPath}/rest/userController/updateUserpoints/${list.oid}/${list.username}">确认收货</a></td>
  </c:if>
  <c:if test="${list.status==3}">
  <td>已收货</td>
  </c:if>
  <td> 
    
    <a href="${pageContext.request.contextPath}/rest/OrderControl/deleteOrders/${list.oid}">删除</a>
    <a href="${pageContext.request.contextPath}/rest/CustomerController/customerorderdetails/${list.oid}">查看详情</a>
    <a href="${pageContext.request.contextPath}/rest/mainHomeController/homepage">返回</a>
  </td>
 </tr>
  </c:forEach>
 </table>
</body>
</html>