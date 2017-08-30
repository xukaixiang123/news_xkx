package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.User;
import com.newcapec.edu.service.UserService;
import com.newcapec.edu.service.impl.UserServiceImpl;

public class ChangeUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到请求的值
		String username = request.getParameter("username");
	
		UserService us = new UserServiceImpl();
		try {
			User user = us.selectUser(username);
		
			if(user==null){
			
			}else{
				String jsonData="{\"message\":\"账号已被注册\"}";
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().print(jsonData);
				//没注册过
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  doGet(request, response);
	}

}
