package com.newcapec.edu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class News_Filter
 */
@WebFilter("/News_Filter")
public class News_Filter implements Filter {

   
    public News_Filter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	String password =  (String) req.getSession().getAttribute("passwords");
	String username = (String) req.getSession().getAttribute("usernames");	
		if(username==null||"".equals(username)){
			request.setAttribute("msg", "请求的资源不存在");
        	request.getRequestDispatcher("/error.jsp").forward(request, response);
		 return ;
		}else{
		chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
