package com.springboot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.AccountHolder;
import com.springboot.main.repository.AccountHolderRepository;

@Service
public class AccountHolderService {

	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	public AccountHolder insert(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		return accountHolderRepository.save(accountHolder);
	}

	public List<AccountHolder> getAccountHoldersByAccountType(String accountType) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountHolder> getAccountHoldersByExecutiveId(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

}