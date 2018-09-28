<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
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
<form id="itemForm" action="editItemsSubmit.action" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${itemsCustom.id}"/>
<table width="30%" border="1" align="center">
<tr>
   <td colspan="2" align="center"><span>商品信息：</span></td>
</tr>
<tr>
   <td align="center">商品名称</td>
   <td align="center"><input type="text" name="name" value="${itemsCustom.name}"/></td>
</tr>
<tr>
   <td align="center">商品价格</td>
   <td align="center"><input type="text" name="price" value="${itemsCustom.price}"/></td>
</tr>
<tr>
   <td align="center">商品描述</td>
   <%-- <td align="center"><input type="text" name="detail" value="${itemsCustom.detail}"/></td> --%>
   <td><textarea rows="10" cols="30" name="detail" style="margin: 0px;width: 90%">${itemsCustom.detail}</textarea></td>
</tr>
<%-- <tr>
   <td>商品图片</td>
   <td><input type="text" name="pic" value="${item.pic}"/></td>
   <td>
     <c:if test="${item.pic != null}">
        <img alt="" src="${item.pic}" width="100" height="100">
        <br/>
     </c:if>
     <input type="file" name="pictureFile">
   </td>
</tr> --%>
<%-- <tr>
   <td>生产时间</td>
   <td><input type="text" name="createtime" value="<fmt:formatDate value='${item.createtime}' pattern='yyyy-MM-dd HH:mm:sss'/>"/></td>
</tr> --%>
<tr>
<td colspan="2" align="center"><input type="submit" value="修改" style="width: 80px;height: 30px;"/></td>
</tr>
</table>
</form>
</body>
</html>