$(function(){
	var $button = $("input[type='button']");
	var $username = $("input[name='username']");
	var $password = $("input[name='password']");
	var $email = $("input[name='email']");
	var $checkbox = $("input[type='checkbox']");
	//这是账号的验证
	var reg = /^(\w|\d){4,10}$/;
	//这是密码的验证
	var reg2 = /^[a-zA-Z](\w|\d){2,14}[a-zA-Z]$/;

  
     $button.click(function(){
    	if($username.val()==""){
    		alert("用户名是空");
    	}else if($email.val()==""){
    		alert("邮箱为空");	
    	}else if($password.val()==""){
    		alert("密码为空");
    	}else if(!reg.test($username.val())){
    		alert("用户名格式不正确,4-10位");
    	}else if(!reg2.test($password.val())){
    		alert("密码格式不正确,");

    	}else if(($checkbox.is(":checked"))){
    	
    		$("#form").submit();
    	}
    			
    	
    	
     });
     $username.focus(function(){
    	 
     $("#box").css({
    	 "position":"absolute",
    	 "top":"115px",
    	 "left":"200px",
         "color":"black",
         "font-size":"13px",
         "display":"inline",
         "border":"1px solid black",
         "background":"#FFFFFF"
         
     })

    
     });
     $username.blur(function(){
    	 
         $("#box").css({
        
             "display":"none"	 
         })
         //还有一个就是把ajax请求
         $.ajax({
      		
     		type:"get",
      		url:"ChangeUserServlet",
     		data:{"username":$username.val()},
     		dataType: "json",
     		success:function(data){
     		//	alert(data.message);
     		
     	       if(data.message=="账号已经被注册"){
     			$("#s11").html("账号已经被注册").css("color","red").show();
     	       }
     		},
     		error:function(){
      
     }
      	});
        
         });
     $password.focus(function(){
     $("#box1").css({
    	 "position":"absolute",
    	 "top":"210px",
    	 "left":"200px",
         "color":"black",
         "font-size":"13px",
         "display":"inline"	, 
         "border":"1px solid black",
          "background":"#FFFFFF"
     })
         
         });
     
  $password.blur(function(){
    	 
         $("#box1").css({
        
             "display":"none"	 
         })

        
         });
  ////
  $email.focus(function(){
	     $("#box3").css({
	    	 "position":"absolute",
	    	 "top":"170px",
	    	 "left":"200px",
	         "color":"black",
	         "font-size":"13px",
	         "display":"inline",
	         "border":"1px solid black",
	          "background":"#FFFFFF"
	        	 
	     })
	         
	         });
  
  $email.blur(function(){
 	 
      $("#box3").css({
     
          "display":"none"	 
      })

     
      });
//接下来就是点击那个按钮
  $("#tan").click(function(){
	  layer.open({
		  type: 1,
		//具体配置参考：offset参数项
		  offset: ['120px', '850px'],
		  content: '<div style="padding: 20px 80px;width:200px;height:172px">遵守网站规定，禁止乱骂口出狂言</div>'
		  ,btn: '关闭'
		  ,btnAlign: 'c' //按钮居中
		  ,shade: 0 //不显示遮罩
		  ,yes: function(){
		    layer.closeAll();
		  }
		});

  })

  
});
