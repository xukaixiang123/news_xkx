<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: rgba(0, 0, 0, 0.5);
	background-size: 100% 100%;
}

div {
	width: 50%;
	height: 50%;
    background: #FFF url("images/sucess.jpg") no-repeat 30% 25%;
	position: absolute;
	top: 20%;
	left: 25%;
}
h2{
margin-top:10%;
font-size:18px;
font-family:"黑体";
color:black;
margin-left:280px;	

}
h4{
text-align:center;
margin-left:5px;

}
</style>
</head>

<body onload="tiao()">
	<div>
	
	<h2>${msg }</h2>
	<h4><span></span>后跳到登录界面</h4>
	<%
	response.setHeader("refresh", "5;URL=login.jsp");
	%>
	</div>
	<script type="text/javascript">
		var time = 5;
		var span1 = document.getElementsByTagName("span")[0];
	function  tiao(){
		span1.innerHTML=time;
	    time -- ;
	    if(time==0){
	    	clearInterval(timer);
	    }	
	}
		var timer =  setInterval("tiao()",1000);
	
	</script>
</body>
</html>