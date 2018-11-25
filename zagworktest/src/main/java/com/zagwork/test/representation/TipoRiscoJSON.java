package com.zagwork.test.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zagwork.test.domain.TipoRisco;

public class TipoRiscoJSON extends ResourceSupport {
	
	@JsonInclude(Include.NON_NULL)
	private Long idTipoRisco;
	
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	
	@JsonInclude(Include.NON_NULL)
	private Double taxaJuros;
	
	public static TipoRisco build(TipoRiscoJSON p) {
		TipoRisco tipoRisco = new TipoRisco();
		
		tipoRisco.setIdTipoRisco(p.getIdTipoRisco());
		tipoRisco.setDescricao(p.getDescricao());
		tipoRisco.setTaxaJuros(p.getTaxaJuros());
		
		return tipoRisco;

	}
	
	public TipoRiscoJSON(TipoRisco p) {
		super();
		this.idTipoRisco = p.getIdTipoRisco();
		this.descricao = p.getDescricao();
		this.taxaJuros = p.getTaxaJuros();
	}
	
	public TipoRiscoJSON() {
		super();
	}

	public Long getIdTipoRisco() {
		return idTipoRisco;
	}
	public void setIdTipoRisco(Long idTipoRisco) {
		this.idTipoRisco = idTipoRisco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
}
