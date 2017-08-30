package com.newcapec.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.dao.AccountManagementDao;
import com.newcapec.edu.dao.impl.AccountManagementDaoImpl;
import com.newcapec.edu.domain.SecondNews;
import com.newcapec.edu.domain.User;
import com.newcapec.edu.service.AccountManagementService;

public class AccountManagementServiceImpl implements AccountManagementService {

	@Override
	public List<SecondNews> selectAccount()   throws SQLException{
		// TODO Auto-generated method stub
		AccountManagementDao amd = new AccountManagementDaoImpl();
	    	return amd.selectUser();
	}

	@Override
	public int addAcount(User user) throws SQLException {
		// TODO Auto-generated method stub
		AccountManagementDao amd = new AccountManagementDaoImpl();
      int flag =   amd.addAccount(user);
      return flag;
	}

	@Override
	public int updateA(String a_n, String a_p) throws SQLException{
		// TODO Auto-generated method stub
		AccountManagementDao amd = new AccountManagementDaoImpl();
	      int flag =   amd.addAccount(a_n,a_p);

		return flag;
	}

	@Override
	public int delA(String del) throws SQLException {
		// TODO Auto-generated method stub
		AccountManagementDao amd = new AccountManagementDaoImpl();
	      int flag =   amd.delA(del);
		return flag;
	}

	@Override
	public int addManage(String checkss, int id)throws SQLException {
		// TODO Auto-generated method stub
		AccountManagementDao amd = new AccountManagementDaoImpl();
      return   amd.addManage(checkss,id) ;
		
	}

	@Override
	public int getId(String check3) throws SQLException {
		// TODO Auto-generated method stub
		AccountManagementDao amd = new AccountManagementDaoImpl();
       return amd.getId(check3) ;
		
	}

}
