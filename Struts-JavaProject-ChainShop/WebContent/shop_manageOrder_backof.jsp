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
	<s:iterator value="bigOrder" var="singleBO">
		<table style="float: left;width: 400px;height: 550px;border: solid 1px;">
			<tr style="width: 300px;height: 90px;border: solid 1px;">
			<th style="width: 25%;height: 30px;border: solid 1px;">订单号</th>
			<th style="width: 25%;height: 30px;border: solid 1px;">总价</th>
			<th style="width: 50%;height: 30p;border: solid 1px;x">详细信息</th>
			</tr>
			<tr>
				<td style="width: 25%;height: 10px;border: solid 1px;"><s:property value="#singleBO.order_id" /></td>
				<td style="width: 25%;height: 10px;border: solid 1px;"><s:property value="#singleBO.order_totalprce" /></td>	
				<td>
					<table style="border: solid 1px;width: 200px;height: 400px">
					<tr >
						<th style="height:40px;width:40px;border: solid 1px;">买家 </th>
						<th style="border: solid 1px;">商品号 </th>
						<th style="border: solid 1px;">详购买数量 </th>
						<th style="border: solid 1px;">单项总价</th>
					</tr>
					<s:iterator value="orders" var="singleorder">
					<tr>
					<s:if test="%{#singleBO.order_id==#singleorder.order_id}" >
						<td><s:property value="#singleorder.order_buyer_id" /></td>
						<td><s:property value="#singleorder.order_singlegoods.goods_id" /></td>
						<td><s:property value="#singleorder.order_goods_stock" /></td>
						<td><s:property value="#singleorder.order_totalprce" /></td>
					</s:if>
					</tr>
					</s:iterator>
					</table>
				</td>	
			</tr>
		</table>
	</s:iterator>
	
	<div>
		<s:iterator value="bigOrder" var="singleBO">
		<div id="singleOrderdiv" style="border: solid 1px;">
			<div style="border: solid 1px;">
			<dt style="border: solid 1px;">订单号</dt>
			<dd style="border: solid 1px;"><s:property value="#singleBO.order_id" /></dd>
			</div>
			<div></div>
			<div></div>
		</div>
		</s:iterator>
	</div>
</body>
</html>