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
	
	<s:form action="shop/seller_login.action" method="post">
	
		<s:textfield name="seller_username" label="账号"></s:textfield>
		<s:password name="seller_password" label="密码"></s:password>
		<s:submit value="登录"></s:submit>
	</s:form>
	<a href="shop_regist.jsp">加盟！</a>
</body>
</html>