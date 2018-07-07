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
		<s:iterator value="shops" var="shop">
			账号   :<s:property value="#shop.seller.username" /><br>
			密码 :<s:property value="#shop.seller.password" /><br>
			店名:<s:property value="#shop.seller.nickname"/><br>
			真实姓名  :<s:property value="#shop.seller.realname" /><br>
			身份证号:<s:property value="#shop.seller.idnum"/><br>
			地址:<s:property value="#shop.seller.address.city"/>市
				<s:property value="#shop.seller.address.county"/>区/县
				<s:property value="#shop.seller.address.street"/>街
				<s:property value="#shop.seller.address.building"/>号<br>
			<a href="user/seller_approvalseller.action?username=${shop.seller.username}">批准！</a><br>
			<br>
	</s:iterator>
</body>
</html>