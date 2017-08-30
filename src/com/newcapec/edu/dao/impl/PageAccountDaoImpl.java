package com.newcapec.edu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.util.C3P0Util;

public class PageAccountDaoImpl implements com.newcapec.edu.dao.PageAccountDao {

	
	//第一个是获得总的记录数
	public int getCount() throws SQLException{
		//活得总记录数
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " SELECT COUNT(*) FROM news_user ";
		Long l = (long) qr.query(sql, new ScalarHandler());
		return l.intValue();
	}
	
	public List<SecondNews> getPageAccount(int pageNum,int pageSize) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "SELECT t3.username,t3.password,GROUP_CONCAT(DISTINCT(t4.department_name)) authorForm FROM (SELECT t1.username,t1.`password`,t2.department_id FROM news_user t1 LEFT JOIN manage t2 ON t1.`username` = t2.`user_id`) t3 LEFT JOIN department t4 ON t3.department_id = t4.`department_id` GROUP BY t3.username limit ?,?";
       //获取这俩个参数
		//得到总记录数
		int page = (pageNum-1)*pageSize;
		Object[] params={page,pageSize};
		
		return qr.query(sql,new BeanListHandler<SecondNews>(SecondNews.class),params);
	}
	

}
