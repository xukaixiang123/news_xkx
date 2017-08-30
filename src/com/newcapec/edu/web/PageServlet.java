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
import com.newcapec.edu.service.PageService;
import com.newcapec.edu.service.impl.PageServiceImpl;

/**
 * Servlet implementation class SelectInfoServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		//WEB-INF下的文件只能通过跳转只要网址带WEB就不行。
		//request.getRequestDispatcher()
		//limit是取前几页limit前几页
		//limit ?,?第一个参数是第几页+1
		//第二个参数是长度。
	// 这是前台的获取
		//第一个参数是当前页
		
		try {
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null||pageNum.trim().equals("")){
				pageNum = "1";
			}
		int 	currentPage = Integer.parseInt(pageNum);
			if(currentPage<1){
				currentPage = 1;
				
			}
			//把当前页存到数据库中
		
			//第2个参数是总记录数
			PageService ps = new PageServiceImpl();
			int totalCount = ps.getTotalCount();
			//把总页数放上边
		
			//第3个参数是每页显示的数据
			int pageSize = 5;
			//第4个是总页数
			int count = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			if(currentPage>count){
				currentPage = count;
			}
			
			int index[]=new int[count];
			for (int i = 0; i <count; i++) {
				index[i]=i+1;
			}


			request.setAttribute("current", index);
			request.setAttribute("totalPage", count);

			
			
			request.setAttribute("currentPage", currentPage);
			//第5个参数是数据集合

			List<ColumnManagement> list = ps.findAllUserWithPage(currentPage, pageSize);
			//建立一个对象page对象进行封装
			PageBean<ColumnManagement> pb = new PageBean<ColumnManagement>();
		    pb.setPageSize(pageSize);
		    pb.setTotalPage(count);
		    pb.setTotalRecord(totalCount);
		    pb.setPageNum(currentPage);
		    pb.setList(list);
			request.setAttribute("pb", pb);
			request.getRequestDispatcher("/page/ColumnManagement.jsp").forward(request, response);;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
