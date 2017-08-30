package com.newcapec.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.domain.ColumnManagement;


public interface PageService {
	public int getTotalCount() throws SQLException; 
	public List<ColumnManagement> findAllUserWithPage(int pageNum, int pageSize) throws SQLException ;
}
