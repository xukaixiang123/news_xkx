package com.newcapec.edu.dao;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.domain.User;



public interface AccountManagementDao {

public List<SecondNews>  selectUser() throws SQLException ;
public List<Object[]> selectAllUser() throws SQLException;
public  List<Object> selectD() throws SQLException;
public int addAccount(User user) throws SQLException;
public int addAccount(String a_n, String a_p) throws SQLException;
public int delA(String del) throws SQLException;
public Object selectD2(String id) throws SQLException;
public int addManage(String checkss, int id) throws SQLException;
public int getId(String check3) throws SQLException;
}
