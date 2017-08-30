package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.service.ColumnManagementService;
import com.newcapec.edu.service.impl.ColumnManagementServiceImpl;

@WebServlet("/ColumnManagementAd")
public class ColumnManagementAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//这是添加的servlet
		String d_id = request.getParameter("d_id");
		String d_name = request.getParameter("d_name");
	
		ColumnManagement cm = new ColumnManagement();
		cm.setDepartment_id(Integer.parseInt(d_id));
		cm.setDepartment_name(d_name);
		cm.setDepartment_num(6);
		ColumnManagementService   cms = new ColumnManagementServiceImpl();
        try {
			int addD = cms.addD(cm);
			if(addD>0){
				//添加成功
				request.getRequestDispatcher("PageServlet").forward(request, response);
				
			}else{
				//添加失败
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
