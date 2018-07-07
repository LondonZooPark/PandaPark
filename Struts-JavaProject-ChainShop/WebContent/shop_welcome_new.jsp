<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

.first-div {
	display: block;
	text-align:center;
	width: 250px;
	height: 500px;
	float: left;
	box-sizing: border-box;

}
.content {
	margin-top: 5px;
}

.content dt {
	width: 80px;
	display: inline-block;
	float: left;
	margin-left: 10px;
	color: #666;
	font-size: 13px;
	margin-top: 8px;
	border: solid 1px;
}

.content dd {

	margin-left: 90px;
	margin-bottom: 5px;
	border: solid 1px;
}
.show {
	clear: left;
	display: block;
}

.showSingleGoods {
	display: block;
	text-align:center;
	width: 230px;
	height: 430px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
登录成功!<br>
<a href="shop_newgoods.jsp">新增商品</a><br>
<a href="seller_seeorder.action">查看订单</a><br>
	<div style="border: solid 1px;">
		<s:iterator value="goods" var="singlegoods">
		<div class="first-div">
			<div class="showSingleGoods" style="border: solid 1px;">
				<div class="show">
				<img style="width: 100px;height: 100px" src="<s:property value="'../image/'+seller_username+'_shop/'+#singlegoods.goods_id+'.png'"/>"/>
				</div>
				<div style="width: 200px;height:200px;">
				<dl class="content">
					<dt >商品编号</dt>
					<dd ><s:property value="#singlegoods.goods_id" /></dd>
					<dt >商品名称</dt>
					<dd ><s:property value="#singlegoods.goods_name" /></dd>
					<dt >商品信息</dt>
					<dd ><s:property value="#singlegoods.goods_info" /></dd>
					<dt >商品库存</dt>
					<dd ><s:property value="#singlegoods.goods_num" /></dd>
					<dt >商品单价</dt>
					<dd ><s:property value="#singlegoods.goods_price" /></dd>
					<dt >商品分类</dt>
					<dd ><s:property value="#singlegoods.goods_type" /></dd>
					<dt >商品打折</dt>
					<dd ><s:property value="#singlegoods.goods_discount" />%</dd>
				</dl>
				</div>
				<div style="width: 230px;height:50px;font-size: 15px;color: #FFFFFF ;background-color: #ffff80">
				<dl style="margin-top: 40px;">
					<dd style="margin-left: -20px;margin-top: 10px"><a href="seller_managegoods.action?goods_id=${singlegoods.goods_id}">管理商品</a></dd>
				</dl>
				</div>
			</div>
		</div>
		</s:iterator>
	</div>
</body>
</html>