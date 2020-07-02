<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>账号</td>
<td>密码</td>
<td>权限</td>
<td>操作</td>
</tr>

  <c:forEach items="${list}" var="list">
  <tr>
  <td>${list.username}</td>
  <td>${list.password}</td>
  <td>${list.authority}</td>
  <td> 
    
    <a href="${pageContext.request.contextPath}/rest/userController/deleteUserTest/${list.username}">删除</a>
    <a href="${pageContext.request.contextPath}/rest/userController/updateUserTest/${list.username}">修改</a>
    <a href="${pageContext.request.contextPath}/rest//CommdityController/tolistallCommodity">返回</a>
  </td>
 </tr>
  </c:forEach>
 </table>
</body>
</html>