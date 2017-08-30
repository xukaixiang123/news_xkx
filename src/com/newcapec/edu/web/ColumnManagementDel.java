package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.service.ColumnManagementService;
import com.newcapec.edu.service.impl.ColumnManagementServiceImpl;

/**
 * Servlet implementation class ColumnManagementDel
 */
@WebServlet("/ColumnManagementDel")
public class ColumnManagementDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String value = request.getParameter("value");
	ColumnManagementService   cms = new ColumnManagementServiceImpl();
    try {
		int  flag = cms.del(value);
		if(flag>0){
			request.getRequestDispatcher("PageServlet").forward(request, response);

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
