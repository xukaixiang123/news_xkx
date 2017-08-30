package com.newcapec.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.News;

public interface NewsManagementService {

	public List<ColumnManagement> selectColumn()  throws SQLException;

	public int addNews(News news) throws SQLException ;

}
