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
<table>
	<tr>
	<th>商品编号</th>
	<th>商品名</th>
	<th>详细描述</th>
	<th>价格</th>
	<th>库存</th>
	<th>分类</th>
	</tr>
	<tr>
		<td><s:property value="singlegoods.goods_id" /></td>
		<td><s:property value="singlegoods.goods_name" /></td>
		<td><s:property value="singlegoods.goods_info"/></td>
		<td><s:property value="singlegoods.goods_price" /></td>
		<td><s:property value="singlegoods.goods_num"/></td>
		<td><s:property value="singlegoods.goods_type"/></td>
	</tr>
	</table>
	<table>
	<tr>
	<td>
	<s:form action="uers/seller_update_goodsnum.action" method="post">
	<s:textfield name="goods_id" label="商品号" value="%{singlegoods.goods_id}" readonly="true"></s:textfield ><br>
	<s:textfield name="goods_name" label="修改商品名"  value="%{singlegoods.goods_name}"></s:textfield><br>
	<s:textfield name="goods_info" label="修改描述" value="%{singlegoods.goods_info}"></s:textfield><br>
	<s:textfield name="goods_num" label="修改库存" value="%{singlegoods.goods_num}"></s:textfield><br>
	<s:textfield name="goods_price" label="修改价格" value="%{singlegoods.goods_price}"></s:textfield><br>
	<s:textfield name="goods_discount" label="折扣(%)" value="0.0"></s:textfield><br>
	<s:select label="修改分类" name="goods_type" id="goods_type" headerKey="%{singlegoods.goods_type}" 
		headerValue="%{singlegoods.goods_type}" list="#{'日用品':'日用品','熟食品/方便食品':'熟食品/方便食品','饮料/烟酒':'饮料/烟酒','生鲜':'生鲜'}"></s:select>
	<s:submit value="确认"></s:submit>
	</s:form>
	<s:form  action="shop/seller_uploadfile.action" method="post" theme="simple" enctype="multipart/form-data">
		<s:hidden name="goods_id" value="%{singlegoods.goods_id}" readonly="true"></s:hidden ><br>
		<s:file name="uploadfile"/><br>
	<s:submit value="upload"/><br>
</s:form>
	</td>
	</tr>
	</table>
</body>
</html>