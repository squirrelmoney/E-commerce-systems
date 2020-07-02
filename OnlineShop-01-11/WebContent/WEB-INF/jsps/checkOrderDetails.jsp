<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<c:forEach items="${Orders}" var="Orders">
<tr><td>订单号:${Orders.oid}</td></tr>
<tr>
<c:forEach items="${Orderdetails}" var="Orderdetails" end="${exit2}">
<c:forEach items="${Commodity}" var="Commodity">
<c:if test="${Commodity.cid==Orderdetails.cid}">
<td>商品名:${Commodity.name}</td>
</c:if>
</c:forEach>
<td>收货地址:${Orderdetails.aid}</td>
<c:set var="exit2" value="0"></c:set>
</c:forEach>
<td>运费:${Orders.freight}</td>
<c:if test="${Orders.status==1}">
<td>状态:未发货</td>
<td><button><a style="text-decoration: none" href="${pageContext.request.contextPath}
/rest/delivergoodscontroller/delivergoods/${Orders.oid}">发货</a></button></td>
</c:if>
<c:if test="${Orders.status==2}">
<td>状态:已发货</td>
<td><a  href="${pageContext.request.contextPath}
/rest/delivergoodscontroller/checkdelivergoods/${Orders.oid}"><button>查看</button></a></td>
</c:if>
<c:if test="${Orders.status==3}">
<td>状态:已收货</td>
<td><a  href="${pageContext.request.contextPath}
/rest/delivergoodscontroller/checkdelivergoods/${Orders.oid}">查看</a></td>
</c:if>
<c:if test="${Orders.status==4}">
<td>状态:退款中</td>
<td><a  href="${pageContext.request.contextPath}
/rest/delivergoodscontroller/confirming/${Orders.oid}">确认退款</a></td>
</c:if>
<c:if test="${Orders.status==5}">
<td>状态:已退款</td>
</c:if>
</c:forEach>

</table>
</body>
<style>
a{
text-decoration: none;
color:#333;
text-align: center;
}

</style>
</html>