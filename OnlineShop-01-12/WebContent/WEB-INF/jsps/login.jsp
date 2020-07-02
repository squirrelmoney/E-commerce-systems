<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="${pageContext.request.contextPath}/css/dlstyle.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Insert title here</title>
			<script type="text/javascript">
			var username=" ";
			function test(){
				var username=document.getElementById("username").value;
				var password=document.getElementById("password").value;
				 var json=JSON.stringify({
					"username":username,
					"password":password,
					"authority":" "
				});
				   $.ajax({
						  type:'POST',/* 请求类型为post */
						  url:'${pageContext.request.contextPath}/rest/LoginController/test',/* 请求路径 */
						  contentType:'application/json;charset=UTF-8',/* 向服务器提出的请求类型 */
						  dataType: 'json',
						  data:json,/* 请求的数据 */
						  async:false,
							 success: function(data){/* 回调函数 */
								if(data['password']==password){
								//	temp=data['username'];
								//	alert(temp)
								//	a=1;
								document.form1.attributes["action"].value = 
									"${pageContext.request.contextPath}/rest/LoginController/selectUser";
								}
							 username=data['username'];
				            }
							}); 
				   
				   return username;   
			}
			
			
				
				   
				  
			function fails(){
				username=test();
				if(username==" "){
					   alert("账户不存在")
				   }
				else if(document.form1.attributes["action"].value==" "){
					   alert("密码错误")
				   }
				
			}
			
			</script>
			
	</head>

	<body>

		<div class="login-boxtitle">
			<a href="${pageContext.request.contextPath}/rest/mainHomeController/homepage"><img alt="logo" src="${pageContext.request.contextPath}/images/logobig.png" /></a>
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath}/images/big.jpg" /></div>
				<div class="login-box" >

							<h3 class="title" style="margin-top: 30px;">登录商城</h3>

							<div class="clear"></div>
						
						<div class="login-form" style="margin-top: 50px;">
						  <form name="form1" method="post" action=" ">
							   <div class="user-name">
								    <label for="user"><i class="am-icon-user"></i></label>
								    <input type="text" onchange="" id="username" name="username" name="username" placeholder="请输入你的用户名"/>
                 </div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="text" name="password" id="password" placeholder="请输入你的密码"/>
                 </div>
                 <div class="am-cf">
									<input type="submit"  id="submit"  name="submit" value="登 录" class="am-btn am-btn-primary am-btn-sm" onclick="fails()">
								</div>
                  </form>
            
           </div>
            
            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
								<a href="#" class="am-fr">忘记密码</a>
								<a href="${pageContext.request.contextPath}/rest/RegisterController/Register" class="zcnext am-fr am-btn-default">注册</a>
								<br />
            </div>
								


				</div>
			</div>
		</div>

					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="${pageContext.request.contextPath}/rest/mainHomeController/homepage ">岭南师范超市</a>
								<b>|</b>
								<a href="${pageContext.request.contextPath}/rest/mainHomeController/homepage">商城首页</a>
								<b>|</b>
							</p>
						</div>
						
					</div>
	</body>

</html>