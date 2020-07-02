<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/OrderControl/saveOrderdetails" method="post">
        <fieldset>
        <legend>购买订单详情</legend>
            <p>
                <label>订单编号：</label> <input type="text" id="oid" name="oid"
                    tabindex="2">
            </p>
                  <p>
                <label>账号：</label> <input type="text" id="username" name="username"
                    tabindex="2">
            </p>     
             <p>
                <label>运费：</label> <input type="text" id="freight" name="freight"
                    tabindex="3">
            </p>  
              <p>
                <label>状态：</label> <input type="text" id="status" name="status"
                    tabindex="4">
            </p> 
                        <p>
                <label>商品编号：</label> <input type="text" id="cid" name="cid"
                    tabindex="2">
            </p>
                  <p>
                <label>数量：</label> <input type="text" id="Number" name="Number"
                    tabindex="2">
            </p>     
             <p>
                <label>发货地址：</label> <input type="text" id="warehouse" name="warehouse"
                    tabindex="3">
            </p>  
              <p>
                <label>收货地址：</label> <input type="text" id="destination" name="destination"
                    tabindex="4">
            </p> 
            <p id="buttons">
                <input id="reset" type="reset" tabindex="6" value="取消"> 
                <input id="submit" type="submit" tabindex="7" value="创建">
            </p>
        </fieldset>
    
    </form>
    
</body>
</html>