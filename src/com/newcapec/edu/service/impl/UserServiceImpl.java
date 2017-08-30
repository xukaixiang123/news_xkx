package com.newcapec.edu.service.impl;

import java.sql.SQLException;

import javax.mail.internet.AddressException;

import com.newcapec.edu.dao.UserDao;
import com.newcapec.edu.dao.impl.UserDaoImpl;
import com.newcapec.edu.domain.User;
import com.newcapec.edu.service.UserService;
import com.newcapec.edu.util.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user) throws Exception, Exception {
		// TODO Auto-generated method stub
		
	//调用dao
		UserDao ud = new UserDaoImpl();
		ud.regist(user);
		MailUtils.sendMail(user.getEmail(), user.getCode());
		
	}

	@Override
	public User findByCode(String code)throws SQLException {
		// TODO Auto-generated method stub
		//根据激活码查询相关信息
		UserDao userDao = new UserDaoImpl();
		return userDao.findByCode(code) ;
		
	}

	@Override
	public void updateState(User user) throws SQLException {
		// TODO Auto-generated method stub
		//跟新状态的时候
		UserDao userDao = new UserDaoImpl();
		userDao.updateState(user);
		
	}

	@Override
	public User selectUser(String username) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.selectUser(username);
		
	}

	@Override
	public User select(String parameter, String password)throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.select(parameter,password) ;
		
	}

}
