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
	<s:form action="user/user_regist.action" method="post">
	<s:textfield name="user.username" label="账号"></s:textfield><br>
	<s:password name="user.password" label="密码"></s:password>
	<s:textfield name="user.nickname" label="昵称"></s:textfield><br>
	<s:textfield name="user.realname" label="真实姓名"></s:textfield><br>
	<s:textfield name="user.idnum" label="身份证号码"></s:textfield><br>
	<s:textfield name="user.address.city" label="市"></s:textfield><br>
	<s:textfield name="user.address.county" label="区/县"></s:textfield><br>
	<s:textfield name="user.address.street" label="街道"></s:textfield><br>
	<s:textfield name="user.address.building" label="门牌号"></s:textfield><br>
	<s:submit value="注册"></s:submit>
	</s:form>
</body>
</html>