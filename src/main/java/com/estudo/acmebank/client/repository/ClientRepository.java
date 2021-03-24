package com.estudo.acmebank.client.repository;

import com.estudo.acmebank.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
