<%@ page language="java" import="java.util.*,java.net.*"
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

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		String vname = "";
		String vpass = "";
		//获得cookie
		Cookie[] cookies = request.getCookies();
		//如果获得cookie数组不为空
		if (cookies != null && cookies.length > 0) {
			for (Cookie co : cookies) {
				//当cookie为保存用户名和密码的cookie时，使其失效
				if (co.getName().equals("username"))
					//由于中文不能保存在cookie中，所以需要设置字符集解码
					vname = URLDecoder.decode(co.getValue(), "utf-8");
				else if (co.getName().equals("password"))
					//由于中文不能保存在cookie中，所以需要设置字符集解码
					vpass = URLDecoder.decode(co.getValue(), "utf-8");
			}

		}
	%>
	<h1>登陆界面</h1>
	<hr>
	<form action="DoUser" method="post">
		姓名:&nbsp;<input type="text" name="username" id="username"
			value="<%=vname%>" autofocus="on" /><br> <br> 密码:&nbsp;<input
			type="password" name="password" id="password" value="<%=vpass%>" /><br>
		<br> <input type="checkbox" name="isUseCookie" value="是否自动登录" />下次是否自动登录
		&nbsp;&nbsp; <input type="submit" value="登陆" /> <br>
	</form>
	<!-- <a href="admin/register.jsp">注册</a> -->
</body>
</html>
