package com.newcapec.edu.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.PageBean;
import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.service.ColumnManagementService;
import com.newcapec.edu.service.PageAccountService;
import com.newcapec.edu.service.impl.ColumnManagementServiceImpl;
import com.newcapec.edu.service.impl.PageAccountServiceImpl;

@WebServlet("/PageAccountServlet")
public class PageAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//首先得到页数
		try {
			String pageNum = request.getParameter("pageNum");
			if(pageNum ==null || pageNum.trim().equals("")){
				pageNum= "1";
			}
			int current = Integer.parseInt(pageNum);
			if(current<1){
				current = 1;
			}
			//活得总页数
			PageAccountService pas = new PageAccountServiceImpl();
			int count = pas.getCount();
			//活得每页显示的数据
			int pageSize = 5;
			//获得总页数
			int totalNums = count%pageSize==0?count/pageSize:count/pageSize+1;
			int index[]=new int[totalNums];
			for (int i = 0; i <totalNums; i++) {
				index[i]=i+1;
			}
			request.setAttribute("currentP", index);
            request.setAttribute("totalNums", totalNums);
			//活得每页的数据
			if(current>totalNums){
				current = totalNums;
			}
			request.setAttribute("currentPage", current);
			 List<SecondNews> pageAccount = pas.getPageAccount(current, pageSize);
			PageBean<SecondNews> pb = new PageBean<SecondNews>();
			pb.setPageNum(current);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalNums);
			pb.setTotalRecord(count);
			pb.setList(pageAccount);
			request.setAttribute("pb", pb);
			
			ColumnManagementService   cms = new ColumnManagementServiceImpl();
			List<ColumnManagement> column = cms.selectColumn();
			request.setAttribute("column",column);

			request.getRequestDispatcher("/page/AccountManagement.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
