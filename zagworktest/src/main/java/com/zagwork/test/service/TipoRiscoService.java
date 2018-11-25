package com.zagwork.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zagwork.test.domain.TipoRisco;
import com.zagwork.test.repository.TipoRiscoRepository;

@Service
public class TipoRiscoService {
	
	@Autowired
	private TipoRiscoRepository tipoRiscoRepository;
	
	@Transactional(readOnly = true)
	public List<TipoRisco> findall(){
		return tipoRiscoRepository.findAll();		
	}
	
	@Transactional(readOnly = true)
	public TipoRisco findById(Long id) {
		return tipoRiscoRepository.getOne(id);
	}
	
		

}
