<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script>

function add()
{
 var x=document.getElementById("number").value;
 x=parseInt(x)+1;
 document.getElementById("number").value=x;
}

function minn()
{
var y=document.getElementById("number").value;
y=parseInt(y)-1;
if(parseInt(y)<=0){
	parseInt(y)(parseInt(y)+1); //最小值为1
}
document.getElementById("number").value=y;
}


</script>
</head>
<body>

    <form action="${pageContext.request.contextPath}/OrderControl/updateorders11/{oid}" method="post">
        <fieldset>
        <legend>确认订单</legend>
            <p>
                <label>订单编号：</label> <input type="text" id="oid" name="oid"
                    tabindex="2" readonly="readonly" value="${orders.oid}">
            </p>
                  <p>
                <label>账号：</label> <input type="text" id="username" name="username"
                    tabindex="2" readonly="readonly" value="${orders.username}">
            </p>     
             <p>
                <label>运费：</label> <input type="text" id="freight" name="freight"
                    tabindex="3" readonly="readonly" value="${orders.freight}">
            </p>  
              <p>
                <label>状态：</label> <input type="text" id="status" name="status"
                    tabindex="4" readonly="readonly" value="${orders.status}">
            </p> 
                        <p>
                <label>商品编号：</label> <input type="text" id="cid" name="cid"
                    tabindex="2" readonly="readonly" value="${orderdetails.cid}">
            </p>
            <p>
            <label>购买的数量：</label> 
               <input  onclick="minn()" type="button" value="-" />   
                <input type="text" id="number" name="number" tabindex="2"  value="${orderdetails.number}">                
                <input  onclick="add()" type="button" value="+" />
                                
               
            </p>                
              <p>
                <label>选择收货地址：</label> <input type="text" id="aid" name="aid"
                    tabindex="4" value="${orderdetails.aid}">
            </p>           
            <p id="buttons">
                <input id="reset" type="reset" tabindex="6" value="取消"> 
                <input id="submit" type="submit" tabindex="7" value="确定提交">
            </p>
            
            
        </fieldset>
    
    </form>
</body>

</html>