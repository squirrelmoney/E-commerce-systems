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
<body>
<div class="header-wrap">
	<div class="navwrap">
		<div id="nav">
			<div class="navbar clearfix">
<a  href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">商品</a>
<a class="current" href="${pageContext.request.contextPath}/rest/AdminController/selectProfit">利润表</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/selectAllWarehouse">库存</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/AllOrderDetails">用户订单</a>
<div  class="left">
<a href="${pageContext.request.contextPath}/rest/LoginController/exit">退出登录</a>		
			</div>
			</div>
<table border="1">
<tr>
<td>商品编号</td>
<td>收入</td>
<td>成本</td>
</tr>

  <c:forEach items="${list}" var="list">
  <tr>
  <td>${list.cid}</td>
  <td>${list.income}</td>
  <td>${list.cost}</td>
  <td>    
    <a href="${pageContext.request.contextPath}/rest/ProfitController/deleprofit/${list.cid}">清空</a>
    <a href="${pageContext.request.contextPath}/rest/CommdityController/tolistCommodity">返回</a>
  </td>
 </tr>
  </c:forEach>
 </table>
 </div>
 </div>
 </div>
 
</body>
</html>