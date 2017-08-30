package com.newcapec.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.dao.PageDao;
import com.newcapec.edu.dao.impl.PageDaoImpl;
import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.PageBean;
import com.newcapec.edu.service.PageService;

public class PageServiceImpl implements PageService {

	@Override
	public List<ColumnManagement> findAllUserWithPage(int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		//PageDao
		PageDao pd = new PageDaoImpl();
        List<ColumnManagement> list = pd.findAll(pageNum, pageSize);
		return list;
	}

	@Override
	public int getTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		PageDao pd = new PageDaoImpl();
        int count = pd.getTotalCount();
        return count;
	}

	

}
