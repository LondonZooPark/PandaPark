<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}
.one{
 position: absolute;
 top: 40%;
 left: 30%;
width: 300px;
height: 200px;

box-sizing: border-box;
}
.two{
 	position: absolute;
 	top: 40%;
 	left: 50%;
 	width: 300px;
	height: 200px;



float: left;

box-sizing: border-box;

}

.toDivmid{
	position: absolute;
    left:50%;
    top:40%;
    transform: translate(-50%, -50%);
}

.toDivmid2{
    position: absolute;
    left:50%;
    top:70%;
    transform: translate(-50%, -50%);
}
.sameline{


width: 10%;

height: 100px;

float: left;

box-sizing: border-box;

}
ul, ol {
	list-style: none;
}

body {
	font-family: "Helvetica Neue", Helvetica, Arial, "Lucida Grande",
		sans-serif;
}

.tab-head {
	margin-left: 120px;
	margin-bottom: 10px;
}

.tab-content {
	clear: left;
	display: none;
}

h2 {
	border-bottom: solid #02aaf1 2px;
	width: 200px;
	height: 25px;
	margin: 0;
	float: left;
	text-align: center;
	font-size: 16px;
}

.selected {
	color: #FFFFFF;
	background-color: #02aaf1;
}

.show {
	clear: left;
	display: block;
}

.hidden {
	display: none;
}

.new-btn-login-sp {
	padding: 1px;
	display: inline-block;
	width: 75%;
}

.new-btn-login {
	background-color: #02aaf1;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	width: 100%;
	height: 30px;
	border-radius: 5px;
	font-size: 16px;
}

.new-btn-login-shop {
	background-color: #ff8000;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	width: 100%;
	height: 30px;
	border-radius: 5px;
	font-size: 16px;
}

#main {
	width: 100%;
	margin: 0 auto;
	font-size: 14px;
}

.red-star {
	color: #f00;
	width: 10px;
	display: inline-block;
}

.null-star {
	color: #fff;
}

.content {
	margin-top: 5px;
}

.content dt {
	width: 100px;
	display: inline-block;
	float: left;
	margin-left: 20px;
	color: #666;
	font-size: 13px;
	margin-top: 8px;
}

.content dd {
	margin-left: 120px;
	margin-bottom: 5px;
}

.content dd input {
	width: 85%;
	height: 28px;
	border: 0;
	-webkit-border-radius: 0;
	-webkit-appearance: none;
}

#foot {
	margin-top: 10px;
	position: absolute;
	bottom: 15px;
	width: 100%;
}

.foot-ul {
	width: 100%;
}

.foot-ul li {
	width: 100%;
	text-align: center;
	color: #666;
}

.note-help {
	color: #999999;
	font-size: 12px;
	line-height: 130%;
	margin-top: 5px;
	width: 100%;
	display: block;
}

#btn-dd {
	margin: 20px;
	text-align: center;
}

.foot-ul {
	width: 100%;
}

.one_line {
	display: block;
	height: 1px;
	border: 0;
	border-top: 1px solid #eeeeee;
	width: 100%;
	margin-left: 20px;
}

.am-header {
	display: -webkit-box;
	display: -ms-flexbox;
	display: box;
	width: 100%;
	position: relative;
	padding: 7px 0;
	-webkit-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
	background: #1D222D;
	height: 50px;
	text-align: center;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	box-pack: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	box-align: center;
}

.am-header h1 {
	-webkit-box-flex: 1;
	-ms-flex: 1;
	box-flex: 1;
	line-height: 18px;
	text-align: center;
	font-size: 18px;
	font-weight: 300;
	color: #fff;
}
</style>
<body>
		<a href="user_seeshoppingcart.action">查看购物车</a><br>
		<a href="user_seeorder.action">管理订单</a><br>
		<table style="text-align:center;border-collapse: collapse;">
		<tr>
			<th  style="width: 250px;height: 50px;background-color: #ff8000">店名</th>
			<th  style="width: 2000px;height: 50px;background-color: #ff8000">地址</th>
		</tr>
		<s:iterator value="shops" var="shop">
		<tr>
				<td style="width: 250px;height: 50px;border:solid 1px;border-color:#ff8000;margin: auto;">
					<a href="user_intoshop.action?seller_username=${shop.seller.username}">
					<s:property value="#shop.seller.nickname"/></a></td>
				<td style="width: 2000px;height: 50px;border:solid 1px;border-color:#ff8000;margin: auto;">
					<a href="user_intoshop.action?seller_username=${shop.seller.username}">
					
					<s:property value="#shop.seller.address.city"/>市
					<s:property value="#shop.seller.address.county"/>区/县
					<s:property value="#shop.seller.address.street"/>街
					<s:property value="#shop.seller.address.building"/>号
					</a>
					
					<a href="get_goods_by_page.action?seller_username=${shop.seller.username}">新版进店入口</a>
				</td>
		</tr>
		</s:iterator>
		</table>
</body>
</html>