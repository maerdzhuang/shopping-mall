<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="com.zxj.dao02.*,com.zxj.entity.*"%>
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

<title>修改商品信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<!-- 表格的样式控制 -->
<style type="text/css">
#showItems {
	border: 2px solid black;
}

th, td {
	border: 1px solid black;
}
</style>
</head>

<body>
	<!-- 获得所有商品的集合 -->
	<%
		ItemDao itd = new ItemDao();
		ArrayList<Item> list = itd.getAllitems();
	%>

	<h1>修改商品信息</h1>
	<hr>
	<table id="showItems" ondblclick="edit()">
		<caption>商品信息表</caption>
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品图片路径</th>
		</tr>
		<%
			for (Item it : list) {
		%>
		<tr>
			<td><%=it.getId()%></td>
			<td><%=it.getName()%></td>
			<td><%=it.getPrice()%></td>
			<td><%=it.getImage()%></td>
		</tr>
		<%
			}
		%>
	</table>

	<!-- 导入外部js文件，通过双击修改表格内的内容 -->
	<script src="js/changeCell.js" type="text/javascript">
	</script>
</body>
</html>
