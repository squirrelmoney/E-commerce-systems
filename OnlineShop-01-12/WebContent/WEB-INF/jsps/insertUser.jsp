
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css1/login.css">
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="${pageContext.request.contextPath }/text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
<link href="${pageContext.request.contextPath }/register/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/register/css/gloab.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/register/css/index.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/register/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/register/js/register.js"></script>



<script type="text/javascript">
	function checkname()
	{
		var username=document.getElementById("username").value;
		if(username=="")
			alert("账户不能为空!");
 		$.ajax({
			type:'POST',	/*请求方式为post*/		
			url:'${pageContext.request.contextPath}/rest/UserController/checkusername',	/*请求路径*/
			dataType:'text',
			data:{
				username : username
			},			
			/* 传过的数据可以是文本或者是json，后台把数据传回来必须是json字符串,并转换为json对象，通过key取得值 */
			success:function(data)/* 回调函数，查看前端是什么数据 */
			{
				var jsonObj = $.parseJSON(data);
				if(jsonObj.flag==0)
					{
						alert("该账户已注册");
					}
			}
		}); 		
	}
</script>


<body class="bgf4">
<form action="${pageContext.request.contextPath}/rest/RegisterController/saveUser" method="post">
<div class="login-box f-mt10 f-pb50">
	<div class="main bgf">    
    	<div class="reg-box-pan display-inline">  
        	<div class="step">        	
                <ul>
                    <li class="col-xs-4 on">
                        <span class="num"><em class="f-r5">
                        </em><a href="${pageContext.request.contextPath}/rest/LoginController/Loginuser"><i style="font-size: 10px;">back</i></a></span>                	
                        
                        <p class="lbg-txt">填写账户信息</p>
                    </li>
                    
                       
                </ul>
            </div>
        	<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
            	<div class="part1">                	
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" id="username" name="username" onblur="checkname()"  maxlength="20" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:3-20||isUname" data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                            <span class="ie8 icon-close close hide"></span>
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                   
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>    
                        <div class="f-fl item-ifo">
                            <input type="password" name="password" id="password" maxlength="20" class="txt03 f-r3 required" tabindex="3" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" /> 
                            <span class="ie8 icon-close close hide" style="right:55px"></span>
                            <span class="showpwd" data-eye="password"></span>                        
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
                            <label class="focus valid"></label>
                            <span class="clearfix"></span>
                            <label class="strength">
                            	<span class="f-fl f-size12">安全程度：</span>
                            	<b><i>弱</i><i>中</i><i>强</i></b>
                            </label>    
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="4" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:password" data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword" />
                            <span class="ie8 icon-close close hide" style="right:55px"></span>
                            <span class="showpwd" data-eye="rePassword"></span>
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请再输入一遍上面的密码</label> 
                            <label class="focus valid"></label>                          
                        </div>
                    </div>
                        <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" id="phone" name="phone"   maxlength="11" class="txt03 f-r3 required" tabindex="1" 
                             id="adminNo" /> 
                        </div>
                    </div>
                   	 <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>姓名：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" id="name" name="name"   maxlength="11" class="txt03 f-r3 required" tabindex="1" 
                            id="adminNo" /> 
                        </div>
                    <div class="item col-xs-12" style="height:auto">
                        <span class="intelligent-label f-fl">&nbsp;</span>  
                        <p class="f-size14 required"  data-valid="isChecked" data-error="请先同意条款"> 
                        	<input type="checkbox" checked /><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
                        </p>                       
                        <label class="focus valid"></label> 
                    </div> 
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl">&nbsp;</span>    
                      
                        <input type="hidden" name="authority" value=1>
                        <input type="hidden" name="points" value=0>
                        <div class="f-fl item-ifo">
					<input  class="btn btn-blue f-r3" id="btn_part1" class="submit" type="submit" name="submit" class="btn btn-blue f-r3" id="btn_part1" value="注册" >
				</div>
				
		</form>
                    </div> 
                </div>

<div class="m-sPopBg" style="z-index:998;"></div>
<div class="m-sPopCon regcon">
	<div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
    <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
    </div>
    <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
</div>
<script>
$(function(){	
	//第一页的确定按钮
	$("#btn_part1").click(function(){						
		if(!verifyCheck._click()) return;
		$(".part1").hide();
		$(".part3").show();
		$(".step li").eq(1).addClass("on");
	});

function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
function closeClause(){
	$(".m-sPopBg,.m-sPopCon").hide();		
}
</script>
<div style="text-align:center;">

</div>
</body>
</html>
