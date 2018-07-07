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
	<s:form action="shop/seller_regist.action" method="post">
	<s:textfield name="shop.seller.username" label="账号"></s:textfield><br>
	<s:password name="shop.seller.password" label="密码"></s:password>
	<s:textfield name="shop.seller.nickname" label="店名"></s:textfield><br>
	<s:textfield name="shop.seller.realname" label="真实姓名"></s:textfield><br>
	<s:textfield name="shop.seller.idnum" label="身份证号码"></s:textfield><br>
	<s:textfield name="shop.seller.address.city" label="市"></s:textfield><br>
	<s:textfield name="shop.seller.address.county" label="区/县"></s:textfield><br>
	<s:textfield name="shop.seller.address.street" label="街道"></s:textfield><br>
	<s:textfield name="shop.seller.address.building" label="门牌号"></s:textfield><br>
	<s:textfield name="shop.seller.phone_number" label="联系电话"></s:textfield><br>
	<s:submit value="提交加盟信息"></s:submit>
	</s:form>
</body>
</html>