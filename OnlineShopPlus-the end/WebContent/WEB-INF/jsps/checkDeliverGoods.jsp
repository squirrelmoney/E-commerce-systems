<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
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
            color: black;
            border-top: 1px solid #000000;
            border-left: 1px solid #000000;
            border-collapse: collapse; /*设置单元格的边框合并为1*/
        }  
        
        td{ 
            /* background:pink; */
            border: 1px solid #ddd;  
            padding: 6px 6px 6px 12px;  
            color: #333;  
            text-align: center;  
            width:50px;
        }  
        th {  
            background: #333;  
              
        }   
          .div2{
        margin-bottom: 100px;
        }
        table{
        margin-top: 30px;
        }
  </style> 
</head>
<body onload="fun()">
<div class="header-wrap">
	<div class="navwrap">
		<div id="nav">
			<div class="navbar clearfix">
<a  href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">商品</a>
<a  href="${pageContext.request.contextPath}/rest/AdminController/selectProfit">利润表</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/selectAllWarehouse">库存</a>
<a class="current" href="${pageContext.request.contextPath}/rest/AdminController/AllOrderDetails">用户订单详情</a>
<div  class="left">
<a href="${pageContext.request.contextPath}/rest/LoginController/exit">退出登录</a>		
			</div>
			</div>
<form action="${pageContext.request.contextPath}/rest/delivergoodscontroller/delivering" method="post" id="showDataForm">
<table border="2px">
<c:set var="userdetails" value="${userdetails}"></c:set>
<tr>
<td>用户名:</td><td>${userdetails.username}</td>
<td>姓名:</td><td>${userdetails.name}</td>
<td>电话:</td><td>${userdetails.phone}</td>
<td><button><a href="${pageContext.request.contextPath}/rest/AdminController/AllOrderDetails">返回</a></button></td>
</tr>
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
<td>${oid}</td>

<td>${Orderdetails.cid}</td>

<td>${Commoditylist[i].name}</td>

<td>${Orderdetails.number}</td>

<td>${Orderdetails.wid}</td>

<td>${Warehouselist[i].address}</td>

<c:forEach items="${Address}" var="Address"> 
<c:if test="${Address.aid==Orderdetails.aid}">
<td>${Address.address}</td>
</c:if>
</c:forEach>
</tr>
<c:set var="i" value="${i+a}"></c:set>
</c:forEach>
</table>
</form>
</div>
</div>
</div>
</body>
</html>
