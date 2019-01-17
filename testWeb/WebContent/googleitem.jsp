  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*, test.WebPage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜尋結果</title>
</head>
<style type="text/css">

#container{


background: linear-gradient(45deg, rgba(217, 139, 90, 1)44%, rgba(235, 220, 70, 0.8)60%); 
background: -moz-linear-gradient(45deg, rgba(217, 139, 90, 1)44%, rgba(235, 220, 70, 0.8)60%); 
background: -webkit-linear-gradient(45deg, rgba(217, 139, 90, 1)44%, rgba(235, 220, 70, 0.8)60%); 
background: -o-linear-gradient(45deg, rgba(217, 139, 90, 1)44%, rgba(235, 220, 70, 0.8)60%); 
}
</style>
<div id="container">
<body>
<%
ArrayList<WebPage> list = (ArrayList<WebPage>)  request.getAttribute("query");

for(int i =0 ; i < list.size();i++){
	WebPage a = list.get(i);
%>
	<a href='<%= a.url %>'><%= a.name %></a><br><h style="font-size:5px ;"><%= a.url %></h><br><br>
<%
}
%>
</body>
</html>