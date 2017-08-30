package com.newcapec.edu.dao;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.PageBean;

public interface PageDao {

	public int getTotalCount()  throws SQLException;
	public List<ColumnManagement> findAll(int pageNum, int pageSize) throws SQLException;
}
