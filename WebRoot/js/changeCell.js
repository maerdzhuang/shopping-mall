/**
 * 双击改变单元格内容以及实时更新数据库的item函数
 */

		/* 创建文本框，接送输入的修改信息 */
		var textChange = document.createElement("input");
		textChange.style = "text";
		/* 当前双击的表格单元 */
		var curCell;
		/* 当前双击的表格单元 */
		var curCell;
		function edit(event) {
			if (event == null)
				curCell = window.event.srcElement;
			else
				curCell = event.target;
			//获取单元格所在的父节点，通过父节点获得其第一个子节点，即商品的id	
			var tr = curCell.parentNode;
			var id = tr.firstChild.innerHTML;
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
				request02 = httpRequest("post", "UpdateItems", true, callbackFunc02,
						parameter);
				console.log(parameter);
			}
			curCell.innerHTML = '';
			curCell.appendChild(newobj);
			newobj.focus();
		}
	