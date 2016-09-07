/**
 * 背景滚动函数
 */
//背景滚动
	var showImage = document.getElementById("header");
	var image = document.createElement("img");
	//图片存放的位置
	var imagePath = ["banner.jpg","banner-2.jpg","banner-3.jpg"];
	//播放的计数器
	var i=0;
	function showing()
	{
		image.src = "images/"+imagePath[i];
		image.style.width="1200px";
		image.style.height="500px"; 
		showImage.appendChild(image);
		i++;
		if(i>2)
			i=0;
	}
	window.setInterval(showing,2000);