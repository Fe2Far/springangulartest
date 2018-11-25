package com.zagwork.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TipoRisco {
	
	@Id
	@Column(name="tipoRisco_id")
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long idTipoRisco;
	
	@NotNull
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="taxaJuros")
	private Double taxaJuros;
	

	public TipoRisco(Long idTipoRisco) {
		super();
		this.idTipoRisco = idTipoRisco;
	}

	public TipoRisco(Long idTipoRisco, @NotNull String descricao, @NotNull Double taxaJuros) {
		super();
		this.idTipoRisco = idTipoRisco;
		this.descricao = descricao;
		this.taxaJuros = taxaJuros;
	}

	public TipoRisco() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idTipoRisco == null) ? 0 : idTipoRisco.hashCode());
		result = prime * result + ((taxaJuros == null) ? 0 : taxaJuros.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoRisco other = (TipoRisco) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idTipoRisco == null) {
			if (other.idTipoRisco != null)
				return false;
		} else if (!idTipoRisco.equals(other.idTipoRisco))
			return false;
		if (taxaJuros == null) {
			if (other.taxaJuros != null)
				return false;
		} else if (!taxaJuros.equals(other.taxaJuros))
			return false;
		return true;
	}
	
	
	
	
	

	

}
