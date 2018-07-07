<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
登录成功!<br>
<a href="shop_newgoods.jsp">新增商品</a><br>
<table>
	<tr>
	<th>商品编号</th>
	<th>商品名</th>
	<th>详细描述</th>
	<th>价格</th>
	<th>库存</th>
	<th>分类</th>
	<th>打折</th>
	<th>图片</th>
	<th>管理商品</th>
	</tr>
	<s:iterator value="goods" var="singlegoods">
	<tr>
		<td><s:property value="#singlegoods.goods_id" /></td>
		<td><s:property value="#singlegoods.goods_name" /></td>
		<td><s:property value="#singlegoods.goods_info"/></td>
		<td><s:property value="#singlegoods.goods_price" /></td>
		<td><s:property value="#singlegoods.goods_num"/></td>
		<td><s:property value="#singlegoods.goods_type"/></td>
		<td><s:property value="#singlegoods.goods_discount"/>%</td>
		<td><img style="width: 100px;height: 100ps" src="<s:property value="'../image/'+seller_username+'_shop/'+#singlegoods.goods_id+'.jpg'"/>"/></td>
		<td><a href="user/seller_managegoods.action?goods_id=${singlegoods.goods_id}">管理商品</a><br></td>
	</tr>
	</s:iterator>
</table>
</body>
</html>