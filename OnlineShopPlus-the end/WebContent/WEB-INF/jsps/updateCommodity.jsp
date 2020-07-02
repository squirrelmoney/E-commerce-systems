<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<c:set var="picPath" value="http://localhost:8083/Filesevice"></c:set>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
<script type="text/javascript">
 function submitImgSize1Upload()
 {
	/* 页面回显
	ajax不能提交表单,但能通过第三方工具jquery.form.js提交表单
	file放在表单上一起提交*/
	var option={
			type:'POST',
			url:'${pageContext.request.contextPath }/AdminController/uploadPic.do',
			dataType:'text',
			/* data传送的数据是文件对象id */
			data:{
				fileName : 'imgSize1File'
			},
			/* 文件上传到服务器，后台向前台返回文件绝对路径fullpath设置为img的src-页面回显
				relativePath存到数据库 */
			success:function(data){
				
				//把json格式的字符串转换成json对象
				var jsonObj = $.parseJSON(data);
				//返回服务器图片路径，把图片路径设置给img标签
				$("#imgSize1ImgSrc").attr("src",jsonObj.fullPath);
				//数据库保存相对路径
				$("#imgSize1").val(jsonObj.relativePath);
			}	
		};
	/* 不能单独上传图片，因为图片关联表单，图片上传之后要回显在表单上
	所以ajax要提交表单，ajax不能实现提交表单的功能，要借助第三方工具提交表单*/
	$("#itemForm").ajaxSubmit(option);
	
}
</script>


</head>
<body>
<c:set var="Commodity" value="${commodity}"></c:set>
<form  id="itemForm" action="${pageContext.request.contextPath}/AdminController/updateCommodity.do" method="post">
	商品编号:<input type="text" name="cid" value="${Commodity.cid}" readonly="readonly">
	<br>
	<br>
	商品名称:<input type="text" name="name" value="${Commodity.name}">
	<br>
	<br>	
	图片:<img id='imgSize1ImgSrc' src='${picPath }${Commodity.picture}'  height="50" width="50" />
	
		 <!-- type类型是文件类型，通过id得到图片对象， submitImgSize1Upload()页面回显 -->
		 <input type='file' id='imgSize1File' name='imgSize1File' class="file" onchange='submitImgSize1Upload()' />
		 
		 <span class="pos" id="imgSize1FileSpan">请上传图片的大小不超过3MB</span>
		 
		 <!-- 返回一个相对路径放到数据库当中 -->
        <input type='hidden' id='imgSize1' name='picture' value='${Commodity.picture}' reg="^.+$" tip="亲！您忘记上传图片了。" />
	<br>
	<br>	
	价格:<input type="text" name="price" value="${Commodity.price}">
	<br>
	<br>		
	积分:<input type="text" name="points" value="${Commodity.points}">
	<br>
	<br>		
	成本:<input type="text" name="cost" value="${Commodity.cost}">
	<br>
	<br>		
	<input type="submit" value="提交">
    <p><a href="${pageContext.request.contextPath}/rest/mainHomeController/adminhomepage">返回</a></p>
    
    </form>
</body>
</html>