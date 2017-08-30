package com.newcapec.edu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.newcapec.edu.dao.ColumnManagementDao;
import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.util.C3P0Util;

public class ColumnManagementDaoImpl implements ColumnManagementDao {

	@Override
	public List<ColumnManagement> selectColumn() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
        String sql =" select * from department ";
		List<ColumnManagement> list = qr.query(sql, new BeanListHandler<ColumnManagement>(ColumnManagement.class));
	       return list;
	}

	@Override
	public int addD(ColumnManagement cm) throws SQLException {
		// TODO Auto-generated method stub
		//这是栏目添加的方法
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql="insert into department values(?,?,?)";
		Object[] params = {cm.getDepartment_id(),cm.getDepartment_num(),cm.getDepartment_name()};
		int update = qr.update(sql, params);
		return update;

		
	}

	@Override
	public int updateD(ColumnManagement cm) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql=" update department set department_name = ? , department_num  = ? where department_id = ?";
		Object[] params = {cm.getDepartment_name(),cm.getDepartment_num(),cm.getDepartment_id()};
		int update = qr.update(sql, params);
		return update;

		
	}

	@Override
	public int del(String value) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql=" delete from department where department_id = ?";
		String sql2="DELETE FROM news WHERE department_id = ?";
		qr.update(sql2,value);
		int delete = qr.update(sql, value);
		
         return delete;
	
	}

	@Override
	public int selectId(String text) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql=" select (department_id) from department";
       return  (int) qr.query(sql, new ScalarHandler());
		
	}

	@Override
	public boolean isExit(int username) throws SQLException {
		// TODO Auto-generated method stub
		//这是判断用户名是否村在
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		boolean flag = false;
        String sql = " select * from department where department_id = ? ";

        Object query = qr.query(sql, new ScalarHandler(),username);
        if(query!=null){
        	flag = true;
        }
        return flag;
	}

	@Override
	public boolean isExitUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = " select * from news_user where username= ? ";
        Object query = qr.query(sql, new ScalarHandler(),username);
       if(query!=null){
    	   flag = true;
       }
		return flag;
	}

}
