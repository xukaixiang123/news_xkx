package com.newcapec.edu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.newcapec.edu.dao.AccountManagementDao;
import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.domain.User;
import com.newcapec.edu.util.C3P0Util;

public class AccountManagementDaoImpl implements AccountManagementDao {
    
	
	@Override
	
	public List<SecondNews> selectUser() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "SELECT t3.username,t3.password,GROUP_CONCAT(DISTINCT(t4.department_name)) authorForm FROM (SELECT t1.username,t1.`password`,t2.department_id FROM news_user t1 LEFT JOIN manage t2 ON t1.`username` = t2.`user_id`) t3 LEFT JOIN department t4 ON t3.department_id = t4.`department_id` GROUP BY t3.username";
                                                                    
     
		List<SecondNews> list = qr.query(sql, new BeanListHandler<SecondNews>(SecondNews.class));
     
		return list;
	}
	public List<Object[]> selectAllUser() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = " SELECT username,PASSWORD FROM news_user where username!= 12311";

	    List<Object[]> query = qr.query(sql, new ArrayListHandler());
	   return query;
	    
	}
	public List<Object> selectD() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "SELECT department.`department_name` FROM news_user JOIN manage  ON news_user.`username` = manage.`user_id` JOIN department ON manage.`department_id` = department.`department_id` where news_user.`username`!=12311";

		List<Object> list = qr.query(sql, new ColumnListHandler());
	   return list;
	    
	}
	
	public Object selectD2(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "SELECT department.`department_name` FROM news_user JOIN manage  ON news_user.`username` = manage.`user_id` JOIN department ON manage.`department_id` = department.`department_id` where news_user.`username` = ?";

		  Object query = qr.query(sql, new ScalarHandler());
	   return query;
	    
	}
	public static void main(String[] args) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "SELECT t3.username,t3.password,GROUP_CONCAT(DISTINCT(t4.department_name)) authorForm FROM (SELECT t1.username,t1.`password`,t2.department_id FROM news_user t1 LEFT JOIN manage t2 ON t1.`username` = t2.`user_id` WHERE t1.`level` = 2) t3 LEFT JOIN department t4 ON t3.department_id = t4.`department_id` GROUP BY t3.username;";                                                                     
     
		List<SecondNews> list = qr.query(sql, new BeanListHandler<SecondNews>(SecondNews.class));
		
	}
	@Override
	public int addAccount(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = " insert into news_user values(?,?,?,?,?,?)";
        Object[] params={user.getUsername(),user.getPassword(),user.getLevel(),user.getCode(),user.getState(),user.getEmail()};
        int update = qr.update(sql, params);
		return update;
	}
	@Override
	public int addAccount(String a_n, String a_p) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = " update news_user set password = ? where username=?";
        Object[] params={a_p,a_n};
        int update = qr.update(sql, params);

	    return update;
	}
	@Override
	public int delA(String del) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql1 = " delete from manage where user_id = ?";
		qr.update(sql1, del);
        String sql = " delete from news_user where username = ?";
        
        int update = qr.update(sql, del);

		return update;
	}
	@Override
	public int addManage(String checkss, int id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " insert into Manage values(?,?,?)";
		
		Object[] params = {null,checkss,id};
		return qr.update(sql, params);
		
	}
	@Override
	public int getId(String check3) throws SQLException {
		// TODO Auto-generated method stub
		//得到id值
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
         String sql = " select department_id from department where department_name=?";
        return (int) qr.query(sql, new ScalarHandler(),check3);
		
	}

	
}
