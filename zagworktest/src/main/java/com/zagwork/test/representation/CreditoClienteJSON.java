package com.zagwork.test.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zagwork.test.domain.CreditoCliente;
import com.zagwork.test.domain.TipoRisco;

public class CreditoClienteJSON extends ResourceSupport {
	
	@JsonInclude(Include.NON_NULL)
	private Long idCreditoCliente;
	
	@JsonInclude(Include.NON_NULL)
	private String nomeCliente;
	
	@JsonInclude(Include.NON_NULL)
	private Double limiteCredito;
	
	@JsonInclude(Include.NON_NULL)
	private Double taxaJurosInformado;
	
	@JsonInclude(Include.NON_NULL)
	private TipoRisco tipoRisco;

	
	public CreditoClienteJSON(CreditoCliente p) {
		super();
		this.idCreditoCliente = p.getIdCreditoCliente();
		this.nomeCliente = p.getNomeCliente();
		this.limiteCredito = p.getLimiteCredito();
		this.taxaJurosInformado = p.getTaxaJurosInformado();
		this.tipoRisco = p.getTipoRisco();
	}
	
	public static CreditoCliente build(CreditoClienteJSON p) {
		
		CreditoCliente creditoCliente = new CreditoCliente();
		creditoCliente.setIdCreditoCliente(p.getIdCreditoCliente());
		creditoCliente.setLimiteCredito(p.getLimiteCredito());
		creditoCliente.setNomeCliente(p.getNomeCliente());
		creditoCliente.setNomeCliente(p.getNomeCliente());
		creditoCliente.setTaxaJurosInformado(p.getTaxaJurosInformado());
		creditoCliente.setTipoRisco(new TipoRisco(p.getTipoRisco().getIdTipoRisco()));
		
		return creditoCliente;
		
	}
	
	
	public CreditoClienteJSON() {
		super();
	}

	public Long getIdCreditoCliente() {
		return idCreditoCliente;
	}

	public void setIdCreditoCliente(Long idCreditoCliente) {
		this.idCreditoCliente = idCreditoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public TipoRisco getTipoRisco() {
		return tipoRisco;
	}

	public void setTipoRisco(TipoRisco tipoRisco) {
		this.tipoRisco = tipoRisco;
	}

	public Double getTaxaJurosInformado() {
		return taxaJurosInformado;
	}

	public void setTaxaJurosInformado(Double taxaJurosInformado) {
		this.taxaJurosInformado = taxaJurosInformado;
	}
	
	
	

}
