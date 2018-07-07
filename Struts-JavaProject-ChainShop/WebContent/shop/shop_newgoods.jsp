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
	<s:form action="uers/seller_add_goods.action" method="post">
	<s:textfield name="goods_name" label="商品名"  ></s:textfield><br>
	<s:textfield name="goods_info" label="描述" ></s:textfield><br>
	<s:textfield name="goods_num" label="库存" ></s:textfield><br>
	<s:textfield name="goods_price" label="价格" ></s:textfield><br>
	<s:textfield name="goods_discount" label="折扣" ></s:textfield><br>
	<s:select label="分类" name="goods_type" id="goods_type" headerKey="日用品" 
		headerValue="日用品" list="#{'日用品':'日用品','熟食品/方便食品':'熟食品/方便食品','饮料/烟酒':'饮料/烟酒','生鲜':'生鲜'}"></s:select>
	<s:submit value="确认"></s:submit>
	</s:form>
</table>
</body>
</html>