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

	<table></table>
	<div>
		<s:iterator value="bigOrder" var="singleBO">
			<s:if test="#singleBO.order_info!='未付款'">
				<div id="singleOrderdiv" style="border: solid 1px; width: 400px;height: 100px;float: left;margin-left: 50px;margin-top: 10px;">
					<div style="border: solid 1px;width: 300px;height: 100px;float: left;">
					<dt style="float: left;width: 80px">订单号:</dt>
					<dd style="width: 200px;margin-left: 50px"><s:property value="#singleBO.order_id" /></dd>
					<hr class="one_line">
					<dt style="float: left;width: 80px;'">总金额:</dt>
					<dd style="width: 200px;margin-left: 50px"><s:property value="#singleBO.order_totalprce" /></dd>
					<hr class="one_line">
					<dt style="float: left;">当前状态:</dt>
					<dd style="width: 200px;margin-left: 50px"><s:property value="#singleBO.order_info" /></dd>
					<hr class="one_line">
					</div>
					<div style="border: solid 1px;width: 80px;height:100px;float: left;">
						<dd style="margin-left: 20px"><a href="user_rcvgoods.action?order_id=${singleBO.order_id}">收货</a></dd>
						<hr class="one_line">
						<dd style="margin-left: 10px"><a href="user_get_detail_order.action?order_id=${singleBO.order_id}">详细信息</a></dd>
						<hr class="one_line">
					</div>
				</div>
			</s:if>
		</s:iterator>
	</div>
</body>
</html>