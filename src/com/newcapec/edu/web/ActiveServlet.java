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

public class ActiveServlet extends HttpServlet {

	/**
	 * 用户接受的servlet
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受用户吗
		String code = request.getParameter("code");
		UserService us = new UserServiceImpl();
		try {
			User user = us.findByCode(code);
			if(user!=null){
				user.setState(1);
				user.setCode(null);
				us.updateState(user); 
				request.setAttribute("msg", "激活成功，可以登录了!");
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}else{
				//进行跳转，失败的话。
				request.setAttribute("msg", "你的激活码有误，请重新激活!");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
