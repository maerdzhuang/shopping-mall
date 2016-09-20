<!-- 显示购物车内的商品 -->
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page
	import="com.zxj.servlet.*,com.zxj.entity.*,java.util.Map.Entry;"%>
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

<title>购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 表格的样式控制-->
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
	<div id="nav">
		<jsp:include page="header.jsp" />
	</div>
	<div id="content">
		<!-- 获得所有商品的集合 -->
		<%
			Cart myCart = (Cart) request.getSession().getAttribute("myCart");
			if (myCart != null) {
		%>
		<table id="showItems">
			<caption>购物清单</caption>
			<tr>
				<th>商品图片</th>
				<th>商品名称</th>
				<th>商品单价</th>
				<th>购买数量</th>
				<th>setting</th>
			</tr>
			<%
				HashMap<Item, Integer> goods = myCart.getGoods();
					// 返回一个键值对set集合
					Set<Entry<Item, Integer>> items = goods.entrySet();
					// 增强的for循环
					for (Entry<Item, Integer> item : items) {
						Item it = item.getKey();
						int num = item.getValue();
			%>

			<tr id="it.getId()">
				<td><a href='detail02.jsp?id=<%=it.getId()%>' target="_blank"><img
						src="images/<%=it.getImage()%>" width=20% height=autowidth=20%
						height=auto /></a></td>
				<td><a href='detail02.jsp?id=<%=it.getId()%>' target="_blank"><%=it.getName()%></a></td>
				<td><%=it.getPrice()%></td>
				<td><%=num%></td>
				<td><a href="javascirpt:void(0)"
					onclick='remove("removeGood",<%=it.getId()%>)'>删除</a></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="5" style="text-align:right;">总计:$<%=myCart.totalValue()%></td>
			</tr>
			<%
				}
					else{
			%>
			<div>
				<h1>购物车为空</h1>
			</div>
			<%
				}
			%>
		</table>
	</div>
	<!-- 获得XMLHttpRequest对象 -->
	<script type="text/javascript" src="js/request.js"></script>
	<script type="text/javascript">
	//处理删除商品的购物车请求的js
	//action表示所有处理的请求类型
	//id便是商品的编号
	function remove(action,id)
	{
		var url = "CartServlet";
		var parameter = "id="+id+"&action="+action;
		if(confirm("是否确定要删除此商品"))
			request04 = httpRequest("post", url, true, callbackFunc04, parameter);
	}
	function callbackFunc04()
	{
		if (request04.readyState == 4) 
		{
			if(request04.status == 200)
			{
				var str = request04.responseText;
				alert(str);
			}
		}
	}
</script>

</body>
</html>
