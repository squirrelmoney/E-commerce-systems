<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User From</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/rest/AdminController/updateUser">
        <fieldset>
        <legend>修改用户信息</legend>
             
             <p>
                <label>账号：</label> <input type="text" id="username" name="username"
                    tabindex="1" readonly="readonly" value="${user.username}">
            </p>
                         <p>
                <label>权限：</label> <input type="text" id="authority" name="authority"
                    tabindex="2" value="${user.authority}" >
            </p>
            <p>
                <label>密码：</label> <input type="text" id="password" name="password"
                    tabindex="3"  readonly="readonly"  value="${user.password}">
            </p>    
             <p>
                <label>名字：</label> <input type="text" id="name" name="name"
                    tabindex="5" value="${userdetails.phone}">
            </p>  
              <p>
                <label>电话：</label> <input type="text" id="phone" name="phone"
                    tabindex="6" readonly="readonly"  value="${userdetails.name}">
            </p> 
                          <p>
                <label>积分：</label> <input type="text" id="points" name="points"
                    tabindex="7" readonly="readonly" value="${userdetails.points}">
            </p> 
            <p id="buttons">
                <input id="reset" type="reset" tabindex="8" value="取消"> 
                <input id="submit" type="submit" tabindex="9" value="修改">
            </p>
        </fieldset>
    
    </form>
    
   
</body>
</html>
