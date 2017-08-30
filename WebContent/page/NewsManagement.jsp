<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.js"></script>
	<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet">

</head>
<body>
<!-- 新闻管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>新闻管理 
                    <div class="amcl fr">
                       
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="${pageContext.request.contextPath }/images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>发布新闻</label></li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                            <div class="news_title">
                                <label class="text_center">标题</label>
                                <input type="text" placeholder="填写标题" name="title">
                            </div>
                            <div class="column_name">
                                <label class="text_center">栏目</label>
                                <select class="column_name_release" id="test">
                                   <c:forEach var="c" items="${list }">
                                    <option>${c.department_name }</option>
                                 </c:forEach>
                                </select>
                            </div>
                            <br>
                        
                               <textarea name="content" id="content" cols="100" rows="8" style="width:700px;height:400px;visibility:hidden;" ></textarea>
                            <div class="release_news_ok_btn text_center" onclick="get()">发<i>我</i>布</div>
                        </div>


                    </div>
                </div>
            </div>
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
<script>
	    var editor1;
		KindEditor.ready(function(K) {
			    editor1 = K.create('textarea[name="content"]', {
				cssPath : '${pageContext.request.contextPath }/kindeditor/plugins/code/prettify.css',
				uploadJson : '${pageContext.request.contextPath }/kindeditor/jsp/upload_json.jsp',//标识处理图片的文件
				fileManagerJson : '${pageContext.request.contextPath }/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,//允许上传文件和图片
			    afterCreate : function() { 
		            this.sync(); 
		        }, 
		        afterBlur:function(){ 
		            this.sync(); 
		        }                 
			});
			prettyPrint();
		});
	
	 function get(){
		 var title = document.getElementsByName("title")[0];
	
		 if(title.value==null||title.value==""){
			 alert("用户名为空");
			 return;
		 }
		 var myselect=document.getElementById("test");
		 var index=myselect.selectedIndex;
		 var text = myselect.options[index].text;
		
		 var value = document.getElementById("content");
		 window.location.href="AddNews?content="+value.value+"&title="+title.value+"&text="+text;
	 }
	
</script>
</body>
</html>