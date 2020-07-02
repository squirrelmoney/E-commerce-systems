<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            color:black;  
            text-align: center;  
            width:50px;
        }  
        th {  
            background: black;  
              
        }   
          .div2{
        margin-bottom: 100px;
        }
        table{
        margin-top: 30px;
        }
        a{
        text-decoration: none;
        color:#fff;
        }
        button{		
        	width: 200px;/*设置按钮宽度*/	
        			height: 30px;/*设置按钮高度*/
        			color:white;/*字体颜色*/
					background-color:rgb(191,42,42);/*按钮背景颜色*/		
					border-radius: 3px;/*让按钮变得圆滑一点*/			
					border-width: 0;/*消去按钮丑的边框*/			
					margin-left:300px;	
					margin-top:30px;	
					outline: none;/*取消轮廓*/		
					font-family: KaiTi;/*字体设置为楷体*/			
					font-size: 15px;/*设置字体大小*/			
					text-align: center;/*字体居中*/			
					cursor: pointer;/*设置鼠标箭头手势*/		}		
					button:hover{/*鼠标移动时的颜色变化*/			
					color:#333;		}
        											
        											

  </style> 
<script type="text/javascript">
	var arr=[];
	var cids=[];
	var oid=${oid};
	var aid;
	var wid;
	var cid;
	var warehouse;
	var distance;
	var json =JSON.stringify({
		"oid":oid,
	    "aid":" ",
		"wid":" ",
	    "cid":" ",
	    "warehouse":" ",
	    "distance":" "}
	    ) ; 
		var jsonArray=[];
		function page(){
	   $.ajax({
			  type:'POST',/* 请求类型为post */
			  url:'${pageContext.request.contextPath}/rest/warehousecontroller/apportion',
			  contentType:'application/json;charset=UTF-8',
			  dataType: 'json',
			  data:json,
			  async:false,
			  success: function(data){
				 for(var i = 0; i < data.length; i++){       
					 oid = data[i]['oid'];
					 aid = data[i]['aid'];
					 wid = data[i]['wid'];
					 cid = data[i]['cid'];
					 warehouse = data[i]['warehouse'];
					 distance = data[i]['distance'];
					 //改变选框默认值
					 $("#Warehouse_wid"+cid+"  option[text="+wid+"]").attr("selected", "selected");
					 
					 $("#choosing"+cid).after("<td id=w"+cid+">warehouse:</td>");
					 $("#w"+cid).after("<td id=distance"+cid+">distance:</td>");
					 $("#warehouse"+cid).after("<td id=distance"+cid+"><input readonly='readonly' value="+warehouse+"></td>");
					 $("#distance"+cid).after("<td id=del"+cid+"><input readonly='readonly' value="+distance+"></td>");
					 arr[i]=cid;
				 }
}
});
	   return arr;
		}
		

	
	function fun(){
		page();
		for (var i = 0; i <arr.length; i++) {
			        $("#Warehouse_wid"+arr[i]).change(function() {
			        	var ss = $(this).children('option:selected').val();
			        	SelectChange(ss);
			        	
			        }); 
		}
		
	}
    function SelectChange(cid) {
    var wid = $("#Warehouse_wid"+cid).find("option:selected").text();
   
    var json =JSON.stringify({
		"oid":${oid},
	    "aid":" ",
		"wid":wid,
	    "cid":cid,
	    "warehouse":" ",
	    "distance":" "}
	    ) ; 
	    $.ajax({
				  type:'POST',/* 请求类型为post */
				  url:'${pageContext.request.contextPath}/rest/warehousecontroller/apportionBySelected',
				  contentType:'application/json;charset=UTF-8',
				  dataType: 'json',
				  data:json,
				  success: function(data){   
						 oid = data['oid'];
					     aid = data['aid'];
						 wid = data['wid'];
						 cid = data['cid'];
						 warehouse = data['warehouse'];
						 distance = data['distance'];
						 //改变选框默认值
						 $("#del"+cid).remove();
						 $("#distance"+cid).remove();
						  $("#w"+cid).remove();
							 
						 $("#choosing"+cid).after("<td id=w"+cid+">warehouse:</td>");
						 $("#w"+cid).after("<td id=distance"+cid+">distance:</td>");
						 $("#warehouse"+cid).after("<td id=distance"+cid+"><input readonly='readonly' value="+warehouse+"></td>");
						 $("#distance"+cid).after("<td id=del"+cid+"><input readonly='readonly' value="+distance+"></td>");
						 
					 
	}
	});
	 
} 
/*     var formData = new FormData($("form")[0]);
    $.ajax({ 
        url: "${pageContext.request.contextPath}/rest/delivergoodscontroller/delivering",
        type: 'POST', 
        data: formData, 
        contentType: false, 
        processData: false, 
        success: function (returndata) { 
            console.log(returndata); 
        }, 
        error: function (returndata) { 
            console.log(returndata); 
        } 
    });
 */

function change(i){
	var form = document.getElementById('showDataForm');
	form.action="${pageContext.request.contextPath}/rest/delivergoodscontroller/delivering" 
	 for (var a = 0; a < i; a++) {
		 var wid = $("select[name='OrderdetailsList["+a+"].wid']").find("option:selected").text();
		  var cid=$("select[name='OrderdetailsList["+a+"].wid']").val();
		$("#Warehouse_wid"+cid+"  option[text="+wid+"]").attr("value", wid);
	}
	//设置处理程序
	 form.submit();//提交表单  
 }
 
</script>
</head>
<body onload="fun()">
<div class="header-wrap">
	<div class="navwrap">
		<div id="nav">
			<div class="navbar clearfix">
<a  href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">商品</a>
<a  href="${pageContext.request.contextPath}/rest/AdminController/selectProfit">利润表</a>
<a href="${pageContext.request.contextPath}/rest/AdminController/selectAllWarehouse">库存</a>
<a class="current" href="${pageContext.request.contextPath}/rest/AdminController/AllOrderDetails">发货</a>
<div  class="left">
<a href="${pageContext.request.contextPath}/rest/LoginController/exit">退出登录</a>		
			</div>
			</div>
			</div>
<h4>已为你分配好最近仓库</h4>

<form action="" method="post" id="showDataForm" class="form">
<table border="1">
<c:set var="userdetails" value="${userdetails}"></c:set>
<tr>
<td>用户名:</td><td>${userdetails.username}</td>
<td>姓名:</td><td>${userdetails.name}</td>
<td>电话:</td><td>${userdetails.phone}</td>
<td></td>
</tr>
<tr>
<td>订单号</td>
<td>商品号</td>
<td>数量</td>
<td id="choosing">仓库</td>
<td>发货地址</td>
<td>距离</td>
<td>收货地址</td>
</tr>
<c:set var="i" value="0"></c:set>
<c:set var="a" value="1"></c:set>
<c:set var="cids" value=""></c:set>
<c:forEach items="${Orderdetails}" var="Orderdetails" >
<tr>

<td><input readonly="readonly" name="OrderdetailsList[${i}].oid" value="${oid}" type="text"></td>

<td><input readonly="readonly" name="OrderdetailsList[${i}].cid" value="${Orderdetails.cid}" type="text"></td>
<td><input readonly="readonly" name="OrderdetailsList[${i}].number" value="${Orderdetails.number}" type="text"></td>
<td  id="warehouse${Orderdetails.cid}">
<select id="Warehouse_wid${Orderdetails.cid}" class="Warehouse_wid${i}" name="OrderdetailsList[${i}].wid">
<c:forEach items="${Warehouse}" var="Warehouse">
<c:if test="${Warehouse.cid==Orderdetails.cid}">
<option value="${Warehouse.cid}" selected="selected" >
${Warehouse.wid}
</option>
</c:if>
</c:forEach>

</select>

</td>
<c:forEach items="${Address}" var="Address"> 
<c:if test="${Address.aid==Orderdetails.aid}">
<input type="hidden" name="OrderdetailsList[${i}].aid" value="${Address.aid}">
<td><input  value="${Address.address}" type="text"></td>
</c:if>
</c:forEach>
</tr>
<c:set var="i" value="${i+a}"></c:set>
</c:forEach>
</table>
<button type="button" onclick="change(${i})"  class="button">确定发货</button>
<button type="submit" ><a href="${pageContext.request.contextPath}
/rest/AdminController/AllOrderDetails">返回</a></button>
</form>
</div>
</div>
</body>
</html>
