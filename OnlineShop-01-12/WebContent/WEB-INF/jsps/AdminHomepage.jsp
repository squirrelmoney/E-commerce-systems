<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Homepage</title>
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
  </style> 
</head>
<body>
<div class="header-wrap">
	<div class="navwrap">
		<div id="nav">
			<div class="navbar clearfix">
<a class="current" href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">商品</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/selectProfit">利润表</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/selectAllWarehouse">库存</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/AllOrderDetails">用户订单</a>
<a href="${pageContext.request.contextPath}/rest/LoginController/exit">退出登录</a>		
			</div>
<table border="1">
	<tr>
		<td>cid</td>
		<td>name</td>
		<td>picture</td>
		<td>price</td>
		<td>points</td>
		<td>cost</td>	
		<td></td>
		<td></td>				
	</tr>
	<c:forEach items="${list}" var="list">
		<tr>
		<td>${list.cid}</td>
		<td>${list.name}</td>
		<td>
			<img id='imgSize1ImgSrc' src='${picPath}${list.picture}'  height="100" width="200" />
		</td>
		<td>${list.price}</td>
		<td>${list.points}</td>
		<td>${list.cost}</td>		
		<td>
		 <a href="${pageContext.request.contextPath}/rest/AdminController/deleteCommodity/${list.cid}">删除</a>
		 </td>
		<td>
			<a href="${pageContext.request.contextPath}/CommodityController/insertCommodity.do">添加</a>
		</td>	
		<td>
			<a href="${pageContext.request.contextPath}/CommodityController/updateCommodity.do?cid=${list.cid}">修改</a>
		</td>	

		</tr>
	</c:forEach>
</table>
</div>
</div>
</div>

</body>
</html>