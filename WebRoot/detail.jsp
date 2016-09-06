<!-- 所有商品的详情页 -->
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="com.zxj.entity.Item,com.zxj.dao02.ItemDao"%>
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

<title>具体信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#showDetail {
	border:2px solid black;
	border-radius:5px;
	position: absolute;
	left: 35%;
	top: 15%;
	box-shadow: 15px 15px 6px rgba(0, 0, 255, 0.2);
}

#history {
	box-shadow: 3px 3px 3px rgba(0, 0, 255, 0.2);
	width: 140px;
	height: 160px;
	padding: 1px;
	margin: 20px 0 0 30px;
}

#history>dl:hover {
	transform: scale(1.2, 1.2);
}
</style>

</head>
<body style="padding:0 auto;">
	<%
		//存储用户浏览记录
		StringBuilder str = new StringBuilder();
		Cookie[] cookies = request.getCookies();
		//s为浏览记录
		String s = "";
		if (cookies != null && cookies.length > 0) {
			for (Cookie co : cookies) {
				//判断是否存在“浏览商品”的cookie
				if (co.getName().equals("listItem")) {
					s = co.getValue() + ",";

					/* 	out.println("s:"+s+"<br>");
						out.println("re:"+request.getParameter("id")+"<br>");
					 */
					String[] arr = s.split(",");
					//cookie保存5条的浏览记录
					if (arr.length > 5) {
						String[] arr02 = s.split(",", 2);
						s = arr02[1];
					}
					str.append(s);
				}
			}
		}
		str.append(request.getParameter("id"));

		Cookie cookie = new Cookie("listItem", str.toString());
		//out.println("str:"+str.toString()+"<br>");
		response.addCookie(cookie);
	%>


	<h1>商品详情</h1>
	<hr>
	<%
		//获取商品的id
		Item ite = null;
		int id = Integer.parseInt(request.getParameter("id"));
		ItemDao itd = new ItemDao();
		ite = itd.getItemById(id);
		if (ite != null) {
	%>
	<div id="showDetail">
		<dl>
			<dt>
				<img src="images/<%=ite.getImage()%>" width="400px" height="500px">
			</dt>
			<br>
			<dd>
				编号:<%=ite.getId()%>&nbsp;<%=ite.getName()%>&nbsp;$<%=ite.getPrice()%>
			<dd>
		</dl>
	</div>
	<%
		}
	%>

	<h3>&nbsp;&nbsp;&nbsp;浏览记录</h3>
	<%
		ItemDao itds = new ItemDao();
		ArrayList<Item> items = itds.getCookie(s);
		if (items != null && items.size() > 0) {
			for (Item it : items) {
	%>

	<div id="history">
		<dl>
			<dt>
				<a href="detail.jsp?id=<%=it.getId()%>" target="_blank"><img
					src="images/<%=it.getImage()%>" width="75px" height="100px"></a>
			</dt>
			<dt>
				编号:<%=it.getId()%>&nbsp;<%=it.getName()%>&nbsp;$<%=it.getPrice()%>
			</dt>
		</dl>
	</div>

	<%
		}
	}
	%>


</body>
</html>
