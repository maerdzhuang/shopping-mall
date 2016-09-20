<!-- 添加商品的界面 -->
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" errorPage="error.jsp"%>
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

<title>添加商品信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="css/table.css">
</head>

<body>
	<div id="nav">
		<jsp:include page="header02.jsp" />
	</div>
	<div id="content">
		<form action="AddItem" method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>商品图片</th>
				<tr>
				<tr>
					<td><input type="text" name="name" placeholder="必填" request
						autofocus="on" /></td>
					<td><input type="number" name="price" step="0.1"
						placeholder="必填，必须是数字" request /></td>
					<td><input type="file" name="image" accept="image/*" request /></td>
				</tr>
				<tr>
					<td colspan='3'><input type="submit" value="提交" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
