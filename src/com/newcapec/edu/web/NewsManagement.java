package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.service.NewsManagementService;
import com.newcapec.edu.service.impl.NewsManagementServiceImpl;


@WebServlet("/NewsManagement")
public class NewsManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//这是新闻管理系统其中需要获取到栏目
		
		NewsManagementService nms = new NewsManagementServiceImpl();
		try {
			List<ColumnManagement> list = nms.selectColumn();
		
			if(list!=null){
				//证明成功了
				request.setAttribute("list", list);
				request.getRequestDispatcher("/page/NewsManagement.jsp").forward(request, response);
			}else{
				//证明失败  了
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
