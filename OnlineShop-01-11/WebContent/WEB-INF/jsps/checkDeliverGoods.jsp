<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="fun()">
<h4>已为你分配好最近仓库</h4>
<form action="${pageContext.request.contextPath}/rest/delivergoodscontroller/delivering" method="post" id="showDataForm">
<table border="1">
<tr>
<td>订单号</td>
<td>商品号</td>
<td>商品名</td>
<td>数量</td>
<td >仓库</td>
<td>发货地址</td>
<td>收货地址</td>
</tr>
<c:set var="i" value="0"></c:set>
<c:set var="a" value="1"></c:set>
<c:set var="Commoditylist" value="${Commoditylist}"></c:set>
<c:set var="Warehouselist" value="${Warehouselist}"></c:set>
<c:forEach items="${Orderdetails}" var="Orderdetails" >
<tr>
<td><input readonly="readonly" name="OrderdetailsList[${i}].oid" value="${oid}" type="text"></td>

<td><input readonly="readonly" name="OrderdetailsList[${i}].cid" value="${Orderdetails.cid}" type="text"></td>

<td><input readonly="readonly"  value="${Commoditylist[i].name}" type="text"></td>

<td><input readonly="readonly"  value="${Orderdetails.number}" type="text"></td>

<td><input readonly="readonly"  value="${Orderdetails.wid}" type="text"></td>

<td><input readonly="readonly"  value="${Warehouselist[i].address}" type="text"></td>

<c:forEach items="${Address}" var="Address"> 
<c:if test="${Address.aid==Orderdetails.aid}">
<td><input readonly="readonly" value="${Address.address}" type="text"></td>
</c:if>
</c:forEach>
</tr>
<c:set var="i" value="${i+a}"></c:set>
</c:forEach>
</table>
<button type="submit" ><a href="${pageContext.request.contextPath}
/rest/delivergoodscontroller/CheckOrderDetails">返回</a></button>
</form>
</body>
</html>
