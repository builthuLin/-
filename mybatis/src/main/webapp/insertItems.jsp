<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品信息</title>
<style type="text/css">
td{
   height: 40px;
}
input[type=text]{
   float:left;
   width:90%;
   height: 30px;
}
</style>
</head>
<body>
<form id="itemForm" action="insertItems.action" method="post" enctype="multipart/form-data">
<table width="30%" border="1" align="center">
<tr>
   <td colspan="2" align="center"><span>商品信息：</span></td>
</tr>
<tr>
   <td align="center">商品名称</td>
   <td align="center"><input type="text" name="name" value=""/></td>
</tr>
<tr>
   <td align="center">商品价格</td>
   <td align="center"><input type="text" name="price" value=""/></td>
</tr>
<tr>
   <td align="center">商品描述</td>
   <td align="center"><input type="text" name="detail" value=""/></td>
</tr>
<tr>
   <td align="center">商品图片</td>
   <td align="center">
	   <input type="text" style="display: none;" name="pic" value=""/>
	   <input type="file" name="pictureFile">
   </td>
</tr>
<tr>
   <td align="center">生产时间</td>
   <td align="center"><input type="text" name="createtime" value=""/></td>
</tr>
<tr>
<td colspan="2" align="center">
   <input type="submit" value="提交" style="width: 80px;height: 30px;"/>
   <input type="submit" value="返回" style="width: 80px;height: 30px;"/>
</td>
</tr>
</table>
</form>
</body>
</html>