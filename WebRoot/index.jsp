<!-- 所有商品的详情页 -->
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="com.zxj.entity.Item,com.zxj.dao02.ItemDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>鞋类</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	div{
		float:left;
		/* 外补丁*/
		margin:50px 50px;
		box-shadow:5px 5px 3px rgba(0,0,255,0.2);
	}
	dl:hover {
		transform:scale(1.5,1.5);
	}
	</style>
</head>

<body style="padding:0 auto;background:rgba(0,125,125,0.2);">
	<h1>商品展示</h1>
	<h2><a href="login.jsp">后台登录</a></h2>
	<hr>

	<%
  	ItemDao itd = new ItemDao();
  	ArrayList<Item> items = itd.getAllitems();
  	if(items!=null&&items.size()>0)
  	{
	  	for(Item it:items)
	  	{
   %>

	<div>
		<dl>
			<dt>
				<a href="detail.jsp?id=<%=it.getId()%>"><img src="images/<%=it.getImage()%>"
					width="200px" height="150px"></a>
			</dt>
			<dt>
				编号:<%=it.getId()%>&nbsp;<%=it.getName()%>&nbsp;$<%=it.getPrice()%></dt>
		</dl>
	</div>

	<%	}
   } %>
</body>
</html>
