<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Homepage</title>
</head>
<body>
<table border="1">
<c:set var="user" value="${sessionScope.user}"></c:set>
<tr>
<td>商品编号</td>
<td>名称</td>
<td>价格</td>
<td>积分</td>
<td><a href="${pageContext.request.contextPath}/rest/CustomerController/Customerdetails">个人信息</a></td>
<td><a href="${pageContext.request.contextPath}/rest/CartController/tolistCart">我的购物车</a></td>
<td><a href="${pageContext.request.contextPath}/rest/CustomerController/customerorders">我的订单</a></td>
<td><a href="${pageContext.request.contextPath}/rest/LoginController/Loginuser">登录</a></td>
<c:if test="${user}!=null">
<td><a href="${pageContext.request.contextPath}/rest/LoginController/exit">退出登录</a></td>
</c:if>
<c:if test="${user}==null">
<td><a href="${pageContext.request.contextPath}/rest/LoginController/exit">注册</a></td>
</c:if>
</tr>
 
 
  <c:forEach items="${list}" var="list">
  <tr>
  <td>${list.cid}</td>
  <td>${list.name}</td>
  <td>${list.price}</td>
  <td>${list.points}</td>
  <td>     
 <a href="${pageContext.request.contextPath}/rest/CartController/addCart/${list.cid}">增加到购物车</a> 
 <a href="${pageContext.request.contextPath}/rest/OrderControl/payTest/${list.cid}">购买</a>
  </td> 
 </tr>
  </c:forEach>
 </table>
</body>
</html>