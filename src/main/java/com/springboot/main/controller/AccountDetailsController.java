package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.AccountDetails;
import com.springboot.main.model.Address;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.model.Employee;
import com.springboot.main.model.Manager;
import com.springboot.main.model.User;
import com.springboot.main.service.AccountDetailsService;
import com.springboot.main.service.AccountHolderService;
import com.springboot.main.service.AccountService;
import com.springboot.main.service.BankExecutiveService;

@RestController
@RequestMapping("accountDetails")
public class AccountDetailsController {

	@Autowired
	private AccountDetailsService accountDetailsService;

	@Autowired
	private AccountHolderService accountHolderService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private BankExecutive bankExecutiveService;

	
	@PostMapping("/account/add/{eid}")
	public ResponseEntity<?> insertAccountDetails(@PathVariable("eid") int eid, @RequestBody AccountDetails accountDetails) {

		try {

			BankExecutive bankExecutive = BankExecutiveService.getById(eid);
			accountDetails.setBankExecutive(bankExecutive);

			accountDetails = accountDetailsService.insert(accountDetails);
			return ResponseEntity.ok().body(accountDetails);
			} catch (InvalidIdException a) {
			return ResponseEntity.badRequest().body(a.getMessage());

		    }

			}

	}
