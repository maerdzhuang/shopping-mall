<!-- 显示所有商品信息，只读文档，不可以修改-->
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="com.zxj.dao02.*,com.zxj.entity.*,java.net.*"%>
<%@ page import="java.net.*"%>
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

<title>所有商品信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- 表格的样式控制 -->
<link rel="stylesheet" type="text/css" href="css/table.css">
<body>
	<div id="nav">
		<jsp:include page="header02.jsp" />
	</div>
	<div id="content">
		<!-- 获得所有商品的集合 -->
		<%
			ItemDao itd = new ItemDao();
			ArrayList<Item> list = itd.getAllitems();
		%>

		<!-- <h1>修改商品信息</h1>
	<hr> -->
		<table id="showItems">
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
				<td id="itemID"><%=it.getId()%></td>
				<td><%=it.getName()%></td>
				<td><%=it.getPrice()%></td>
				<td><%=it.getImage()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>
