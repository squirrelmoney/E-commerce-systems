<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
<style type="text/css">
table{  
       width:100%;
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
</style>
</head>
<body>
<script type="text/javascript">
	function allcheck() 
	{
		var oCheck=document.getElementsByName('check');//取到所有的check
		for(var i=0;i<oCheck.length;i++)
			oCheck[i].checked=true;	
		$('#totalprice').html('0')//获取span的值
		$('#sel').html('0')
		for(var i=0;i<$('.check').length;i++){
			if($('.check').eq(i).prop("checked")){
				//parent()获取上一级，siblings()同级，eq(7)
				var val=$('.check').eq(i).parent().siblings().eq(7).children('input').val()
				val=parseInt(val)+parseInt($('#totalprice').html())
				var c=parseInt(1)+parseInt($('#sel').html())
				$('#totalprice').html(val)
				$('#sel').html(c)
			}
		}
	}
	
	function nocheck() 
	{
		var oCheck=document.getElementsByName('check');//取到所有的check
		for(var i=0;i<oCheck.length;i++)
			oCheck[i].checked=false;	
		$('#totalprice').html('0')//获取span的值
		$('#sel').html('0')
		for(var i=0;i<$('.check').length;i++){
			if($('.check').eq(i).prop("checked")){
				//parent()获取上一级，siblings()同级，eq(7)
				var val=$('.check').eq(i).parent().siblings().eq(7).children('input').val()
				val=parseInt(val)+parseInt($('#totalprice').html())
				var c=parseInt(1)+parseInt($('#sel').html())
				$('#totalprice').html(val)
				$('#sel').html(c)
			}
		}
	}
	
 	function reduce(a)
	{
		var num=$(a).parent().siblings().eq(5).children('input').val();
		var cid=$(a).parent().siblings().eq(2).html();
		var price=$(a).parent().siblings().eq(4).html();	
		var money=$(a).parent().siblings().eq(7).children('input').val();	
		
 		var json=JSON.stringify({"cid":cid,"sum":parseInt(num),"price":parseInt(price),"money":parseInt(money)});
 		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/CartController/reduce.do',
			contentType:'application/json;charset=UTF-8',
			dataType:'json',
			data:json,					
			success:function(data)
			{
				var b=eval(data)
				console.log(b);
				if(b.sum>0)
				{
					$(a).parent().siblings().eq(5).children('input').val(b.sum);
					$(a).parent().siblings().eq(7).children('input').val(b.money);
					
	 				$('#totalprice').html('0')				
					for(var i=0;i<$('.check').length;i++){					
						if($('.check').eq(i).prop("checked")){					
							var val=$('.check').eq(i).parent().siblings().eq(7).children('input').val();
							console.log(val);
							val=parseInt(val)+parseInt($('#totalprice').html());						
							$('#totalprice').html(val)
						}
					} 					
				}

			}
		}); 
		//$("#sum"+i).val(parseInt(num)+parseInt(1))
 	} 
	
	function add(a)
	{
		var num=$(a).parent().siblings().eq(6).children('input').val();
		var cid=$(a).parent().siblings().eq(2).html();
		var price=$(a).parent().siblings().eq(4).html();	
		var money=$(a).parent().siblings().eq(7).children('input').val();	
		
 		var json=JSON.stringify({"cid":cid,"sum":parseInt(num),"price":parseInt(price),"money":parseInt(money)});
 		$.ajax({
			type:'POST',	/*请求方式为post*/		
			url:'${pageContext.request.contextPath}/CartController/add.do',	/*请求路径*/	
			contentType:'application/json;charset=UTF-8',	/*向服务器提出请求的类型*/	
			dataType:'json',	/*返回类型*/	
			data:json,	/*请求数据*/
			/* 数据已经到服务器 */						
			success:function(data)/* 回调函数，查看前端是什么数据 */
			{
				var b=eval(data)
				console.log(b);
				$(a).parent().siblings().eq(6).children('input').val(b.sum);
				$(a).parent().siblings().eq(7).children('input').val(b.money);			
				
 				$('#totalprice').html('0')		
 				$('')
				for(var i=0;i<$('.check').length;i++){					
					if($('.check').eq(i).prop("checked")){						
						var val=$('.check').eq(i).parent().siblings().eq(7).children('input').val();
						console.log(val);
						val=parseInt(val)+parseInt($('#totalprice').html());					
						$('#totalprice').html(val)
					}
				} 
			}
		}); 
		//$("#sum"+i).val(parseInt(num)+parseInt(1))
	}
	
	function test(a)
	{
		$('#totalprice').html('0')//获取span的值
		$('#sel').html('0')
		for(var i=0;i<$('.check').length;i++){
			if($('.check').eq(i).prop("checked")){
				//parent()获取上一级，siblings()同级，eq(7)
				var val=$('.check').eq(i).parent().siblings().eq(7).children('input').val()
				val=parseInt(val)+parseInt($('#totalprice').html())
				var c=parseInt(1)+parseInt($('#sel').html())
				$('#totalprice').html(val)
				$('#sel').html(c)
			}
		}
	}
	
 	function compute()
	{
		var str=[]
		for(var i=0;i<$('.check').length;i++)
		{			
			if($('.check').eq(i).prop("checked"))
			{				
				var cid=$('.check').eq(i).parent().siblings().eq(1).html();
				var num=$('.check').eq(i).parent().siblings().eq(5).children('input').val();
				var money=$('.check').eq(i).parent().siblings().eq(7).children('input').val();
				str.push({"cid":parseInt(cid),"num":parseInt(num),"money":parseInt(money)})		
				/* 数组可以放Json对象 */
			}
		}	

			var json=JSON.stringify(str);
			/* JSON.stringify(str)---将数组对象转化为Json字符串 
			JSON.parse()---将Json字符串 转换为对象
			$.parseJSON()---将Json字符串 转换为对象*/
			$.ajax({
				type:'POST',	
				url:'${pageContext.request.contextPath}/MyOrderController/insertOrder.do',
				contentType:'application/json;charset=UTF-8',
				dataType:'json',
				data:json,					
				success:function(data)
				{
					if(data!=null){
						location.href="${pageContext.request.contextPath}/OrderdetailsController/receive.do?oid="+data.oid;
					}
					else{
						alert("没有选择商品")
					}
				}
			}); 
	} 
</script>
<form action="${pageContext.request.contextPath}/rest/mainHomeController/homepage">
	<input type="submit" value="商城">
</form>
<table border="1" id="table1" class="ta">
	<tr>
		<td></td>
		<td>账号</td>
		<td>商品编号</td>
		<td>商品名称</td>
		<td>价格</td>
		<td></td>
		<td>数量</td>	
		<td></td>	
		<td>金额</td>
		<td>操作</td>			
	</tr>
	<c:forEach items="${list}" var="list" varStatus="status">
	<tr>
		<td>
			<input type="checkbox" name="check" class="check" value="${list.cid}" onclick="test(this)">	
		</td>
		<td>${list.username}</td>
		<td>${list.cid}</td>
		<td>${list.name}</td>
		<td>${list.price}</td>
		<td>
			<input type="button" value="-" onclick="reduce(this)">
		</td>
		<td>
			<input id="sum${status.index}" type="text" value="${list.sum}" readonly="readonly">
		</td>
		<td>
			<input type="button" value="+" onclick="add(this)">
		</td>		
		<td>
		<input type="text" id="money${status.index}" value="${list.money}" readonly="readonly">		
		</td>
		<td>
			<a href="${pageContext.request.contextPath}/CartController/deleteMycart.do?cid=${list.cid}">删除</a>
		</td>					
	</tr>
	</c:forEach>
</table>
<br>
<div>
	<input type="button" value="全选" onclick="allcheck()">
	<input type="button" value="取消" onclick="nocheck()">
</div>
<br>
<div style="float: right;">
	已选商品    <span id="sel">0</span>件
	合计:<span style="color:red">￥</span><span id="totalprice"  style="color:red">0</span>
	<input value="结算" type="button" onclick="compute()" style="background:red;border:none;width:80px;height:40px;color:#fff;">		
</div>
</body>
</html>