<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/rest/AdminController/saveCommndity" method="post">
        <fieldset>
        <legend>新增商品</legend>
            <p>
                <label>名称：</label> <input type="text" id="name" name="name"
                    tabindex="2">
            </p>
                  <p>
                <label>价格：</label> <input type="text" id="price" name="price"
                    tabindex="2">
            </p>     
             <p>
                <label>积分：</label> <input type="text" id="points" name="points"
                    tabindex="3">
            </p>  
              <p>
                <label>成本价：</label> <input type="text" id="cost" name="cost"
                    tabindex="4">
            </p> 
            <p id="buttons">
                <input id="reset" type="reset" tabindex="6" value="取消"> 
                <input id="submit" type="submit" tabindex="7" value="创建">
            </p>
        </fieldset>
    <p><a href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">返回</a></p>
    </form>
    
</body>
</html>