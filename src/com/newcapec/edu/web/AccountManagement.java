package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.dao.AccountManagementDao;
import com.newcapec.edu.dao.impl.AccountManagementDaoImpl;
import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.service.AccountManagementService;
import com.newcapec.edu.service.ColumnManagementService;
import com.newcapec.edu.service.impl.AccountManagementServiceImpl;
import com.newcapec.edu.service.impl.ColumnManagementServiceImpl;


@WebServlet("/AccountManagement")
public class AccountManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//这是账户的管理的方法所有的方法都在这里边写哟
		if(request.getSession()==null){
			response.sendRedirect("/login.jsp");
		}
		AccountManagementDao amd = new AccountManagementDaoImpl();
		ColumnManagementService   cms = new ColumnManagementServiceImpl();
		try {
		List<ColumnManagement> column = cms.selectColumn();
		request.setAttribute("column",column);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			//List<Object[]>  list= ams.selectAccount();
				List<SecondNews> list =amd.selectUser();
			    
			
			if(list!=null){
			
				request.setAttribute("list", list);
				request.getRequestDispatcher("/page/AccountManagement.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
