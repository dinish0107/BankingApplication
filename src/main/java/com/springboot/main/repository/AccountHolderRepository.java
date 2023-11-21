package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.main.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {

}