<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<style type="text/css">
body{
	/* background-image: url("https://oss.meibbc.com/BeautifyBreast/file/shequ/3B9F44C4E6D847A280544EC3D2F5B6F8.jpeg");
	background-position: center center; 
	background-repeat: no-repeat; 
 	background-attachment: scroll; 
	background-size: 100% auto;
	width:100%;
	height:1024px;  */
}
img{
   width:100px;
   height: 60px;
}
</style>
<script>
function insertItems() {
	alert("新增");
	window.open("insertItems.jsp"); 
}
</script>
</head>
<body>
<form action="" method="post">

<table width="100%" border="1" align="center">
<tr>
	<td colspan="6" style="height: 60px;">
	<input type="button" id="insert" name="insert" onclick=insertItems(); value="添加商品" style="float: right;width: 100px;height: 40px;margin: 10px;"/>
	</td>
</tr>
<tr>
    <td colspan="6" align="center" style="height: 60px;"><span style="font-size: 24px;">商品信息</span></td>
</tr>
<tr style="height: 40px;">
    <td align="center"><h4>商品名称</h4></td>
    <td align="center"><h4>商品价格</h4></td>
    <td align="center"><h4>商品描述</h4></td>
    <td align="center"><h4>商品图片</h4></td>
    <td align="center"><h4>生产时间</h4></td>
    <td align="center"><h4>操作</h4></td>
</tr>
<c:forEach items="${itemsList}" var="item">
<tr>
    <td align="center">${item.name}</td>
    <td align="center">${item.price}</td>
    <td align="center">${item.detail}</td>
    <td align="center"><a href="${item.pic}" title="点击查看"><img src="${item.pic}"/></a></td>
    <td align="center">
       <fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
    </td>
    <td align="center"><a href="editItems.action?id=${item.id}">修改</a><span>/</span><a href="deleteItems.action?id=${item.id}">删除</a></td>
</tr>
</c:forEach>

</table>
</form>

</body>
</html>