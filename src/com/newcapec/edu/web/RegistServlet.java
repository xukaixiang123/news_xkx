package com.newcapec.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.User;
import com.newcapec.edu.service.UserService;
import com.newcapec.edu.service.impl.UserServiceImpl;
import com.newcapec.edu.util.UUIDUtil;

public class RegistServlet extends HttpServlet {

	/**
	 * 用户注册的servlet
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet的学习
		//接受数据
		try{
		   
			String username = request.getParameter("username");
		 
		 
		 
		 String password = request.getParameter("password");
		 String email = request.getParameter("email");
		
		//进行封装
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setState(0);//0代表未激活，1代表激活
		user.setLevel(2);//1代表管理员，2代表普通用户
		String code = UUIDUtil.getUUID();
		user.setCode(code);
		//调用业务层
		UserService us = new UserServiceImpl();
	
		us.regist(user);
		request.setAttribute("msg", "你已经注册成功，请到邮箱激活邮件");
		request.getRequestDispatcher("/success.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		//页面跳转
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
