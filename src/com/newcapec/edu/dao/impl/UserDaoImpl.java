package com.newcapec.edu.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.newcapec.edu.domain.User;
import com.newcapec.edu.util.C3P0Util;

public class UserDaoImpl implements com.newcapec.edu.dao.UserDao {
//Dao中保存用户的方法
	@Override
	public void regist(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	
		String sql="insert into news_user values(?,?,?,?,?,?)";
		Object[] params = {user.getUsername(),user.getPassword(),user.getLevel(),user.getCode(),user.getState(),user.getEmail()};
		qr.update(sql, params);
		
	}

	@Override
	public User findByCode(String code) throws SQLException {
		// TODO Auto-generated method stub
		//根据激活码查询用户
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " select * from news_user where code = ? ";
		User user = qr.query(sql, new BeanHandler<User>(User.class),code);
		
		return user;
	}

	@Override
	public void updateState(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " update news_user set password=?, level=?,code=?,state=?,email=? where username=?";
			Object[] params = {user.getPassword(),user.getLevel(),user.getCode(),user.getState(),user.getEmail(),user.getUsername()};

		qr.update(sql, params);
		
		
		

		
	}

	@Override
	public User selectUser(String username) throws SQLException {
		// TODO Auto-generated method st
		//这个方法是返回语句
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " select * from news_user where username = ? ";
      return    qr.query(sql,new BeanHandler<User>(User.class),username );
	
	}

	@Override
	public User select(String parameter, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = " select * from news_user where username = ? and password=? ";
      return    qr.query(sql,new BeanHandler<User>(User.class),parameter ,password);	}

	
	

}
