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

<title>My JSP 'header02.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/nav.css">
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="index.jsp"><span>首页</span></a></li>
			<li><a href="addItem.jsp"><span>添加商品信息</span></a></li>
			<li><a href="showItems.jsp"><span>修改商品信息</span></a></li>
			<li><a href="updateItem.jsp"><span>显示商品信息</span></a></li>
		</ul>
	</div>
	
</body>
</html>
