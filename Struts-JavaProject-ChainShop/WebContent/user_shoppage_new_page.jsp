<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

.first-div {
	display: block;
	text-align:center;
	width: 250px;
	height: 500px;
	float: left;
	box-sizing: border-box;

}
.content {
	margin-top: 5px;
}

.content dt {
	width: 80px;
	display: inline-block;
	float: left;
	margin-left: 10px;
	color: #666;
	font-size: 13px;
	margin-top: 8px;
	border: solid 1px;
}

.content dd {

	margin-left: 90px;
	margin-bottom: 5px;
	border: solid 1px;
}
.show {
	clear: left;
	display: block;
}

.showSingleGoods {
	display: block;
	text-align:center;
	width: 230px;
	height: 480px;
}

#foot {
	height: 40px;
	width: 1200px;
	background-color: #F5F5F5;
	position: fixed;
	bottom: 0;
	text-align:center;
	border: solid 1px;
	margin-left: 10px;
}

.foot-dd{
	float: left;
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
	background: #FFFFFF;
	height: 50px;
	text-align: center;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	box-pack: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	box-align: center;
}

.head-dd{
	float: right;

}
.head-select{
	float: right; 
}
.new-btn-login-sp {
	padding: 1px;
	display: inline-block;
	width: 60%;
}

.new-btn-buy {
	background-color: #02aaf1;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	width: 100%;
	height: 30px;
	border-radius: 5px;
	font-size: 16px;
}

.new-btn-login-sl {
	padding: 1px;
	width: 40%;
}

.new-dd-sl {
	padding: 1px;
	display: inline-block;
	float: left; 
	width: 40%;
}
.new-btn-select {
	background-color: #02aaf1;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	width: 100px;
	height: 30px;
	border-radius: 5px;
	font-size: 16px;
	float: right; 
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="am-header">
	 <dl>
	 <dd class="head-select">
	 	<form action="get_goods_by_pageKeywords.action" method="post">
				<input type="hidden" name="seller_username" value="${seller_username}">
				<input type="text" name="keywords" 
					value="搜索店内" onfocus="if (value =='搜索店内'){value =''}"onblur="if (value ==''){value='搜索店内'}"	style="width: 400px;height: 25px;"/>
				<span class="new-btn-login-sl">
					<button class="new-btn-select" type="submit" style="text-align: center;">搜索</button>
				</span>
		</form>
	 </dd>
	 </dl>
	 <dl>
		 <dd class="head-dd"><a href="user_seeshoppingcart.action">查看购物车</a></dd>
		 <dd class="head-dd"><a href="user_loginsuccess.action">返回首页</a></dd>
		 <dd class="head-dd"><a href="get_goods_by_page.action?seller_username=${seller_username}">商店首页</a>
	 </dl>
</div>

<div style="border: solid 1px;width: 1300px;margin-left: 100px">
		
		<s:iterator value="goods" var="singlegoods">
		<div class="first-div">
			<div class="showSingleGoods" style="border: solid 1px;">
				<div class="show">
				<img style="width: 100px;height: 100px"
					alt="图片丢失" onerror="this.src='image/web_image/goodsnoImg.jpg'" 
					src="<s:property value="'image/'+seller_username+'_shop/'+#singlegoods.goods_id+'.png'"/>"/>
				</div>
				<div style="width: 200px;height:200px;">
				<dl class="content">
					<dt >商品名称</dt>
					<dd ><s:property value="#singlegoods.goods_name" /></dd>
					<dt >商品信息</dt>
					<dd ><s:property value="#singlegoods.goods_info" /></dd>
					<dt >商品库存</dt>
					<dd ><s:property value="#singlegoods.goods_num" /></dd>
					<dt >商品分类</dt>
					<dd ><s:property value="#singlegoods.goods_type" /></dd>
					<dt >商品单价</dt>
					<dd style="font-size: 20px"><s:property value="#singlegoods.goods_price" />￥</dd>
					<dt >商品打折</dt>
					<dd ><s:property value="#singlegoods.goods_discount" />%</dd>
					<dt >折后价格</dt>
					<dd style="font-size: 20px">${singlegoods.goods_price-(singlegoods.goods_price*singlegoods.goods_discount/100)}￥</dd>
				</dl>
				</div>
				<div style="">
				<dl style="margin-top: 40px">
					<form action="user_addshoppingcart.action" method="post">
						<input type="hidden" name="goods_id" value="${singlegoods.goods_id}">
						<input type="hidden" name="goods_name" value="${singlegoods.goods_name}">
						<input type="hidden" name="goods_price" value="${singlegoods.goods_price}">
						<input type="hidden" name="goods_discount" value="${singlegoods.goods_discount}">
						<input type="text" name="goods_num" 
						value="1" onfocus="if (value =='1'){value =''}"onblur="if (value ==''){value='1'}"	style="width: 50px;"/>
						<span class="new-btn-login-sp">
							<button class="new-btn-buy" type="submit" style="text-align: center;">加入购物车</button>
						</span>
					</form>
				</dl>
				</div>
			</div>
		</div>
		</s:iterator>
		
		<div id="foot">
			<dl >
			<dd class="foot-dd"><a href="${url}?pageNum=1">首页</a><dd>
			<dd class="foot-dd"><a href="${url}?pageNum=${pageNum-1}">上一页</a><dd>
			<s:iterator var="counter" begin="1" end="%{totalPage}" status="a">
           		<dd class="foot-dd"><a href="${url}?pageNum=${counter}">${counter}</a><dd>
        	</s:iterator>
        	<dd class="foot-dd"><a href="${url}?pageNum=${pageNum+1}">下一页</a><dd>
        	<dd class="foot-dd"><a href="${url}?pageNum=${totalPage}">尾页</a><dd>
        	</dl>
		</div>
		<%-- 
		<div id="foot">
			<dl >
			<dd class="foot-dd"><a href="get_goods_by_page.action?pageNum=1">首页</a><dd>
			<dd class="foot-dd"><a href="get_goods_by_page.action?pageNum=${pageNum-1}">上一页</a><dd>
			<s:iterator var="counter" begin="1" end="%{totalPage}" status="a">
           		<dd class="foot-dd"><a href="get_goods_by_page.action?pageNum=${counter}">${counter}</a><dd>
        	</s:iterator>
        	<dd class="foot-dd"><a href="get_goods_by_page.action?pageNum=${pageNum+1}">下一页</a><dd>
        	<dd class="foot-dd"><a href="get_goods_by_page.action?pageNum=${totalPage}">尾页</a><dd>
        	</dl>
		</div>
		--%>
	</div>
<table>
	<!-- 广告table -->	
</table>

</body>
</html>