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
  <%@ page language="java" import="com.mapper.pojo.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function () {
    if(location.href.indexOf("#reloaded")==-1){
       location.href=location.href+"#reloaded";
       location.reload();
   }
})
setTimeout(function(){ window.location.reload();}, 1000000);
var username = '<%=session.getAttribute("username")%>';
var json =JSON.stringify({
	    "aid":" ",
		"username":username,
	    "address":" ",
	    "phone":" ",
	    "name":" ",
	    "defaultadress":" "}
	    ) ; 
		var jsonArray=[];
		var aid;
		var username ;
		var address;
		var phone ;
		var name;
		var defaultadress;
     
	   $.ajax({
			  type:'POST',/* 请求类型为post */
			  url:'${pageContext.request.contextPath}/rest/addressescontroller/selectuserAddresses',/* 请求路径 */
			  contentType:'application/json;charset=UTF-8',/* 向服务器提出的请求类型 */
			  dataType: 'json',
			  data:json,/* 请求的数据 */
			  success: function(data){/* 回调函数 */
				 for(var i = 0; i < data.length; i++){       
		          aid = data[i]['aid'];
		          username = data[i]['username'];
		          address = data[i]['address'];
		          phone = data[i]['phone'];
		          name = data[i]['name'];
		          defaultadress = data[i]['defaultadress'];
		          jsonArray[i]={aid:aid,username:username,address:address,phone:phone,name:name,defaultadress:defaultadress};
	          } 
 
			  }
		  });

   	 var headArray = [];  
     function parseHead(oneRow) {  
                   for ( var i in oneRow) //foreach,遍历一行数据中属性的多少
                   {  
                           headArray[headArray.length] = i;  //列的属性存入headArray【】
                         
                    }  
       }  
  function appendTable() {  
    parseHead(jsonArray[0]);//调用函数，获取列数与对应名字
    $("#table1").prepend("<tr id='tr1'></tr>")
    for ( var count = 0; count <=headArray.length+2; count++)
    {         
    	     if(count <headArray.length)
    		 	$("#tr1").append("<td id='td1'>"+headArray[count]+"</td>");
    	     if(count ==headArray.length)
    	    	 $("#tr1").append("<td>删除</td>"); 
    	     if(count ==headArray.length+1)
    	    	 $("#tr1").append("<td >修改</td>");
    	    	 
     }  
   
    for ( var tableRowNo = 0; tableRowNo <jsonArray.length; tableRowNo++) {  
    	 $("#tr1").after("<tr name='"+tableRowNo+"' class='"+tableRowNo+"' id='tr2'></tr>")
              for ( var headCount = 0; headCount <=headArray.length+1; headCount++) {    
            	      if(headArray[headCount]=="id"){
            	    	  $("#tr2").append("<td id='"+headCount+"'></td>")
                     	   $("#"+headCount+"").append
                     	   ("<input id='"+headArray[headCount]+"'readonly='readonly' class='easyui-numberbox' name='"+headArray[headCount]+"'  type='text'  value='"+jsonArray[tableRowNo][headArray[headCount]]+"'>");
            	      }
            	      else if(headCount<headArray.length){
                    	  $("#tr2").append("<td id='"+headCount+"'></td>")
                  	   $("#"+headCount+"").append
                  	   ("<input id='"+headArray[headCount]+"' class='easyui-numberbox' name='"+headArray[headCount]+"'  type='text'  value='"+jsonArray[tableRowNo][headArray[headCount]]+"'>");
                   	  
                      }
            	      else if(headCount==headArray.length){
                    	  $("#tr2").append("<td id='td3'>")
                     $("#td3").append
                     ("<a href='#' id='a1' onclick='deletejson("+jsonArray[tableRowNo][headArray[0]]+")'><button>X</button></a>");
                      }
                     
                      if(headCount==headArray.length){
                    	  $("#tr2").append("<td id='td4'>")
                     $("#td4").append
                     ("<a href='#' onclick='updatejson("+tableRowNo+")'><button>修改</button></a>");
                    
                        }
                    	
                    
              }  
                    }
      
         $(".0").after("<tr  id='tr_td' name='tr_name'></tr>")
	    for ( var headCount = 0; headCount <headArray.length; headCount++) {
	    	if(headArray[headCount]=="id"){
	    	$("#tr_td").append("<td  id='td_input"+headCount+"' ></td>")
	    $("#td_input"+headCount+"").append
		("<input  value='id' readonly='readonly' name='"+headArray[headCount]+"'  type='text'>");
	    }
	    	else{
	    		$("#tr_td").append("<td  id='td_input"+headCount+"' ></td>")
	    	    $("#td_input"+headCount+"").append
	    		("<input  class='easyui-numberbox' name='"+headArray[headCount]+"'  type='text'>");
	    	}
	    }
         
         $("#tr_td").append("<td id='td5'>")
         $("#td5").append
         ("<a href='#' onclick='insertjson()'><button>增加</button></a>");
   }
	  
   
       function deletejson(id){
    		  var json =JSON.stringify({
    				"aid":id,
    				"username":" ",
    			    "address":" ",
    			    "phone":" ",
    			    "name":" ",
    			    "defaultadress":" "
    			    }) ; 
    		   $.ajax({
    				  type:'POST',/* 请求类型为post */
    				  url:'${pageContext.request.contextPath}/rest/addressescontroller/deleteAddressesByList',/* 请求路径 */
    				  contentType:'application/json;charset=UTF-8',/* 向服务器提出的请求类型 */
    				  dataType: 'json',
    				  data:json,/* 请求的数据 */
    				  success: function(data){/* 回调函数 */
    					  window.location.reload();
    					  alert("删除成功");
    					 // var dataObj = JSON.parse(data);
    				     
    				  }
    			  });
    	  }
       function updatejson(name){
     		   var tables = [];
               var k = 0;
               var tr=  document.getElementsByName(name);
                   var tds=tr[0].cells;
                  // console.log(tds);
                  var inputs=[];
                   for(var j=0;j<headArray.length;j++) {
                    
                    inputs[j]=tr[0].cells[j].getElementsByTagName("INPUT")[0].value;
                     console.log(inputs[j]);
    	             
       } 
           	  var json =JSON.stringify({
        			"aid":inputs[0],
        			"username":inputs[1],
        		    "address":inputs[2],
        		    "phone":inputs[3],
        		    "name":inputs[4],
        		    "defaultadress":inputs[5]}
        		    ) ; 
        	   $.ajax({
        			  type:'POST',/* 请求类型为post */
        			  url:'${pageContext.request.contextPath}/OnlineShop/rest/addressescontroller/updateAddresses',/* 请求路径 */
        			  contentType:'application/json;charset=UTF-8',/* 向服务器提出的请求类型 */
        			  dataType: 'json',
        			  data:json,/* 请求的数据 */
        			  success: function(data){/* 回调函数 */
        				  window.location.reload();
        				  alert("修改成功");
        			  }
          			  
          		  });
       }
        	   function insertjson(){
        		   var tables = [];
                   var k = 0;
                   var tr=  document.getElementsByName("tr_name");
                       var tds=tr[0].cells;
                      // console.log(tds);
                      var inputs=[];
                       for(var j=0;j<headArray.length;j++) {
                        inputs[j]=tr[0].cells[j].getElementsByTagName("INPUT")[0].value;
                         console.log(inputs[j]);
        	             
           } 
               	  var json =JSON.stringify({
            			"aid":" ",
            			"username":inputs[1],
            		    "address":inputs[2],
            		    "phone":inputs[3],
            		    "name":inputs[4],
            		    "defaultadress":inputs[5]}
            		    ) ; 
        			   $.ajax({
        					  type:'POST',/* 请求类型为post */
        					  url:'${pageContext.request.contextPath}/rest/addressescontroller/insertIAddresses',/* 请求路径 */
        					  contentType:'application/json;charset=UTF-8',/* 向服务器提出的请求类型 */
        					  dataType: 'json',
        					  data:json,/* 请求的数据 */
        					  success: function(data){/* 回调函数 */
        						  window.location.reload();
        						  alert("添加成功");
        					  }
        					  
        				  });
               }
       
</script>  
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
<form action="${pageContext.request.contextPath}/rest/CustomerController/updateUserdetailsById" method="post">
<h3>个人信息<td><a style="margin-left: 30px;color:#333;text-decoration: none" href="${pageContext.request.contextPath}/rest/mainHomeController/homepage">返回</a></td></h3>
<div>
<table border="1">
<tr>
<td>账号</td>
<td>名字</td>
<td>电话</td>
<td>积分</td>

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
</div>
</form>

<h3 class="div1">地址信息</h3>
<div >

    <table id="table1" class="div2">
    </table>
    </div>
</body>  
</html>   
