package com.newcapec.edu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.newcapec.edu.dao.PageDao;
import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.PageBean;
import com.newcapec.edu.util.C3P0Util;

public class PageDaoImpl implements PageDao {

	@Override
	public int getTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " SELECT COUNT(*) as counts FROM department";
	    Long querys = (long)qr.query(sql, new ScalarHandler());
	    return querys.intValue();
	}

	@Override
	public List<ColumnManagement> findAll(int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql="SELECT department_id,department_name FROM department limit ?,?";
		//索引的值 
		int page = (pageNum-1)*pageSize;
		Object[] params = {page,pageSize};
		return qr.query(sql, new BeanListHandler<ColumnManagement>(ColumnManagement.class),params);

	}

	

}
