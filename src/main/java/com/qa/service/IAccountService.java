package com.qa.service;

import com.qa.domain.Account;

public interface IAccountService {

	String getAllAccounts();
	String createAnAccount(String account);
	String updateAnAccount(String account, long id);
	String deleteAnAccount(String account, long id);
	Account findAccount(long id);

}
