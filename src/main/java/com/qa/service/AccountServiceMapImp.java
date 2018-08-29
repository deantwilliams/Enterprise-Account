package com.qa.service;

import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

public class AccountServiceMapImp implements IAccountService {

	private Map<Long, Account> accountMap;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllAccounts() {
		return util.convertObjectToJSON(accountMap);
	}

	@Override
	public String createAnAccount(String account) {
		Account accountToAdd = util.convertJSONToObject(account, Account.class);
		accountMap.put(accountToAdd.getId(),accountToAdd);
		return "Successfully added";
	}

	@Override
	public String updateAnAccount(String account, long id) {
		Account accountToUpdate = util.convertJSONToObject(account, Account.class);
		accountMap.replace(id, accountToUpdate);
		return "Successfully updated";
	}

	@Override
	public String deleteAnAccount(String account, long id) {
		Account accountToDelete = util.convertJSONToObject(account, Account.class);
		accountMap.remove(id, accountToDelete);
		return "Successfully deleted";
	}

	@Override
	public Account findAccount(long id) {
		return (Account) accountMap.entrySet().stream().filter(x -> x.getKey() == id).collect(Collectors.toMap(x -> x.getKey(),  x -> x.getValue()));
	}

}
