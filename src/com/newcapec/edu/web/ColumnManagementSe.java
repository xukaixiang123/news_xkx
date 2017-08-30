package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.newcapec.edu.service.ColumnManagementService;
import com.newcapec.edu.service.impl.ColumnManagementServiceImpl;

/**
 * Servlet implementation class ColumnManagement
 */
@WebServlet("/ColumnManagement")
public class ColumnManagementSe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//这是栏目进行管理
		ColumnManagementService   cms = new ColumnManagementServiceImpl();
	     String name = request.getParameter("type");
	     System.out.println(name+"================");
			String jsonData="{\"message\":\"账号已经被注册\"}";
			String jsonData1="{\"message\":\"账号未被注册\"}";

			response.setContentType("application/json;charset=utf-8");

        if("getU".equals(name)){
	     int username = Integer.parseInt(request.getParameter("username"));
	     try {
			boolean flag = cms.isExit(username);
	        if(flag){
	        	response.getWriter().print(jsonData);
	        	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }else if("getV".equals(name)){
        	  String username = request.getParameter("username");
     	   
			try {
			boolean	flag = cms.isExitUsername(username);
			System.out.println(flag);
			if(flag){
	        	response.getWriter().print(jsonData);

			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }
	    
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
