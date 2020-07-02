<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />		
<link href="${pageContext.request.contextPath}/css/sortstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/caidan/css/style.css">
<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
 <style>  
       table {  
       width:1000px;
            padding: 0 ;  
            margin: 100 auto;  
            border-collapse: collapse;  
        }  
        td{ 
            /* background:pink; */
            border: 1px solid #ddd;  
            padding: 6px 6px 6px 12px;  
            color: #4f6b72;  
            text-align: center;  
            width:50px;
        }  
        th {  
            background: #d3d3d3;  
              
        }   
        
         .div2{
        margin-bottom: 100px;
        }
        table{
        margin-top: 30px;
        }
  </style> 
</head>
<body>
<div class="header-wrap">
	<div class="navwrap">
		<div id="nav">
			<div class="navbar clearfix">
<a  href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">商品</a>
<a  href="${pageContext.request.contextPath}/rest/AdminController/selectProfit">利润表</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/selectAllWarehouse">库存</a>
<a class="current" href="${pageContext.request.contextPath}/rest/AdminController/AllOrderDetails">用户订单</a>
<a href="${pageContext.request.contextPath}/rest/LoginController/exit">退出登录</a>		
			</div>
<table border="1">

<c:forEach items="${Orders}" var="Orders">
<tr>
<td>订单号:${Orders.oid}</td>
<td>用户名:${Orders.username}</td>
</tr>

<c:forEach items="${Orderdetails}" var="Orderdetails" end="${exit2}">
<tr>
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