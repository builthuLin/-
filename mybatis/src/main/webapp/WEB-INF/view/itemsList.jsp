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
	background-image: url("https://oss.meibbc.com/BeautifyBreast/file/shequ/3B9F44C4E6D847A280544EC3D2F5B6F8.jpeg");
	background-position: center center; 
	background-repeat: no-repeat; 
 	background-attachment: scroll; 
	background-size: 100% auto;
	width:100%;
	height:1024px; 
}

</style>
</head>
<body>
<form action="" method="post">
查询条件：
<table width="100%" border="1" align="center">
<tr>
    <td align="center">商品名称</td>
    <td align="center">商品价格</td>
    <td align="center">商品描述</td>
    <td align="center">操作</td>
</tr>
<c:forEach items="${itemsList}" var="item">
<tr>
    <td align="center">${item.name}</td>
    <td align="center">${item.price}</td>
    <td align="center">${item.detail}</td>
    <td align="center"><a href="index.jsp">查看详情</a></td>
</tr>
</c:forEach>

</table>
</form>

</body>
</html>