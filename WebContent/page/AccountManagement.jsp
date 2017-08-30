<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet">
<style type="text/css">
.on:hover{
display:inline-block;
background-color: #2980b6;
    color: #fff;
   
height:30px;
line-height:30px;
}
.on{
display:inline-block;
text-align:center;
width:40px;
height:30px;
line-height:30px;
}

</style>
</head>
<body>
	<div class="AccountManagement_c " id="AccountManagement_c">
                <h3>账户管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="${pageContext.request.contextPath }/images/search.png"></div>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <input type="button" class="add_btn df_btn fl" id="add_Account_btn" value="添加">
                        <input type="button" class="edit_btn df_btn fl" id="edit_Account_btn"  value="编辑" disabled="disabled" name="all">
                        <input type="button" class="delete_btn df_btn fl" id="delete_Account_btn" onclick="getUser()"  value="删除" disabled="disabled"  name="all">
                        <input type="button" class="fr df_btn ac_btn" id="ac_Account_btn" onclick="getUser()" value="账号授权" disabled="disabled"  name="all">
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name=""><span>用户名</span></label></li>
                        <li class="b20"><label>密码</label></li>
                        <li class="b60"><label>授权形式</label></li>
                    </ul>
                    <div class="list_b_c">
                        <ul class="list_null">
                            <li class="text_center">未添加管理员账户！</li>
                        </ul>

                            <c:forEach var="c" varStatus="stats" items="${pb.list }">
                        <ul class="list_b" >
                            <li class="b20"><label><input type="checkbox"  name="updateAccout" value="${c.username }" onclick="allss()"><span>${c.username }</span></label></li>
                            <li class="b20"><label>${c.password }</label></li>
                            <li class="b60"><label>${c.authorForm }</label></li>
                            
                          
                        </ul>
                        </c:forEach>
                        
               
                 
                         </div>
                     
                   

                    </div>
                    <div class="pull_page">
               <div class="fl pull_page_up" style="text-decoration: none"> 共有${totalNums }页&nbsp;  <a href="${pageContext.request.contextPath }/PageAccountServlet?pageNum=${currentPage-1}">上一页</a></div>
                            <ul>
                             <c:forEach var="c" items="${currentP }">
                              <a href="${pageContext.request.contextPath }/PageAccountServlet?pageNum=${c}" class="on">${c }</a>
                             </c:forEach>
                            </ul>
                        <div class="fl pull_page_down" style="text-decoration: none"><a href="${pageContext.request.contextPath }/PageAccountServlet?pageNum=${currentPage+1}">下一页</a>&nbsp;&nbsp;当前是第${currentPage }页</div>
                    </div>

                    
                </div>
           


            <!-- 弹窗 -->
    <!-- 添加账户 -->
    <div class="add_Account dn" id="add_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加账户
                    <span class="fr add_Account_close"><img src="${pageContext.request.contextPath }/images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="a_n" id="de_n">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="a_p">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_Account_ok_btn"  onclick = "addA()" >确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 账户编辑 -->
    <div class="add_Account dn" id="user_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    编辑账户
                    <span class="fr add_Account_close"><img src="${pageContext.request.contextPath }/images/close.png"></span>
                </div>
            </div>
            <div class="column_now ">正在编辑 “<span id="u"></span>”账户</div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="edit_id">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="edit_ps">     
            </div>
            <div class="add_Account_ok_btn text_center" id="user_column_ok_btn" onclick="update()">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 删除账户 -->
    <div class="add_Account dn" id="delete_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除账户
                    <span class="fr add_Account_close"><img src="${pageContext.request.contextPath }/images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span id="w"></span> ”账户吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_Account_ok_btn" onclick="del()">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 账户授权 -->
    <div class="add_Account dn" id="ac_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    账户栏目授权
                    <span class="fr add_Account_close"><img src="${pageContext.request.contextPath }/images/close.png"></span>
                </div>
            </div>
            <ul>
              <c:forEach var="c" varStatus="stats" items="${column }">
                <li><label><input type="checkbox" name="change" value="${c.department_name }" onclick="xuanzhong()">&nbsp;<span>${c.department_name }</span></label></li>
              </c:forEach>
            </ul>
            <div class="add_Account_ok_btn text_center" id="ac_Account_ok_btn" onclick="save()">保<i>呀</i>存</div>
        </div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
<script type="text/javascript">
            $("#de_n").mouseout(function(){
    	   $.ajax({    		
        		type:"get",
         		url:"ColumnManagement",
        		data:{"username":$("#de_n").val(),"type":"getV"},
        		dataType: "json",
        		success:function(data){
        		//	alert(data.message);
        		
                 if(data.message=="账号已经被注册"){
                	 alert("账号已经被注册");
                	 $("#de_n").val("");
                 }  
        	  
        	   
        		},
        		error:function(){
         
        }
         	});
    	   
       });




//这是js的代码
var checkss;
var check3;


function addA(){
	//这是添加账户的代码
	var a_n = document.getElementsByName("a_n")[0];
	var a_p = document.getElementsByName("a_p")[0];
	if(a_n.value==null||a_n.value==""){
		alert("用户名是空");
	}else if(a_p.value==null||a_p.value==""){
	alert("密码是空");
	}else{
	window.location.href="ManageAccount?a_n="+a_n.value+"&a_p="+a_p.value+"&type=add";
	}
}
function allss(){
	
	var flag = false;
	var all = document.getElementsByName("all");
    var check= 	document.getElementsByName("updateAccout");
    var checks;
    for(var i = 0 ; i < check.length;i++){
    	
    	if(check[i].checked == true){
    	  
    	
    	   checks = check[i].value;
    	   checkss = check[i].value;
    	   for(var i = 0 ; i< all.length; i++){
    		   all[i].disabled=false;
    		 
    	   }
          
    	flag = true;
    	}
	
}
    if(!flag){
    	 for(var i = 0 ; i< all.length; i++){
  		   all[i].disabled=true;
  	   }
    }
    
    //
    document.getElementById("u").innerHTML=checks;
    document.getElementById("w").innerHTML=checks;
  
    //
    var editid = document.getElementsByName("edit_id")[0];
    editid.value = checks;
    editid.disabled = true;
}

function update(){
	
    var edit_id = 	document.getElementsByName("edit_id")[0].value;
    var edit_name = 	document.getElementsByName("edit_ps")[0].value;
    

   
    window.location.href="ManageAccount?edit_id="+edit_id+"&edit_name="+edit_name+"&type=updates";
    
}

function del(){
	   var span1 = document.getElementById("w");
	   var value = span1.innerHTML;
     
	    window.location.href="ManageAccount?value="+value+"&type=del";

	  
}
function xuanzhong(){
	
	    var check2 = document.getElementsByName("change");
   
  for(var i = 0 ; i < check2.length;i++){
    	
    	if(check2[i].checked == true){
    	  
    	   check3 = check2[i].value;
    	
    
 
    	}
	
}
}
function save(){
	//这是进行授权的。
	
	window.location.href="ManageAccount?check3="+check3+"&checkss="+checkss+"&type=ADD";
	
}

</script>
</body>
</html>