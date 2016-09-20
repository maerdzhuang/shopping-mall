<!-- 页面的头部信息 -->
<%@page import="java.net.URLEncoder"%>
<!-- contentType是服务器端发送给客户端的内容编码，相当于response.setContentType() -->
<!-- pageEncoding告诉jsp引擎jsp文件保存时的编码 -->
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'header.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />


</head>

<body>
	<div>
	<%
		String welcome = (String)request.getSession().getAttribute("welcome"); 
		if(welcome!=null){
	%>
		<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=welcome%></h5>
	<%}else{ %>
	<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="userLogin.jsp">请先登录</a></h5>
	<%} %>
	</div>
	<!--top-header-->
	<div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-4 top-header-left">
					<div class="search-bar">
						<form action="SearchServlet" method='post'>
							<input type="text" value="Search" name="key" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Search';}">
							<input type="submit" value="">
						</form>
					</div>
				</div>
				<div class="col-md-4 top-header-middle">
					<a href="index.jsp"><img src="images/logo-4.png" alt="" /></a>
				</div>
				<div class="col-md-4 top-header-right">
					<div class="cart box_1">
						<a href="Cart.jsp">
							<h3>
								<div class="total">
									<span class="simpleCart_total"></span>(<span
										id="simpleCart_quantity" class="simpleCart_quantity"></span>
									查看购物车)
								</div>
								<img src="images/cart-1.png" alt="" />
							</h3>
						</a>
						<p>
							<a href="javascript:void(0)" class="simpleCart_empty" onclick='removeAll("removeall")'>清空购物车</a>
						</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--top-header-->
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="top-nav">
				<ul class="memenu skyblue">
					<li class="active"><a href="index.jsp">首页</a></li>
					<li class="grid"><a href="SearchServlet?key=<%=URLEncoder.encode("足球", "utf-8") %>">足球鞋</a></li>
					<li class="grid"><a href="SearchServlet?key=<%=URLEncoder.encode("运动", "utf-8") %>">运动鞋</a></li>
					<li class="grid"><a href="SearchServlet?key=<%=URLEncoder.encode("篮球", "utf-8") %>">篮球鞋</a></li>
					<li class="grid"><a href="SearchServlet?key=<%=URLEncoder.encode("时尚", "utf-8") %>">时尚新品</a></li>
					<li class="grid"><a href="login.jsp">后台登录</a></li>
				</ul>
			</div>
		</div>
	</div>
	<hr/>
	<!--bottom-header-->
	
	<!-- 获得XMLHttpRequest对象 -->
	<script type="text/javascript" src="js/request.js"></script>
	<script type="text/javascript">
	//处理清空购物车请求的js
	//action表示所有处理的请求类型
	function removeAll(action)
	{
		var url = "CartServlet";
		var parameter = "action="+action;
		if(confirm("是否确定清空购物车?"))
		{
			request05 = httpRequest("post", url, true, callbackFunc05, parameter);
		}
	}
	function callbackFunc05()
	{
		if (request05.readyState == 4) 
		{
			if(request05.status == 200)
			{
				var str = request05.responseText;
				alert(str);
			}
		}
	}
	var key = document.getElementById("")
</script>
	
  </body>
</html>
