package com.newcapec.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.domain.SecondNews;

public interface PageAccountService {
	//得到总记录数
		public int getCount() throws SQLException;
		//得到数据
		public List<SecondNews> getPageAccount(int pageNum,int pageSize) throws SQLException;
}
