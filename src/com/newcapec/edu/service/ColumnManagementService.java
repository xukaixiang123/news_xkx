package com.newcapec.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.newcapec.edu.domain.ColumnManagement;

public interface ColumnManagementService {

	public List<ColumnManagement> selectColumn()  throws SQLException;

	public int  addD(ColumnManagement cm)  throws SQLException;

	public int updateD(ColumnManagement cm) throws SQLException;

	public int del(String value) throws SQLException;
	public int getId(String text) throws SQLException;

	public boolean isExit(int username) throws SQLException;

	public boolean isExitUsername(String username) throws SQLException;
}
