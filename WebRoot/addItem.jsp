<!-- 添加商品的界面 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

  </head>
  
  <body>
  <h1>添加商品</h1>
  <hr/>
  <form action="AddItem" method="post">
  	商品名称: <input type="text" name="name" 
  	placeholder="必填" request/><br><br>
  	商品价格:	<input type="number" name="price" step="0.1" 
  	placeholder="必填，必须是数字" request/><br><br>
  	<!-- 利用正则表达式进行匹配pattern="^\d+\.((jpg)|(bmp))" -->
  	<!-- 商品图片: <input type="text" name="image" pattern="^\d+\.((jpg)|(bmp))" 
  	placeholder="格式:数字(.jpg或.bmp)"request/><br><br> -->
  	商品图片: <input type="file" name="image" accept="image/*" 
  	request/><br><br> 
  <input type="submit" value="提交"/>
  </form>
  </body>
</html>
