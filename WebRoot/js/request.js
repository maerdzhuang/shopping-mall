/**
 * 返回XMLHttpRequest对象
 * @param reqType:请求类型
 * @param url:服务器地址
 * @param async:是否异步请求
 * @param resFun :响应的回调函数
 * @param parameter:请求参数
 * @returns XMLHttpRequest对象
 */
function httpRequest(reqType,url,async,resFun,parameter)
{
	var request=null;
	//创建XMLHttpRequest对象
	if(window.XMLHttpRequest)
	{
		//非IE浏览器
		request = new XMLHttpRequest();
	}
	else{
		//IE浏览器
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	if(request || typeof(request)=="object")
	{
		//以post的方式提交
		if(reqType.toLowerCase()=="post"){
			//打开服务器的连接
			request.open(reqType, url,async);
			//设置MIME类型
			request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//设置处理响应的回调函数
			request.onreadystatechange = resFun;
			//将参数字符串进行编码,防止中文乱码，后台用URLDecoder解码
			parameter = encodeURI(parameter);
			//发送请求
			request.send(parameter);
		}
		//以get方式提交
		else{
			url += "?" + parameter;
			//将参数字符串进行编码,防止中文乱码，后台用URLDecoder解码
			url = encodeURI(url);
			//打开服务器的连接
			request.open(reqType, url, async);
			//设置处理响应的回调函数
			request.onreadystatechange = resFun;
			//发送请求
			request.send(null);
		}
	}
	else{
		alert("该浏览器不支持Ajax!");
	}
	return request;
}