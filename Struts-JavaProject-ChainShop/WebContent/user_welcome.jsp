<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/web1.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<a href="user/user_seeshoppingcart.action">查看购物车</a><br>
		<s:iterator value="shops" var="shop">
			店名:<s:property value="#shop.seller.nickname"/><br>
			地址:<s:property value="#shop.seller.address.city"/>市
				<s:property value="#shop.seller.address.county"/>区/县
				<s:property value="#shop.seller.address.street"/>街
				<s:property value="#shop.seller.address.building"/>号<br>
			<a href="user/user_intoshop.action?seller_username=${shop.seller.username}">进店</a><br>
			<br>
		</s:iterator>
</body>
</html>