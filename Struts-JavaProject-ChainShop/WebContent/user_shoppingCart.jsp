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
<s:property value="%{seller_username}" />
<a href="user_creatorder.action">结账</a><br>
<a href="user_loginsuccess.action">返回首页</a><br>
<table>
	<tr>
	<th>商品编号</th>
	<th>商品名</th>
	<th>单价</th>
	<th>购买数量</th>
	<th>原价总价</th>
	<th>折后总价</th>
	</tr>
	<s:iterator value="goods" var="singlegoods">
	<tr>
		<td><s:property value="#singlegoods.goods_id" /></td>
		<td><s:property value="#singlegoods.goods_name" /></td>
		<td><s:property value="#singlegoods.goods_price" /></td>
		<td><s:property value="#singlegoods.goods_num"/></td>
		<td><s:property value="#singlegoods.goods_totalPrice"/></td>
		<td><s:property value="#singlegoods.goods_totalPriceAfterDiscount"/></td>
	</tr>
	</s:iterator>
	</table>
	订单总价<s:property value="%{orderTotalPrice}"/>
</body>
</html>