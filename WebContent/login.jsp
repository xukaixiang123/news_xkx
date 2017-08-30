<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript">
	function changeCode(current){
		 
		current.src="validateCode?"+Math.random();
		}
	
	</script>
	    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	  
    <script type="text/javascript" src="js/validatelogin.js"></script>
</head>
<body>
<div class="login_head">
		<div class="container">
			<img src="images/logo.png">
		</div>
	</div>
	<div class="login_banner">
		<div class="container">
			<div class="login">
                <div class="login_in">
                    <div class="login_h">后台登陆 <span style="color:red;margin-left:20px">${msg }</span></div>
                       <form action="LoginServlet" method="post">
                    
                    <div class="user_login">
                        <input type="text" placeholder="账号" name="username">
                        <input type="password" placeholder="密码" name="password">
                    </div>
                    <div class="img_code">
                        <input type="text" placeholder="验证码" name="validate">
                        <img src="validateCode" alt="验证码" onclick="changeCode(this)">
                    </div>
                    
               
                   
                    <div class="login_btn"><input type="button" value="登录" style="width:50px;height:30px;margin:5px 0;border:0;background:#1a71b4;color:white"></div>
                    </form>
                </div>
                
            </div>
		</div>
	</div>
 
	<div class="login_end text_center">版权所有&copy;：新开普电子股份有限公司  豫ICP备08102576号  未经授权本站内容禁止私自转载使用！</div>

</body>
</html>