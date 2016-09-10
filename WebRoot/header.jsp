<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />


</head>

<body>
	<!--top-header-->
	<div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-4 top-header-left">
					<div class="search-bar">
						<input type="text" value="Search" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Search';}">
						<input type="submit" value="">
					</div>
				</div>
				<div class="col-md-4 top-header-middle">
					<a href="index.jsp"><img src="images/logo-4.png" alt="" /></a>
				</div>
				<div class="col-md-4 top-header-right">
					<div class="cart box_1">
						<a href="#">
							<h3>
								<div class="total">
									<span class="simpleCart_total"></span>(<span
										id="simpleCart_quantity" class="simpleCart_quantity"></span>
									items)
								</div>
								<img src="images/cart-1.png" alt="" />
							</h3>
						</a>
						<p>
							<a href="#" class="simpleCart_empty">Empty Cart</a>
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
					<li class="grid"><a href="#">Sports</a></li>
					<li class="grid"><a href="#">Brands</a></li>
					<li class="grid"><a href="login.jsp">后台登录</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--bottom-header-->
  </body>
</html>
