<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body bgcolor="#c0c0c0">
	<div class="one">
		<form action="user/user_regist.action" onsubmit="return check(this)" method="post">
		<div class="show">
			<dl class="content">
			<dt>账号:</dt>
			<dd> <input id="username_input" type="text" name="user.username"/></dd>
			<hr class="one_line">
			<dt>密码:</dt>
			<dd><input id="password_input" type="text" name="user.password" /></dd>
			<hr class="one_line">
			<dt>昵称:</dt>
			<dd><input id="nickname_input" type="text" name="user.nickname" /></dd>
			<hr class="one_line">
			<dt>真实姓名:</dt>
			<dd><input id="realname_input" type="text" name="user.realname" /></dd>
			<hr class="one_line">
			<dt>身份证号:</dt>
			<dd><input id="idnum_input" type="text" name="user.idnum" /></dd>
			<hr class="one_line">
			<dt>市:</dt>
			<dd><input id="city_input" type="text" name="user.address.city" /></dd>
			<hr class="one_line">
			<dt>区/县:</dt>
			<dd><input id="county_input" type="text" name="user.address.county" /></dd>
			<hr class="one_line">
			<dt>街道:</dt>
			<dd><input id="street_input"  type="text" name="user.address.street" /></dd>
			<hr class="one_line">
			<dt>门牌号:</dt>
			<dd><input id="building_input" type="text" name="user.address.building" /></dd>
			<hr class="one_line">
			<dt>联系电话:</dt>
			<dd><input id="phoneNum_input" type="text" name="user.phone_number" /></dd>
			<hr class="one_line">
			<dd id="btn-dd">
				<span class="new-btn-login-sp">
				<button type="submit" class="new-btn-login" style="text-align: center;" >注册</button>
				</span></dd>
			</dl>
		</div>
		</form>	
	</div>
	
		
</body>
<script language="javascript">


	function check(form) {
		var id_num = form.idnum_input.value;
		var username_input = form.username_input.value;
		var password_input = form.password_input.value;
		var nickname_input = form.nickname_input.value;
		var realname_input = form.realname_input.value;
		var city_input = form.city_input.value;
		var county_input = form.county_input.value;
		var street_input = form.street_input.value;
		var building_input = form.building_input.value;
	    var phoneNum_input = form.phoneNum_input.value;
	    checkUsername(username_input);
	    checkphoneNum(phoneNum_input);
        if (id_num.length >= 15) {
        	var isNum = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        	if(isNum.test(id_num) == false){
            	alert("身份证号码无效"+form.idnum_input.value);
            	return false;
        	}
        }else{
        	 alert("请输入有效身份证号码!");
        	 return false;
        }
        return true;
    

		//alert("测试点击");
	}
	
	function checkUsername(username) {
		var code = username.charCodeAt(0)
		var reg =  /^[0-9a-z]*$/;
		if(!isNaN(username[0])){
			alert("用户名不能以数字开头")
			return false;
		}else if(!(code >= 97 && code <= 122)){
			alert("用户名必须以小写字母开头");
			return false;
		}else if(!(username.length>=6&&username.length<=20)){
			alert("用户名不能少于6位大于20位");
			return false;
		}else if(reg.test(username) == false){
			alert("用户名只能包含小写英文或者数字");
			return false;
		}
		return true;
	}
	
	
	function checkphoneNum(phoneNum) {
		var reg =  /^[0-9]*$/;
		if(reg.test(phoneNum) == false){
			alert("联系电话有误");
			return false;
		}
		return true;
	}
</script>
</html>