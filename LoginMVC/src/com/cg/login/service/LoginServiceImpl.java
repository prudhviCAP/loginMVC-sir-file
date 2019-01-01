package com.cg.login.service;

import com.cg.login.bean.LoginBean;
import com.cg.login.dao.IloginDao;
import com.cg.login.dao.LoginDaoImpl;
import com.cg.login.exception.LoginException;

public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean validate(LoginBean loginBean) {
		boolean result = false;
		if (loginBean.getUsername().length() > 3
				&& loginBean.getPassword().length() > 3) {
			result = true;

		}
		return result;
	}

	@Override
	public boolean verifyLogin(LoginBean loginBean) throws LoginException {
		IloginDao dao = new LoginDaoImpl();
		return dao.verifyLogin(loginBean);
	}

}
