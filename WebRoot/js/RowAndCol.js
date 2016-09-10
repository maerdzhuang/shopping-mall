/**
 * 获取一个表格中的单元格所在的行和列号
 */
//target表示所在的单元格
//获得行
function getRow(target)
{
	//获得父节点tr
	var tr = target.parentNode;
	//获得所有tr节点
	var trs = document.getElementsByTagName("tr");
	var row = 0;
	for(var i=1;i<=trs.length;i++)
	{
		if(tr==trs[i-1])
		{
			row=i;
			break;
		}
			
	}
	return row;
}
//获得列,健壮性有待提高！！！！！！！！！
function getCol(target)
{
	var tr = target.parentNode;
	var tds = tr.childNodes;
	var col = 0;
	for(var j=1;j<=tds.length;j++)
	{
		if(target==tds[j-1])
		{
			col=j;
			break;
		}
	}
	return col;
}