<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册</title>
<link type="text/css" rel="stylesheet" href="css/login.css">
<link type="text/css" rel="stylesheet" href="css/layer.css">
  <script type="text/javascript" src="js/jquery-3.2.1.js"></script>

        <script type="text/javascript" src="js/layer.js"></script>
    
    <script type="text/javascript" src="js/validate.js"></script>
</head>
<body class="login_bj">
<div class="zhuce_body">
	<div class="logo" style="margin:35px 0  0 200px "><img src="images/logo.png" width="297px" height="36px" border="0"></div>
    <div style="height:500px;background:url(images/bj_zhuce.jpg) no-repeat;background-size:100% 90%">
    <div class="zhuce_kong" style="position:relative">
    	<div class="zc">
        	<div class="bj_bai" >
            <h3>欢迎注册</h3>
       	  	  <form action="${pageContext.request.contextPath }/RegistServlet" method="post" id="form">
                <input name="username" type="text" class="kuang_txt phone" placeholder="用户名"><span style="display:none;color:red" id="s11" >用户名被注册</span><br>
                  <span id="box" style="display:none">用户名4-10位,以字母和数字开头</span>
                
                <input name="email" type="email" class="kuang_txt email" placeholder="邮箱"><br>
                  <span id="box3" style="display:none">邮箱4-16位,以news结尾</span>
               
                <input name="password" type="text" class="kuang_txt possword" placeholder="密码"><br>
                <span id="box1" style="display:none">密码4-16位,以字母开头和结尾</span>
               
             
                <div>
               		<input name="" type="checkbox" value=""><span>已阅读并同意<a href="javascript:void(0)"  id="tan"><span class="lan">《新闻后台使用协议》</span></a></span>
                </div>
                <input name="注册" type="button" class="btn_zhuce" value="注册">
                
                </form>
            </div>
        	<div class="bj_right">
            	<p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="login.jsp">立即登录</a></p>
            
            </div>
        </div>
      
    </div>

</div>
    
</div>
 


</body>
</html>