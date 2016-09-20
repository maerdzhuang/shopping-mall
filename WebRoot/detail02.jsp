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

<title>商品详情</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />



</head>

<body>
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
			//cookie保存6条的浏览记录
			if (arr.length > 6) {
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
	<div id="nav">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<hr style="color:red;" />
	<!--start-single-->
	<div class="single contact">
		<div class="container">
			<div class="single-main">
				<div class="col-md-9 single-main-left">
					<div class="sngl-top">
						<div class="col-md-5 single-top-left">
							<!--商品图片展示区-->
							<div class="flexslider">
								<%
									//获取商品的id
																					Item ite = null;
																					int id = Integer.parseInt(request.getParameter("id"));
																					ItemDao itd = new ItemDao();
																					ite = itd.getItemById(id);
																					if (ite != null) {
								%>
								<img src="images/<%=ite.getImage()%>" />
							</div>
							<!--商品图片展示区结束-->
						</div>
						<!--商品描述信息-->
						<div class="col-md-7 single-top-right">
							<div class="details-left-info simpleCart_shelfItem">
								<h3><%=ite.getName()%></h3>
								<div class="price_single">
									<span class="reducedfrom">$800.00</span> <span
										class="actual item_price">$<%=ite.getPrice()%></span>
								</div>
								<ul class="product-colors">
									<h3>颜色</h3>
									<li><a class="color1" href="#"><span> </span></a></li>
									<li><a class="color2" href="#"><span> </span></a></li>
									<li><a class="color3" href="#"><span> </span></a></li>
									<li><a class="color4" href="#"><span> </span></a></li>
									<li><a class="color5" href="#"><span> </span></a></li>
									<li><a class="color6" href="#"><span> </span></a></li>
									<li><a class="color7" href="#"><span> </span></a></li>
									<li><a class="color8" href="#"><span> </span></a></li>
									<div class="clear"></div>
								</ul>
								<ul class="size">
									<h3>尺码</h3>
									<li><a href="#">40</a></li>
									<li><a href="#">41</a></li>
								</ul>
								<div class="quantity_box">
									<!-- 表示商品的购买的件数 -->
									<input type="number" min='1' step='1' id="num" value='1' />
								</div>
								<div class="clearfix"></div>
								<div class="single-but item_add">
									<a href="javascript:void(0)"
										onclick='submit("addGood",<%=ite.getId()%>)'>加入购物车</a> <a
										href="javascript:void(0)">立即购买</a>
								</div>
							</div>
						</div>
						<!--商品描述信息结束-->
					</div>
					<%
						}
					%>

					<!--浏览记录-->
					<div class="latest products">
						<div class="product-one">
							<br />
							<h3></h3>
							<h3>浏览记录</h3>
							<%
								ItemDao itds = new ItemDao();
																		ArrayList<Item> items = itds.getCookie(s);
																		if (items != null && items.size() > 0) {
																			for (Item it : items) {
							%>
							<div class="col-md-4 product-left single-left">
								<div class="p-one simpleCart_shelfItem">
									<a href="detail02.jsp?id=<%=it.getId()%>" target="_blank">
										<img src="images/<%=it.getImage()%>" alt="" />
										<div class="mask mask1">
											<span>Quick View</span>
										</div>
									</a>
									<h4><%=it.getName()%></h4>
									<p>
										<span>$<%=it.getPrice()%></span>
									</p>
								</div>
							</div>
							<%
								}
																		}
							%>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!--浏览记录结束-->
				<!--侧边框-->
				<div class="col-md-3 single-right">
					<h3>鞋类(目前不可用)</h3>
					<ul class="product-categories">
						<li><a href="#">Blucher Shoe</a> <span class="count">(14)</span></li>
						<li><a href="#">Clog Shoe</a> <span class="count">(2)</span></li>
						<li><a href="#">Snow Boot Shoe</a> <span class="count">(2)</span></li>
						<li><a href="#">Galesh Shoe</a> <span class="count">(11)</span></li>
						<li><a href="#">pataugas Shoe</a> <span class="count">(3)</span></li>
						<li><a href="#">Jazz Shoe</a> <span class="count">(3)</span></li>
					</ul>
					<h3>颜色(目前不可用)</h3>
					<ul class="product-categories">
						<li><a href="#">Green</a> <span class="count">(14)</span></li>
						<li><a href="#">Blue</a> <span class="count">(2)</span></li>
						<li><a href="#">Red</a> <span class="count">(2)</span></li>
						<li><a href="#">Gray</a> <span class="count">(8)</span></li>
						<li><a href="#">Green</a> <span class="count">(11)</span></li>
						<li><a href="#">Yellow</a> <span class="count">(2)</span></li>
					</ul>
					<h3>尺寸(目前不可用)</h3>
					<ul class="product-categories">
						<li><a href="#">5.5</a> <span class="count">(14)</span></li>
						<li><a href="#">6</a> <span class="count">(2)</span></li>
						<li><a href="#">6.5</a> <span class="count">(2)</span></li>
						<li><a href="#">7</a> <span class="count">(8)</span></li>
						<li><a href="#">7.5</a> <span class="count">(11)</span></li>
					</ul>
					<h3>价格(目前不可用)</h3>
					<ul class="product-categories p1">
						<li><a href="#">600$-700$</a> <span class="count">(14)</span></li>
						<li><a href="#">700$-800$</a> <span class="count">(2)</span></li>
						<li><a href="#">800$-900$</a> <span class="count">(2)</span></li>
						<li><a href="#">900$-1000$</a> <span class="count">(8)</span></li>
						<li><a href="#">1000$-1100$</a> <span class="count">(11)</span></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- 获得XMLHttpRequest对象 -->
	<script type="text/javascript" src="js/request.js"></script>
	<script type="text/javascript">
	//处理购物车请求的js
	//action表示所有处理的请求类型
	//id便是商品的编号
	function submit(action,id)
	{
		//购买的商品件数
		var num = document.getElementById("num").value;
		var url = "CartServlet";
		var parameter = "id="+id+"&action="+action+"&num="+num;
		request03 = httpRequest("post", url, true, callbackFunc03, parameter);
	}
	function callbackFunc03()
	{
		if (request03.readyState == 4) 
		{
			if(request03.status == 200)
			{
				var str = request03.responseText;
				alert(str);
			}
		}
	}
</script>
</body>
</html>
