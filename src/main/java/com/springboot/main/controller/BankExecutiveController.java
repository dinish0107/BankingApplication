package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.BankExecutive;
import com.springboot.main.model.User;
import com.springboot.main.service.BankExecutiveService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/employees")
public class BankExecutiveController {

	@Autowired
	private BankExecutiveService bankExecutiveService;

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/postexecutive")
	public BankExecutive insertBankExecutive(@RequestBody BankExecutive bankExecutive) {
		User user = bankExecutive.getUser();
		String password=user.getPassword();
		
		user.setRole("BankExecutive");
		user = userService.insert(user);
		bankExecutive.setUser(user);

		return bankExecutiveService.insert(bankExecutive);
	}

}