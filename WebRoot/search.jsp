<!-- 显示搜索结果的界面 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zxj.entity.Item,com.zxj.dao02.ItemDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	div#singleItem{
		float:left;
		/* 外补丁*/
		margin:50px 0 0 60px;
		box-shadow:10px 10px 50px grey;
		border-radius:25px;
		/* outline:rgba(128,64,0,0.8) ridge 16px; */
		width:260px;
		height:auto;
		background:white;
		font: 16px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
		text-align: center;
		background:rgba(0,189,255,0.2);
	}
	dl>#font{
		word-break:keep_all;
	}
	dl>#image:hover {
		transform:scale(1.5,1.5) rotate(15deg);
	}
	</style>
  </head>
  
  <body>
  <div id="nav">
	<jsp:include page="header.jsp"></jsp:include>
  </div>
  <div id="content">
	<%
  	ItemDao itd = new ItemDao();
  	ArrayList<Item> items = (ArrayList<Item>)request.getSession().getAttribute("result");
  	if(items!=null&&items.size()>0)
  	{
	  	for(Item it:items)
	  	{
   %>

	<div id="SingleItem">
		<dl>
			<dt id="image">
				<a href="detail02.jsp?id=<%=it.getId()%>"><img src="images/<%=it.getImage()%>"
					width="250px" height="300px" alt="图片丢失"></a>
			</dt>
			<dt id="font">
				编号:<%=it.getId()%>&nbsp;<%=it.getName()%>&nbsp;$<%=it.getPrice()%>
			</dt>
		</dl>
	</div>

	<%	}
   }
   else{
    %>
    <h1>无相关搜索信息！</h1>
    <%
    }
     %>
   </div>
  </body>
</html>
