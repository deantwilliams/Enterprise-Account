package com.qa.service.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import java.util.List;
import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
public class AccountDBRepository {

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllAccounts()
	{
		TypedQuery<Account> query = manager.createQuery("Select a FROM Account a ORDER m.id DESC",Account.class);
		List<Account> accounts = (List<Account>) query.getResultList();
		return util.convertObjectToJSON(accounts);
	}
	
	@Transactional(TxType.REQUIRED)
	public String createAnAccount(String account)
	{
		Account acc = util.convertJSONToObject(account, Account.class);
		manager.persist(acc);
		return "Account has been added";
	}
	
	@Transactional(TxType.REQUIRED)
	public String updateAnAccount(String account, long id)
	{
		Account updatedAcc = util.convertJSONToObject(account, Account.class);
		Account originalAcc = findAccount(id);
		if(account != null && originalAcc != null)
		{
			originalAcc = updatedAcc;
			manager.merge(originalAcc);
		}
		return "Account has been updated";
	}
	
	@Transactional(TxType.REQUIRED)
	public String deleteAnAccount(String account, long id)
	{
		Account originalAcc = findAccount(id);
		if(originalAcc != null)
		{
			manager.remove(originalAcc);
		}
		return "Account has been deleted";
	}
	
	private Account findAccount(long id)
	{
		return manager.find(Account.class, id);
	}
	
	
}
