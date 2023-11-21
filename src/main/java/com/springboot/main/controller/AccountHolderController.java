package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Account;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.model.User;
import com.springboot.main.service.AccountHolderService;
import com.springboot.main.service.AccountService;
import com.springboot.main.service.BankExecutiveService;

@RestController
@RequestMapping("/employees")
public class AccountHolderController {

	@Autowired
	private AccountHolderService accountHolderService;

	@PostMapping("/add")
	public ResponseEntity<AccountHolder> insertAccountHolder(@RequestBody AccountHolder accountHolder) {
			accountHolder = accountHolderService.insert(accountHolder);
			return ResponseEntity.ok().body(accountHolder);
	}

	
	@GetMapping("/accounts/{accountType}")
	public List<AccountHolder> getAccountHoldersByAccountType(@PathVariable("accountType") String accountType) {
		return accountHolderService.getAccountHoldersByAccountType(accountType);
	
	}
	
	
	@GetMapping("/accounts/bankexecutive/{eid}")
	public ResponseEntity<?> getAccountHolderByExecutiveId(@PathVariable("eid") int eid) {
		try {
			BankExecutive bankExecutive = BankExecutiveService.getById(eid);
			List<AccountHolder> list = AccountHolderService.getAccountHoldersByExecutiveId(eid);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException a) {
			return ResponseEntity.badRequest().body(a.getMessage());

		}
	}
}