<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>圖片搜尋</title>
</head>
<style type="text/css">

#container{

background: linear-gradient(51deg, rgba(132, 192, 185, 0.8)35%, rgba(242, 225, 102, 0.7)64%); 
background: -moz-linear-gradient(51deg, rgba(132, 192, 185, 0.8)35%, rgba(242, 225, 102, 0.7)64%); 
background: -webkit-linear-gradient(51deg, rgba(132, 192, 185, 0.8)35%, rgba(242, 225, 102, 0.7)64%); 
background: -o-linear-gradient(51deg, rgba(132, 192, 185, 0.8)35%, rgba(242, 225, 102, 0.7)64%); 
}

</style>
<body>
 <div id="container">
 <div id="sitebody">
<CENTER><div id="header">現在是:<%=(new java.util.Date()).toLocaleString()%></div>			
		</div>
<CENTER><form action='${requestUri}' method='get'>
<CENTER><input type='text' name='keyword' placeholder = 'keyword'/>
<CENTER><input type='submit' value='submit' />
</form>
<div style="padding:5px;text-align:center;"><img src="https://imgur.dcard.tw/forB6Kw.jpg" width="300" height="400"></div>
<div style="padding:5px;text-align:center;"><img src="https://imgur.dcard.tw/rk64Qjp.jpg" width="300" height="400"></div>
<div style="padding:5px;text-align:center;"><img src="https://imgur.dcard.tw/U8pozsl.jpg" width="300" height="400"></div>

<div style="padding:5px;text-align:center;"><img src="https://imgur.dcard.tw/TB8DjzR.jpg" width="300" height="400"></div>
<NOBR><div style="padding:5px;text-align:center;"><img src="http://pic.pimg.tw/belleaya/1374318952-4156557780.jpg" width="300" height="400"></div>

<BR>
<embed src="https://picosong.com/wuwUR" autostart="true" loop="1" volume="100" width="100" height=100></embed>
</body>
</html>