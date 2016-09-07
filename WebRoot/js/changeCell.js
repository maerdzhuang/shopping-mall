/**
 * 双击改变单元格内容的函数
 */

		/* 创建文本框，接送输入的修改信息 */
		var textChange = document.createElement("input");
		textChange.style = "text";
		/* 当前双击的表格单元 */
		var curCell;
		function edit(event)
		{
			if(event==null)
				curCell = window.event.srcElement;
			else
				curCell = event.target;
				
			var oldhtml = curCell.innerHTML;
			var newobj = document.createElement('input');
			//创建新的input元素
			newobj.type = 'text';
			//为新增元素添加类型
			newobj.onblur = function() {
				curCell.innerHTML = this.value ? this.value : oldhtml;
				//当触发时判断新增元素值是否为空，为空则不修改，并返回原有值 
			}
			curCell.innerHTML = '';
			curCell.appendChild(newobj);
			newobj.focus();
		}