package com.zagwork.test.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zagwork.test.domain.CreditoCliente;
import com.zagwork.test.representation.CreditoClienteJSON;
import com.zagwork.test.service.CreditoClienteService;

@CrossOrigin
@RestController
@RequestMapping("/creditos")
public class CreditoClienteResource {
	
	@Autowired
	private CreditoClienteService creditoClienteService;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<CreditoClienteJSON>> listAll(){
		
		List<CreditoCliente> listCreditos = creditoClienteService.findall();	
		List<CreditoClienteJSON> listCreditosJSON = new ArrayList<>();
		
		for(CreditoCliente a : listCreditos) {
			listCreditosJSON.add(new CreditoClienteJSON(a));
		}
		
		return ResponseEntity.ok(listCreditosJSON);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<CreditoClienteJSON> findById(@PathVariable("id") Long id){
		
		CreditoCliente credito = creditoClienteService.findById(id);
		CreditoClienteJSON creditoClienteJSON = new CreditoClienteJSON(credito);
		
		return ResponseEntity.ok(creditoClienteJSON);	
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE	)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody CreditoClienteJSON creditoClienteJSON){

		CreditoCliente credito = creditoClienteService.save(CreditoClienteJSON.build(creditoClienteJSON) );
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(credito.getIdCreditoCliente()).toUri();
		
		return ResponseEntity.created(uri).build();
			
	}
	
	
	@RequestMapping(value= "/{id}",method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE	)
	public @ResponseBody HttpEntity<CreditoClienteJSON> delete(@PathVariable("id") Long id){
		
		CreditoCliente credito = creditoClienteService.findById(id);
		CreditoClienteJSON creditoJSON = new CreditoClienteJSON(credito);
		
		creditoClienteService.delete(credito);
		
		return ResponseEntity.ok(creditoJSON);
	}

}
