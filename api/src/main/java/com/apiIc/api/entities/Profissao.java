package com.apiIc.api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_Profissao")
public class Profissao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_profissao")
	private Long id_profissao;
	private String desc_profissao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "profs")
	private Set<Usuario> user = new HashSet<>();
	
	
	public Profissao() {}
	
	public Profissao(Long id_profissao, String desc_profissao) {
		super();
		this.id_profissao = id_profissao;
		this.desc_profissao = desc_profissao;
	}

	public Long getId_profissao() {
		return id_profissao;
	}

	public void setId_profissao(Long id_profissao) {
		this.id_profissao = id_profissao;
	}

	public String getDesc_profissao() {
		return desc_profissao;
	}

	public void setDesc_profissao(String desc_profissao) {
		this.desc_profissao = desc_profissao;
	}

	public Set<Usuario> getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_profissao == null) ? 0 : id_profissao.hashCode());
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
		Profissao other = (Profissao) obj;
		if (id_profissao == null) {
			if (other.id_profissao != null)
				return false;
		} else if (!id_profissao.equals(other.id_profissao))
			return false;
		return true;
	}

	
}
