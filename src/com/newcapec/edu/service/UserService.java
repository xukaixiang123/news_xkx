package com.newcapec.edu.service;


import java.sql.SQLException;

import com.newcapec.edu.domain.User;

public interface UserService {

	public void regist(User user) throws Exception;

	public User findByCode(String code) throws SQLException;

	public void updateState(User user) throws SQLException;

	public User selectUser(String username) throws SQLException;

	public User select(String parameter, String password) throws SQLException;

}
