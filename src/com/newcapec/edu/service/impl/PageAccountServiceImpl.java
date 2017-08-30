package com.newcapec.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.dao.PageAccountDao;
import com.newcapec.edu.dao.impl.PageAccountDaoImpl;
import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.service.PageAccountService;

public class PageAccountServiceImpl implements PageAccountService {

	@Override
	public int getCount() throws SQLException {
		// TODO Auto-generated method stub
		PageAccountDao pad = new PageAccountDaoImpl();
		int count = pad.getCount();
		return count;
	}

	@Override
	public List<SecondNews> getPageAccount(int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		PageAccountDao pad = new PageAccountDaoImpl();
        List<SecondNews> list = pad.getPageAccount(pageNum, pageSize);
		return list;
	}

}
