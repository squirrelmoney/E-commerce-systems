<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/rest/CommdityController/updateCommodity">
        <fieldset>
        <legend>修改商品信息</legend>
            <p>
                <label>编号：</label> <input type="text" id="cid" name="cid"
                    tabindex="1" readonly="readonly" value="${Commodity.cid}">
            </p>
              <p>
                <label>名称：</label> <input type="text" id="name" name="name"
                    tabindex="2" value="${Commodity.name}">
            </p>
                  <p>
                <label>价格：</label> <input type="text" id="price" name="price"
                    tabindex="2" value="${Commodity.price}">
            </p>     
             <p>
                <label>积分：</label> <input type="text" id="points" name="points"
                    tabindex="3" value="${Commodity.points}">
            </p>  
              <p>
                <label>成本价：</label> <input type="text" id="cost" name="cost"
                    tabindex="4" value="${Commodity.cost}">
            </p> 
             
            <p id="buttons">
                <input id="reset" type="reset" tabindex="6" value="取消"> 
                <input id="submit" type="submit" tabindex="7" value="修改">
            </p>
           
            <p><a href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">返回</a></p>
        </fieldset>
    
    </form>
</body>
</html>