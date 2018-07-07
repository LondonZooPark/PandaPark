<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.one_line {
	display: block;
	height: 1px;
	border: 0;
	border-top: 1px solid #eeeeee;
	width: 100%;
	margin-left: 5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	订单号<s:property value="order.order_id" /><br>
	卖家<s:property value="order.order_seller_id" /><br>
	买家<s:property value="order.order_buyer_id" /><br>
	
	<table>
	<tr>
	<th>商品编号</th>
	<th>商品名</th>
	<th>详细描述</th>
	<th>原价</th>
	<th>购买量</th>
	<th>分类</th>
	<th>打折</th>
	<th>折后单价</th>
	</tr>
	<s:iterator value="order.goods" var="singlegoods">
	<tr>
		<td><s:property value="#singlegoods.goods_id" /></td>
		<td><s:property value="#singlegoods.goods_name" /></td>
		<td><s:property value="#singlegoods.goods_info"/></td>
		<td><s:property value="#singlegoods.goods_price" /></td>
		<td><s:property value="#singlegoods.goods_num"/></td>
		<td><s:property value="#singlegoods.goods_type"/></td>
		<td><s:property value="#singlegoods.goods_discount"/>%</td>
		<td><s:property value="#singlegoods.goods_totalPriceAfterDiscount"/></td>
	</tr>
	</s:iterator>
	</table>
	订单总价<s:property value="order.order_totalprce" /><br>
</body>
</html>