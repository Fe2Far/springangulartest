package com.zagwork.test.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zagwork.test.domain.TipoRisco;
import com.zagwork.test.representation.TipoRiscoJSON;
import com.zagwork.test.service.TipoRiscoService;

@CrossOrigin
@RestController
@RequestMapping("/tiposRisco")
public class TipoRiscoResource {
	
	@Autowired
	private TipoRiscoService tipoRiscoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<TipoRiscoJSON>> listAll(){
		
		List<TipoRisco> listTipoRisco = tipoRiscoService.findall();	
		List<TipoRiscoJSON> listTipoRiscoJSON = new ArrayList<>();
		
		for(TipoRisco a : listTipoRisco) {
			listTipoRiscoJSON.add(new TipoRiscoJSON(a));
		}
		
		return ResponseEntity.ok(listTipoRiscoJSON);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<TipoRiscoJSON> findById(@PathVariable("id") Long id){
		
		TipoRisco tipoRisco = tipoRiscoService.findById(id);
		TipoRiscoJSON tipoRiscoJSON = new TipoRiscoJSON(tipoRisco);
		
		return ResponseEntity.ok(tipoRiscoJSON);	
		
	}

}
