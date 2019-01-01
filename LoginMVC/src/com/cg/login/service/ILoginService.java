package com.cg.login.service;

import com.cg.login.bean.LoginBean;
import com.cg.login.exception.LoginException;

public interface ILoginService {

	boolean validate(LoginBean loginBean);

	boolean verifyLogin(LoginBean loginBean) throws LoginException;

}
