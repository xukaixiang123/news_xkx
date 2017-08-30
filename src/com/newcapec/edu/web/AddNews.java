package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.News;
import com.newcapec.edu.service.ColumnManagementService;
import com.newcapec.edu.service.NewsManagementService;
import com.newcapec.edu.service.impl.ColumnManagementServiceImpl;
import com.newcapec.edu.service.impl.NewsManagementServiceImpl;
/**
 * 这是处理后台添加的内容的。
 */
/**
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//这是添加新闻的方法
          String string = request.getParameter("content");
          String title = request.getParameter("title");
          String department = request.getParameter("text");
          News news = new News();
          news.setTitle(title);
          news.setDetail(department);
          news.setKeyword("这是新增的新闻");
   	   SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	   //开始的时间
   	   news.setStartTime(smf.format(new Date()));
       //结束的时间
   	   news.setEndTime(smf.format(new Date()));
   	   news.setMian_img("xxx");
   	   news.setTop(2);
   	   //获取到
   	   ColumnManagementService cms = new ColumnManagementServiceImpl();
   	   int id;
	try {
		id = cms.getId(department);
		news.setDepartment_id(id);
		news.setState(1);
		news.setUser_id("12311");
		NewsManagementService nms = new NewsManagementServiceImpl();
		int addNews = nms.addNews(news);
		if(addNews>0){
			//添加成功。
			request.getRequestDispatcher("/page/NewsManagement.jsp").forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	   
   	  
       //   System.out.println(smf.format(new Date()));
         // news.setStartTime();
          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
  
}
