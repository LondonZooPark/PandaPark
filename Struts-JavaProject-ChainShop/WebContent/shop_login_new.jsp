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
	<div class="one">
	<form action="shop/seller_login.action" method="post">
		<div class="show">
			<dl class="content">
				<dt>账号:</dt>
				<dd><input type="text" name="seller_username" 
					value="请输入账号"onfocus="if (value =='请输入账号'){value =''}"onblur="if (value ==''){value='请输入账号'}"
					/></dd>
				<hr class="one_line">
				<dt>密码:</dt>
				<dd><input type="password" name="seller_password" 
				value="请输入密码"onfocus="if (value =='请输入密码'){value =''}"onblur="if (value ==''){value='请输入密码'}"
				/></dd>
				<hr class="one_line">
				<dd id="btn-dd">
				<span class="new-btn-login-sp">
				<button type="submit" class="new-btn-login-shop" style="text-align: center;">登录</button>
				</span></dd>
			</dl>
		</div>
	</form>
	<div class="show">
		<dl class="content">
		<dd id="btn-dd">
		<span class="new-btn-login-sp">
			<form action="shop_regist.jsp" method="post">
				<button type="submit" class="new-btn-login-shop" style="text-align: center;">注册</button>
			</form>
		</span>
		</dd>
		</dl>
	</div>
	</div>
</body>
</html>