<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="user/user_seeshoppingcart.action">查看购物车</a><br>
<table>
	<tr>
	<th>商品编号</th>
	<th>商品名</th>
	<th>详细描述</th>
	<th>价格</th>
	<th>库存</th>
	<th>分类</th>
	<th>打折</th>
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
		<td>
		<s:form action="user/user_addshoppingcart.action" method="post">
			<s:hidden name="goods_id" value="%{#singlegoods.goods_id}"></s:hidden>
			<s:hidden name="goods_name" value="%{#singlegoods.goods_name}"></s:hidden>
			<s:hidden name="goods_price" value="%{#singlegoods.goods_price}"></s:hidden>
			<s:hidden name="goods_discount" value="%{#singlegoods.goods_discount}"></s:hidden>
			<s:textfield name="goods_num" value="" label="购买数量"></s:textfield><br>
		<s:submit value="加入购物车"></s:submit>
		</s:form>
		</td>
	</tr>
	</s:iterator>
</table>
</body>
</html>