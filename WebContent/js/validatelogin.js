$(function(){
	var $button = $(".login_btn");
	var $username = $("input[name='username']");
	var $password = $("input[name='password']");
    var $code = $("input[name='validate']");
    
	//这是账号的验证
	var reg = /^(\w|\d){4,10}$/;
	//这是密码的验证
	var reg2 = /^[a-zA-Z](\w|\d){2,14}[a-zA-Z]$/;

  
     $button.click(function(){
    	
    	if($username.val()==""){
    		alert("用户名是空");
    		return;
    	}else if($password.val()==""){
    		alert("密码为空");	
    		return;
    	}else if($code.val()==""){
    		alert("验证码为空");
    		return;
    	}
    	$("form").submit();
    	
    			
    	
    	
     });
  
 
  
});
