package com.zagwork.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zagwork.test.domain.CreditoCliente;
import com.zagwork.test.repository.CreditoClienteRepository;

@Service
public class CreditoClienteService {
	
	@Autowired
	private CreditoClienteRepository creditoClienteRepository;
	
	
	@Transactional(readOnly = true)
	public List<CreditoCliente> findall(){
		return creditoClienteRepository.findAll();		
	}
	
	@Transactional(readOnly = false)
	public CreditoCliente save(CreditoCliente p) {
		return creditoClienteRepository.save(p);
	}
	
	@Transactional(readOnly = true)
	public CreditoCliente findById(Long id) {
		return creditoClienteRepository.getOne(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(CreditoCliente p) {
		creditoClienteRepository.delete(p);
	}

}
