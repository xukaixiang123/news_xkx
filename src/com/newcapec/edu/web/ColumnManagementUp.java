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


@WebServlet("/ColumnManagementUp")
public class ColumnManagementUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//这是栏目进行编辑的代码
		String edit_id = request.getParameter("edit_id");
		String edit_name = request.getParameter("edit_name");
		ColumnManagement cm = new ColumnManagement();
		cm.setDepartment_id(Integer.parseInt(edit_id));
		cm.setDepartment_name(edit_name);
		cm.setDepartment_num(5);
		ColumnManagementService   cms = new ColumnManagementServiceImpl();
        try {
			int updateD = cms.updateD(cm);
			if(updateD>0){
				//证明修改成功了
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
