package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.User;
import com.newcapec.edu.service.UserService;
import com.newcapec.edu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String parameter = request.getParameter("username");
        String password = request.getParameter("password");
        String validateCode = request.getParameter("validate");
        request.getSession().setAttribute("usernames", parameter);
        request.getSession().setAttribute("passwords", password);

        if(validateCode == null||parameter == null||password==null){
        	request.setAttribute("msg", "请求的资源不存在");
        	request.getRequestDispatcher("/error.jsp").forward(request, response);
        	return;
        }
        request.getSession().setAttribute("validateCode", validateCode);
        StringBuffer num = (StringBuffer)request.getSession().getAttribute("num");
     

        UserService us = new UserServiceImpl();
        User user = null;
        try {
			user = us.select(parameter,password);
			//第48行有错误
			if(user != null&&validateCode.equalsIgnoreCase(num.toString())){
				request.getSession().setAttribute("user1",user);
	        	request.getRequestDispatcher("/page/index.jsp").forward(request, response);
	        	
                return;
			}else{
			
				if(!validateCode.equalsIgnoreCase(num.toString())){
		        request.setAttribute("msg", "验证码错误");
	        	request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
				
				} if(user == null){
	           

					   request.setAttribute("msg", "用户名或者密码错误");
			        	request.getRequestDispatcher("/login.jsp").forward(request, response);
                       return;
				}


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(!validateCode.equalsIgnoreCase(num.toString())){
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
