<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/rest/CustomerController/updateUserdetailsById" method="post">
<table border="1">
<tr>
<td>账号</td>
<td>名字</td>
<td>电话</td>
<td>积分</td>
<td><a href="${pageContext.request.contextPath}/rest/mainHomeController/homepage">返回</a></td>
</tr>
<c:set value="${user}" var="user"/>
<c:set value="${Userdetails}" var="Userdetails"/>
<tr>
<td><input name="username" readonly="readonly" value="${Userdetails.username}"></td>
<td><input name="name" value="${Userdetails.name}"></td>
<td><input name="phone" value="${Userdetails.phone}"></td>
<td><input name="points" readonly="readonly" value="${Userdetails.points}"></td>
<td>
<input value="修改信息" type="submit">

</td>
</tr>
</table>
</form>
</body>
</html> --%>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>个人资料</title>

<link href="${pageContext.request.contextPath}/main/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/main/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

<link href="${pageContext.request.contextPath}/main/css/personal.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/main/css/infstyle.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/main/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/main/AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<title>Insert title here</title>

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
<body onload="appendTable(jsonArray)">  
                <div class="topMessage home">
			<div class="menu-hd"><a href="${pageContext.request.contextPath}/rest/mainHomeController/homepage" target="_top" class="h">商城首页</a></div>
		</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-info">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
						</div>
						<hr/>
                         <c:set value="${user}" var="user"/>
                         <c:set value="${Userdetails}" var="Userdetails"/>
						<!--头像 -->
						<div class="user-infoPic">

							<div class="filePic">
								<input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">
								<img class="am-circle am-img-thumbnail" src="${pageContext.request.contextPath}/images/getAvatar.do.jpg" alt="" />
							</div>

							<p class="am-form-help">头像</p>
                            
							<div class="info-m">
								<div><b>用户名：<i>${Userdetails.username}</i></b></div>
								<div class="u-level">
									<span class="rank r2">
							             <s class="vip1"></s><a class="classes" href="#">铜牌会员</a>
						            </span>
								</div>
								<div class="u-safety">
									<a href="safety.html">
									 积分
									<span class="u-profile"><i class="bc_ee0000" style="width: 60px;" width="0">${Userdetails.points}</i></span>
									</a>
								</div>
							</div>
						</div>

						<!--个人信息 -->
						<div class="info-main">
							<form class="am-form am-form-horizontal" action="${pageContext.request.contextPath}/rest/CustomerController/updateUserdetailsById">

								<div class="am-form-group">
									<label for="user-name2" class="am-form-label">昵称</label>
									<div class="am-form-content">
										<input type="text" readonly="readonly" id="user-name2" name="username" value="${Userdetails.username}" placeholder="nickname">

									</div>
								</div>

								<div class="am-form-group">
									<label for="user-name" class="am-form-label">姓名</label>
									<div class="am-form-content">
										<input type="text" id="user-name2" name="name" value="${Userdetails.name}" placeholder="name">

									</div>
								</div>


								<div class="am-form-group">
									<label for="user-phone" class="am-form-label">电话</label>
									<div class="am-form-content">
										<input id="user-phone" placeholder="telephonenumber" name="phone" 
										value="${Userdetails.phone}" type="tel">

									</div>
								</div>
								
								
								<div class="info-btn">
									<button type="submit" class="am-btn am-btn-danger">保存修改</button>
								</div>

							</form>
						</div>

					</div>

				</div>
			

    
    				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">岭南超市</a>
							<b>|</b>
							<a href="${pageContext.request.contextPath}/rest/mainHomeController/homepage">商城首页</a>
							<b>|</b>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							
						</p>
					</div>
				</div>
			</div>
			<aside class="menu">
				<ul>
					<li class="person">
						<a href="#">个人中心</a>
					</li>
					<li class="person">
						<ul>
							<li class="active"> <a href="${pageContext.request.contextPath}/rest/CustomerController/Customerdetails">个人信息</a></li>
						
							<li > <a href="${pageContext.request.contextPath}/rest/addressescontroller/customerAddress">收货地址</a></li>
							
						</ul>
					</li>

				</ul>
               <li class="person">
						<a href="#">我的交易</a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/rest/CustomerController/selectCustomerorders">订单管理</a></li>
						 
						</ul>
					</li>
			</aside>
</body>  
</html>   
