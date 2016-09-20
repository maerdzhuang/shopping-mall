/**
 * XMLHttpRequest的响应函数
 */
/*var request = null;*/
function callbackFunc() {
	if (request.readyState == 4) {
		if (request.status == 200) {
			var doc = request.responseXML;
			// 获得分页参数信息
			var pageNum = doc.getElementsByTagName("pageNum")[0].innerHTML;
			var maxPage = doc.getElementsByTagName("maxPage")[0].innerHTML;
			var nextPage = doc.getElementsByTagName("nextPage")[0].innerHTML;
			var prePage = doc.getElementsByTagName("prePage")[0].innerHTML;
			/* 本页的商品量 */
			var item = doc.getElementsByTagName("Item");
			var innerHTML = "";
			/*//生成一个分页表格
			innerHTML += "<table id=\"itemsInfo\" >";
			// 表格头
			innerHTML += "<caption>商品信息表</caption><tr>" + "<th>商品编号</th>"
					+ "<th>商品名称</th>" + "<th>商品价格</th>" + "<th>商品图片</th>"
					+ "</tr>";*/
			if (item != null && item.length > 0) {
				for (var i = 0; i < item.length; i++) {
					var it = item[i];
					var id = doc.getElementsByTagName("id")[i].innerHTML;
					var name = doc.getElementsByTagName("name")[i].innerHTML;
					var price = doc.getElementsByTagName("price")[i].innerHTML;
					var image = doc.getElementsByTagName("image")[i].innerHTML;
					innerHTML += "<tr>";
					innerHTML += "<td>" + id + "</td>";
					innerHTML += "<td ondblclick=\"edit()\">" + name + "</td>";
					innerHTML += "<td ondblclick=\"edit()\">" + price + "</td>";
					innerHTML += "<td ondblclick=\"edit()\">" + image + "</td>";
					innerHTML += "<td>"+"<img src='images/"+image+"' width=20% height=auto>" + "</td>";
					innerHTML += "<td><a href='RemoveItem?id="+id+"'>删除</a></td>";
					innerHTML += "</tr>";
				}
				// 跳转页数实现
				innerHTML += "<tr>";
				innerHTML += "<td colspan='6' style=\"text-align:center;\">";

				innerHTML += "[" + pageNum + "/" + maxPage + "]&nbsp;&nbsp;";
				innerHTML += "<a href=\"javascript:void(0)\" onClick=\"getData(1)\">[首 页]</a> ";
				innerHTML += "<a href=\"javascript:void(0)\" onClick=\"getData("
						+ prePage + ")\">[上一页]</a> ";

				/*
				 * 添加页面的search功能，还未完善
				 * innerHTML += "<input type=\"number\" step=\"1\"
				 * id=\"search\" +"onChange=\"getData()\">";
				 */
				innerHTML += "<a href=\"javascript:void(0)\" onClick=\"getData("
						+ nextPage + ")\">[下一页]</a> ";
				innerHTML += "<a href=\"javascript:void(0)\" onClick=\"getData("
						+ maxPage + ")\">[尾页]</a>";

				innerHTML += "</td>"
				innerHTML += "</tr>"
			/*	innerHTML += "</table>"*/
			} else {
				innerHTML += "暂时没有任何数据";
			}
			//将动态生成的表格添加到show的div标签中
			document.getElementById("content").innerHTML = innerHTML;
			//必须将request（XMLHttpRequest对象）重新设为初始状态，才不会影响下一次调用
			//request=null; 目前测试还没有必要
		}

	}
}