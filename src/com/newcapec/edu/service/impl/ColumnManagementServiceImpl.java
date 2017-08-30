package com.newcapec.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.dao.ColumnManagementDao;
import com.newcapec.edu.dao.impl.ColumnManagementDaoImpl;
import com.newcapec.edu.domain.ColumnManagement;
import com.newcapec.edu.service.ColumnManagementService;

public class ColumnManagementServiceImpl implements ColumnManagementService {

	@Override
	public List<ColumnManagement> selectColumn() throws SQLException {
		// TODO Auto-generated method stub
		
		//这是栏目的管理
	 ColumnManagementDao  cmd = new ColumnManagementDaoImpl();
	     return  cmd.selectColumn() ;
	}
      //这是栏目添加的功能
	@Override
	public int  addD(ColumnManagement cm)  throws SQLException{
		// TODO Auto-generated method stub
		 ColumnManagementDao  cmd = new ColumnManagementDaoImpl();
          return cmd.addD(cm);
		
	}
	@Override
	public int updateD(ColumnManagement cm) throws SQLException {
		// TODO Auto-generated method stub
		 ColumnManagementDao  cmd = new ColumnManagementDaoImpl();
         return cmd.updateD(cm);
		
	}
	@Override
	public int del(String value)  throws SQLException{
		// TODO Auto-generated method stub
		//返回一个int方法
		 ColumnManagementDao  cmd = new ColumnManagementDaoImpl();
        return  cmd.del(value);
		
	}
	//根据账户获取id
	public int getId(String text) throws SQLException{
		 ColumnManagementDao  cmd = new ColumnManagementDaoImpl();
         return cmd.selectId(text);
	}
	@Override
	public boolean isExit(int username)throws SQLException {
		// TODO Auto-generated method stub
		 ColumnManagementDao  cmd = new ColumnManagementDaoImpl();
        return  cmd.isExit(username);
		
	}
	@Override
	public boolean isExitUsername(String username)throws SQLException {
		// TODO Auto-generated method stub
		 ColumnManagementDao  cmd = new ColumnManagementDaoImpl();

		return cmd.isExitUsername(username);
	}

}
