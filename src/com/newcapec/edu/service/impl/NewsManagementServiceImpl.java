package com.newcapec.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.dao.NewsManagementDao;
import com.newcapec.edu.dao.impl.NewsManagementDaoImpl;
import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.News;
import com.newcapec.edu.service.NewsManagementService;

public class NewsManagementServiceImpl implements NewsManagementService {

	@Override
	public List<ColumnManagement> selectColumn()   throws SQLException{
		// TODO Auto-generated method stub
		NewsManagementDao nmd = new NewsManagementDaoImpl();
		List<ColumnManagement> list = nmd.selectColumn();
		return list;
	}

	@Override
	public int addNews(News news) throws SQLException {
		// TODO Auto-generated method stub
		NewsManagementDao nmd = new NewsManagementDaoImpl();
        int flag = nmd.addNews(news);
        return flag;
		
	}

}
