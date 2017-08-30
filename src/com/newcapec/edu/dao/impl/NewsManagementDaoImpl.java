package com.newcapec.edu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.newcapec.edu.dao.NewsManagementDao;
import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.domain.News;
import com.newcapec.edu.domain.User;
import com.newcapec.edu.util.C3P0Util;

public class NewsManagementDaoImpl implements NewsManagementDao {

	@Override
	public List<ColumnManagement> selectColumn() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " select * from department ";
	    List<ColumnManagement> list = qr.query(sql, new BeanListHandler<ColumnManagement>(ColumnManagement.class));
		
		return list;
		
	}

	@Override
	public int addNews(News news) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "insert into news values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params={0,news.getTitle(),news.getDepartment_id(),news.getMian_img(),news.getDetail(),news.getKeyword(),news.getTop(),news.getState(),news.getUser_id(),null,news.getStartTime(),news.getEndTime(),};
      
        return   qr.update(sql, params);
	}

}
