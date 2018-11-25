package com.zagwork.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CreditoCliente {
	
	@Id
	@Column(name="creditoCliente_id")
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long idCreditoCliente;
	
	@NotNull
	@Column(name="nomeCliente")
	private String nomeCliente;
	
	@NotNull
	@Column(name="limiteCredito")
	private Double limiteCredito;
	
	@NotNull
	@Column(name="taxaJurosInformado")
	private Double taxaJurosInformado;
	
	@ManyToOne
	@JoinColumn(name = "tipoRisco_id")
	private TipoRisco tipoRisco;

	
	public CreditoCliente(Long idCreditoCliente, @NotNull String nomeCliente, @NotNull Double limiteCredito,
			@NotNull Double taxaJurosInformado, @NotNull TipoRisco tipoRisco) {
		super();
		this.idCreditoCliente = idCreditoCliente;
		this.nomeCliente = nomeCliente;
		this.limiteCredito = limiteCredito;
		this.taxaJurosInformado = taxaJurosInformado;
		this.tipoRisco = tipoRisco;
	}

	public CreditoCliente() {
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

	public Double getTaxaJurosInformado() {
		return taxaJurosInformado;
	}

	public void setTaxaJurosInformado(Double taxaJurosInformado) {
		this.taxaJurosInformado = taxaJurosInformado;
	}

	public TipoRisco getTipoRisco() {
		return tipoRisco;
	}

	public void setTipoRisco(TipoRisco tipoRisco) {
		this.tipoRisco = tipoRisco;
	}

}
