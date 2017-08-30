package com.newcapec.edu.dao;

import java.sql.SQLException;

import com.newcapec.edu.domain.User;

public interface UserDao {


public void regist(User user) throws SQLException;

public User findByCode(String code) throws SQLException;

public void updateState(User user) throws SQLException;

public User selectUser(String username) throws SQLException;

public User select(String parameter, String password) throws SQLException;


}
