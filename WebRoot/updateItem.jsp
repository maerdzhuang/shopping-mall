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
	<!-- <div id="response"></div>

	获取XMLHttpRequest对象的js函数
	<script type="text/javascript" src="js/request.js"></script>
	获取行数和列数的js函数
	<script type="text/javascript" src="js/RowAndCol.js"></script>
	<script type="text/javascript">
		/* 创建文本框，接送输入的修改信息 */
		var textChange = document.createElement("input");
		textChange.style = "text";
		/* 当前双击的表格单元 */
		var curCell;
		function edit(event) {
			if (event == null)
				curCell = window.event.srcElement;
			else
				curCell = event.target;
			//获取单元格所在的父节点，通过父节点获得其第一个子节点，即商品的id	
			var tr = curCell.parentNode;
			var id = tr.firstChild.nextSibling.innerHTML;
			//获得单元格所在的行和列
			var row = getRow(curCell);
			var col = getCol(curCell);
			var oldhtml = curCell.innerHTML;
			var newobj = document.createElement('input');
			//创建新的input元素
			newobj.type = 'text';
			//为新增元素添加类型
			newobj.onblur = function() {
				//当触发时判断新增元素值是否为空，为空则不修改，并返回原有值 
				curCell.innerHTML = this.value ? this.value : oldhtml;
				//字符集编码,否则中文显示不出来
				var str =curCell.innerHTML; 
				var parameter = "id=" + id + "&row="+row+"&col=" + col + "&value="
						+ str;
				request = httpRequest("POst", "UpdateItems", true, callbackFunc,
						parameter);
				console.log(parameter);
			}
			curCell.innerHTML = '';
			curCell.appendChild(newobj);
			newobj.focus();
		}
		//响应函数
		function callbackFunc() {
			if (request.readyState == 4) {
				var div = document.getElementById("response");
				if (request.status == 200) {
					var str = request.responseText;
					div.innerHTML = str;
				} else {
					div.innerHTML = "暂时还没有数据";
				}
			}
		}
	</script>

	<script type="text/javascript">
		var tds = document.getElementsByTagName("td");
		for ( var index in tds)
		{
			//id是唯一标识，不允许改变,所以不必为其添加edit事件
			if(!(tds[index].id=="itemID"))
				tds[index].ondblclick = edit;
		}
	</script> -->
</body>
</html>
