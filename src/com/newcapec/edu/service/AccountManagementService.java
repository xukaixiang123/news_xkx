package com.newcapec.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.domain.User;

public interface AccountManagementService {

	public  List<SecondNews> selectAccount()  throws SQLException;

	public int addAcount(User user) throws SQLException;

	public int updateA(String a_n, String a_p) throws SQLException;

	public int delA(String del) throws SQLException ;

	public int addManage(String checkss, int id) throws SQLException;

	public int getId(String check3) throws SQLException;

}
