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
  <!-- 栏目管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>栏目管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="${pageContext.request.contextPath }/images/search.png"></div>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <input type="button" class="add_btn df_btn fl" id="add_column_btn" value="添加" >
                        <input type="button" class="edit_btn df_btn fl" id="edit_column_btn" value="编辑"  disabled="disabled" name="caozuo">
                        <input class="delete_btn df_btn fl" id="delete_column_btn" value="删除"  disabled="disabled"  type="button" name="caozuo">
                       
                    </div>
                </div> 

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name=""><span>序号</span></label></li>
                        <li class="b80"><label>栏目名称</label></li>
                    </ul>
                    <div class="list_b_c">
                        <ul class="list_null">
                            <li class="text_center">未添加栏目！</li>
                        </ul>
                        <c:forEach items="${pb.list}" varStatus="status" var="c">
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox"  name="check" value="${ c.department_id}" onclick="change()"><span>${c.department_id }</span></label></li>
                            <li class="b80"><label id="l">${c.department_name }</label></li>
                        </ul>
                    
                      </c:forEach>


                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up" style="text-decoration: none">共${totalPage }页&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/PageServlet?pageNum=${currentPage-1}">上一页</a></div>
                            <ul>
                            
                        <c:forEach  items="${current}" var="index_page">
                         <a href="${pageContext.request.contextPath }/PageServlet?pageNum=${index_page}" class="on">${index_page}</a>
                       </c:forEach>
                            </ul>
                      
                          
                        <div class="fl pull_page_down" style="text-decoration: none" ><a href="${pageContext.request.contextPath }/PageServlet?pageNum=${currentPage+1}">下一页</a>当前是第${currentPage }页</div>
                    </div>

                    
                </div>
            </div>


            <!-- 添加栏目 -->
    <div class="add_Account dn" id="add_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加栏目
                    <span class="fr add_Account_close"><img src="${pageContext.request.contextPath }/images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="d_name" >     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="d_id" id="de_n">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_column_ok_btn" onclick="add()">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 编辑栏目 -->
    <div class="add_Account dn" id="edit_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    编辑栏目
                    <span class="fr add_Account_close"><img src="${pageContext.request.contextPath }/images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="edit_name">     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="edit_id">     
            </div>
            <div class="add_Account_ok_btn text_center" id="edit_column_ok_btn" onclick="update()">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 删除栏目 -->
    <div class="add_Account dn" id="delete_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除栏目
                    <span class="fr add_Account_close"><img src="${pageContext.request.contextPath }/images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span id="delP"></span> ”栏目吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_column_ok_btn" onclick="del()">确<i>皮</i>定</div>
        </div>
    </div>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
<script type="text/javascript">
//用jquery ajax来进行判断
$("#de_n").mouseout(function(){
	//alert
	
	   $.ajax({    		
    		type:"get",
     		url:"ColumnManagement",
    		data:{"username":$("#de_n").val(),"type":"getU"},
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
       
       
	
	
	
	
	
	
	
	
	
})

function add(){

    var d_id = 	document.getElementsByName("d_id")[0].value;
    var d_name = document.getElementsByName("d_name")[0].value;
    if(d_id ==""||d_id==null){
    	alert("用户名不能为空");
    
    } else if(d_name ==""||d_name==null){
    	alert("密码不能为空");

    }
    else{
    
    window.location.href="ColumnManagementAd?d_id="+d_id+"&d_name="+d_name;
    }
}
function change(){
	//设置可点就好了
	
    var check = 	document.getElementsByName("check");
    var  v = document.getElementsByName("caozuo");
   
    var flag = false;
    var checks;
    for(var i = 0 ; i < check.length;i++){
    	if(check[i].checked == true){
    	   checks = check[i].value;
    	   
    	
          //设置所有按钮
          for(var i = 0 ; i< v.length; i++){
        	  v[i].disabled=false;
          }
          flag = true;
          
    	} 
    	
    }
    if(!flag){
		   for(var i = 0 ; i< v.length; i++){
	        	  v[i].disabled=true;
	          }
		 
	}
    var span1 = document.getElementById("delP");
	     span1.innerHTML = checks;
    
    
    

    var editid = document.getElementsByName("edit_id")[0];
    editid.value = checks;
    editid.disabled = true;
}
function update(){
    var edit_id = 	document.getElementsByName("edit_id")[0].value;
   

    var edit_name = 	document.getElementsByName("edit_name")[0].value;
    window.location.href="ColumnManagementUp?edit_id="+edit_id+"&edit_name="+edit_name;
  
}
function del(){
	   var span1 = document.getElementById("delP");
	   var value = span1.innerHTML;
	
	    window.location.href="ColumnManagementDel?value="+value;

	  
}


</script>


</body>
</html>