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
		margin:50px 0 0 50px;
		box-shadow:5px 5px 3px rgba(0,0,255,0.2);
		width:260px;
		height:auto;
		background:white;
	}
	dl>#image:hover {
		transform:scale(1.5,1.5) rotate(15deg);
	}
	</style>
</head>

<body style="padding:0 auto;background:rgba(0,125,125,0.2);">
	<h2>商品展示&nbsp&nbsp<a href="login.jsp">后台登录</a></h2>
	<hr>
	<!-- 头部背景 -->
	<jsp:include page="slideImage.jsp"></jsp:include>
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
			<dt id="image">
				<a href="detail.jsp?id=<%=it.getId()%>"><img src="images/<%=it.getImage()%>"
					width="250px" height="300px" alt="图片丢失"></a>
			</dt>
			<dt style="word-break:keep_all">
				编号:<%=it.getId()%>&nbsp;<%=it.getName()%>&nbsp;$<%=it.getPrice()%></dt>
		</dl>
	</div>

	<%	}
   } %>
</body>
</html>
