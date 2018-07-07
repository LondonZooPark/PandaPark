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
	<s:form action="user/user_login.action" method="post">
		<s:textfield name="user_username" label="账号"></s:textfield><br>
		<s:password name="user_password" label="密码"></s:password>
		<s:submit value="登录"></s:submit>
	</s:form>
	<a href="user_regist.jsp">注册！</a>
</body>
</html>