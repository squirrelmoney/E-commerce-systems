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
<h4>已为你分配好最近仓库</h4>
<form action="" method="post" id="showDataForm" class="form">
<table border="1">
<tr>
<td>订单号</td>
<td>商品号</td>
<td>数量</td>
<td id="choosing">可选发货仓库</td>
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
<c:set var="cids" value="${cids}+','+${Orderdetails.cid}"></c:set>
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
</form>
</body>
</html>
