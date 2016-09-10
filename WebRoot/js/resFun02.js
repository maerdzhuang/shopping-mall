/**
 * 这是XMLHttpRequest的响应函数，该XMLHttpRequest是用来实时更新数据库商品表的
 */
	//响应函数,在页面元素中显示更新成功与否
		function callbackFunc02() {
			if (request02.readyState == 4) {
				var div = document.getElementById("response");
				if (request02.status == 200) {
					var str = request02.responseText;
					div.innerHTML = str;
				} else {
					div.innerHTML = "输入错误，无法更新！请重新输入";
				}
			}
		}