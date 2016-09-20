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

<title>商品信息表</title>

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
	<jsp:include page="header02.jsp"/>
	</div>
	<div id="show">
		<table>
			<caption>商品信息表</caption>
			<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>商品图片路径</th>
				<th>商品图片</th>
				<th>删除商品</th>
			</tr>
			</thead>
			<tbody id="content">
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" id="response"></td>
				</tr>
			</tfoot>
		</table>
	</div>

	<!-- 获取XMLHttpRequest对象的函数引用 -->
	<script src="js/request.js" type="text/javascript"></script>
	<!-- 获取单元格的行号和列号 -->
	<script src="js/RowAndCol.js" type="text/javascript"></script>
	<!--  @param resFun :响应的回调函数 callbackFunc02-->
	<script src="js/resFun02.js" type="text/javascript"></script>
	<!-- 导入外部js文件，通过双击修改表格内的内容 -->
	<script src="js/changeCell.js" type="text/javascript"></script>
	<!-- @param resFun :响应的回调函数 callbackFunc -->
	<script src="js/resFun.js" type="text/javascript"></script>
	<script type="text/javascript">
		var request = null;
		/*
		 * 返回XMLHttpRequest对象
		 * @param reqType:请求类型 post
		 * @param url:服务器地址 GoodsServlet
		 * @param async:是否异步请求 true
		 * @param resFun :响应的回调函数 callbackFunc
		 * @param parameter:请求参数 param="page="+page+"&nocache="+new Date.getTime();
		 * @returns XMLHttpRequest对象
		 */
		function getData(page) {
			var url = "GoodsServlet"; //服务器地址
			var param = "page=" + page;
			request = httpRequest("post", url, true, callbackFunc, param);
		}
		getData(1);
	</script>
</body>
</html>
