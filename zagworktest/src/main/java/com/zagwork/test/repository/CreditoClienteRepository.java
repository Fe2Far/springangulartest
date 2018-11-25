package com.zagwork.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zagwork.test.domain.CreditoCliente;


@Repository
public interface CreditoClienteRepository extends JpaRepository<CreditoCliente, Long> {

}
