<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻发布管理平台</title>
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet">
</head>
<body>
  <div class="header">
        <div class="header_in">
            <img src="images/tit.png">
            <div class="quit text_center" onclick="exit()">安全退出</div>
        </div>
        
    </div>

    <div class="content ">
        <div class="user">
            <div class="user_status fl text_center">当前用户： <span>${usernames}</span></div>
            <div class="user_location fl">当前： 首页-<span>账户管理</span>  </div>
        </div>
        <div class="nav_side text_center fl">
            <div class="nav AccountManagement active">账户管理</div>
            <div class="nav ColumnManagement ">栏目管理</div>
            <div class="nav NewsManagement">新闻管理</div>
        </div>


        <div class="main_fx">
            
            <div class="AccountManagement_c_iframe">
                <iframe src="PageAccountServlet"></iframe>
            </div>

        </div>
        



    </div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
<script type="text/javascript">
//这是进行注销
 function exit(){
	
	var ex = confirm("是否要注销吗?");
	
	if(ex){
		//注销代码
		window.location.href =  "login.jsp"
		
	
	}
}

</script>

</body>
</html>