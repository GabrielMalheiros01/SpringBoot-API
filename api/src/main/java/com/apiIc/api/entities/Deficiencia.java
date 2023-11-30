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
@Table(name = "tb_Deficiencia")
public class Deficiencia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_deficiencia")
	private Long id_deficiencia;
	private String desc_deficiencia;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "defs")
	private Set<Usuario> user = new HashSet<>();
	
	
	public Deficiencia() {}
	
	public Deficiencia(Long id_deficiencia, String desc_deficiencia) {
		super();
		this.id_deficiencia = id_deficiencia;
		this.desc_deficiencia = desc_deficiencia;
	}

	public Long getId_deficiencia() {
		return id_deficiencia;
	}

	public void setId_deficiencia(Long id_deficiencia) {
		this.id_deficiencia = id_deficiencia;
	}

	public String getDesc_deficiencia() {
		return desc_deficiencia;
	}

	public void setDesc_deficiencia(String desc_deficiencia) {
		this.desc_deficiencia = desc_deficiencia;
	}

	public Set<Usuario> getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_deficiencia == null) ? 0 : id_deficiencia.hashCode());
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
		Deficiencia other = (Deficiencia) obj;
		if (id_deficiencia == null) {
			if (other.id_deficiencia != null)
				return false;
		} else if (!id_deficiencia.equals(other.id_deficiencia))
			return false;
		return true;
	}

	
}
