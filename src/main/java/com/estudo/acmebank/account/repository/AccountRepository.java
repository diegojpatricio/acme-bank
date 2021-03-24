package com.estudo.acmebank.account.repository;

import com.estudo.acmebank.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
