package com.cg.login.dao;

import java.sql.Connection;

import com.cg.login.bean.LoginBean;
import com.cg.login.exception.LoginException;
import com.cg.login.util.DbConnection;

public class LoginDaoImpl implements IloginDao {
	@Override
	public boolean verifyLogin(LoginBean loginBean) throws LoginException {
		boolean result=false;
		Connection connection=DbConnection.getConnection();
		return result;
	}
}