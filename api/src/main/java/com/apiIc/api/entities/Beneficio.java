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
@Table(name = "tb_Beneficio")
public class Beneficio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_beneficio")
	private Long id_beneficio;
	private String desc_beneficio;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "bens")
	private Set<Usuario> user = new HashSet<>();
	
	public Beneficio() {}
	
	public Beneficio(Long id_beneficio, String desc_beneficio) {
		super();
		this.id_beneficio = id_beneficio;
		this.desc_beneficio = desc_beneficio;
	}

	public Long getId_beneficio() {
		return id_beneficio;
	}

	public void setId_beneficio(Long id_beneficio) {
		this.id_beneficio = id_beneficio;
	}

	public String getDesc_beneficio() {
		return desc_beneficio;
	}

	public void setDesc_beneficio(String desc_beneficio) {
		this.desc_beneficio = desc_beneficio;
	}

	public Set<Usuario> getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_beneficio == null) ? 0 : id_beneficio.hashCode());
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
		Beneficio other = (Beneficio) obj;
		if (id_beneficio == null) {
			if (other.id_beneficio != null)
				return false;
		} else if (!id_beneficio.equals(other.id_beneficio))
			return false;
		return true;
	}

	
}
