package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.User;
import com.newcapec.edu.service.AccountManagementService;
import com.newcapec.edu.service.impl.AccountManagementServiceImpl;

/**
 * Servlet implementation class ManageAccount
 */
@WebServlet("/ManageAccount")
public class ManageAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//这是管理账户的功能
		String type = request.getParameter("type");
	 
		if("add".equals(type)){
			//这是添加的代码
			String a_n = request.getParameter("a_n");
			String a_p = request.getParameter("a_p");
			AccountManagementService ams = new AccountManagementServiceImpl();
			User user = new User();
			user.setUsername(a_n);
			user.setPassword(a_p);
			user.setCode(null);
			user.setEmail("user1@news.com");
			user.setLevel(2);
			user.setState(1);
			
			try {
				int addAcount = ams.addAcount(user);
				if(addAcount>0){
					//证明添加成功了 
					request.getRequestDispatcher("/PageAccountServlet").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if("updates".equals(type)){
			//这证明是修改的
			String a_n = request.getParameter("edit_id");
			String a_p = request.getParameter("edit_name");
			AccountManagementService ams = new AccountManagementServiceImpl();
			
            try {
				int update = ams.updateA(a_n,a_p);
				if(update>0){
				//证明修改成功了
					request.getRequestDispatcher("/PageAccountServlet").forward(request, response);

				}else{
					//证明修改失败了
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if("del".equals(type)){
			//这是进行那个删除的方法
			String del = request.getParameter("value");
			AccountManagementService ams = new AccountManagementServiceImpl();
          try {
			int flag =   ams.delA(del);
			if(flag>0){
				request.getRequestDispatcher("/PageAccountServlet").forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		}
		else if("ADD".equals(type)){
			String checkss = request.getParameter("checkss");
			String check3 = request.getParameter("check3");
			//通过check3找到对应的ID值
			
		    //添加就ok了
			AccountManagementService ams = new AccountManagementServiceImpl();
        
			try {
				int id =  ams.getId(check3);
				int flag = ams.addManage(checkss,id);
				if(flag>0){
					//证明添加成功了
					request.getRequestDispatcher("/PageAccountServlet").forward(request, response);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
