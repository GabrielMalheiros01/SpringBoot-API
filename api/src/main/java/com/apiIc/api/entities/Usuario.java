package com.apiIc.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

import com.apiIc.api.entities.enums.Cor;
import com.apiIc.api.entities.enums.Escolaridade;
import com.apiIc.api.entities.enums.Estado_civil;
import com.apiIc.api.entities.enums.Renda_mensal;
import com.apiIc.api.entities.enums.Sexo;
import com.apiIc.api.entities.enums.Tipo_Moradia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	/* Static para o objeto poder ser salvo */
	private static final long serialVersionUID = 1L;

	// definir todos os atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@Column(name = "cpf", columnDefinition = "VARCHAR(15)")
	private String cpf;
	@Column(name = "nome", columnDefinition = "VARCHAR(60)")
	private String nome;
	@Column(name = "nome_social", columnDefinition = "VARCHAR(60)")
	private String nome_social;
	private LocalDate data_nascimento;
	private String senha;
	private String email;
	private long telefone;
	private long telefone_contato;
	private double latitude;
	private double longitude;
	private String plusCode;

	
	
	// enums
	
	@Column(columnDefinition = "ENUM('negro', 'branco', 'pardo')")
	@Enumerated(EnumType.STRING)
	private Cor cor;
	@Column(columnDefinition = "ENUM('ensino_Medio_Completo', 'ensino_Medio_Imcompleto', 'ensino_Superior_Completo', 'ensino_Superior_Imcompleto')")
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	@Column(columnDefinition = "ENUM('ate_1_salário_mínimo', 'entre_1_e_5_salários_mínimos', 'entre_5_e_10_salários_mínimos', 'acima_de_10_salários_mínimos')")
	@Enumerated(EnumType.STRING)
	private Renda_mensal renda_mensal;
	@Column(columnDefinition = "ENUM('homem', 'mulher', 'outro')")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Column(columnDefinition = "ENUM('propria', 'alugada', 'favor_familia')")
	@Enumerated(EnumType.STRING)
	private Tipo_Moradia tipo_moradia;
	@Column(columnDefinition = "ENUM('solteiro','casado', 'separado', 'divorciado', 'viuvo')")
	@Enumerated(EnumType.STRING)
	private Estado_civil estado_civil;

	@ManyToMany
	@JoinTable(name = "tb_usuario_deficiencia", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_deficiencia"))
	private Set<Deficiencia> defs = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_usuario_beneficio", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_beneficio"))
	private Set<Beneficio> bens = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_usuario_endereco", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_endereco"))
	private Set<Endereco> end = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_usuario_profissao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_profissao"))
	private Set<Profissao> profs = new HashSet<>();

	// construtor vazio
	public Usuario() {
	}

	// construtor com todos os atributos
	public Usuario(Long id_usuario, String nome, String nome_social, String cpf, LocalDate data_nascimento, String email,String senha,
			long telefone, long telefone_contato, Double latitude, Double longitude, String plusCode,
			Cor cor, Escolaridade escolaridade, Renda_mensal renda_mensal, Sexo sexo,Estado_civil estado_civil, Tipo_Moradia tipo_moradia) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nome_social = nome_social;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.telefone = telefone;
		this.telefone_contato = telefone_contato;
		this.latitude = latitude;
		this.longitude = longitude;
		this.plusCode = plusCode;
		this.cor = cor;
		this.escolaridade = escolaridade;
		this.renda_mensal = renda_mensal;
		this.sexo = sexo;
		this.estado_civil = estado_civil;
		this.tipo_moradia = tipo_moradia;
	}

	

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_social() {
		return nome_social;
	}

	public void setNome_social(String nome_social) {
		this.nome_social = nome_social;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public long getTelefone_contato() {
		return telefone_contato;
	}

	public void setTelefone_contato(long telefone_contato) {
		this.telefone_contato = telefone_contato;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getPlusCode() {
		return plusCode;
	}

	public void setPlusCode(String plusCode) {
		this.plusCode = plusCode;
	}

	public LocalDate  getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate  data_nascimento) {
		this.data_nascimento = data_nascimento;
	}


	public Set<Deficiencia> getDefs() {
		return defs;
	}

	public Set<Beneficio> getBens() {
		return bens;
	}
	
	public Set<Endereco> getEnd() {
		return end;
	}
	
	public Set<Profissao> getProfs(){
		return profs;
	}

	// hashCode e equals

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Renda_mensal getRenda_mensal() {
		return renda_mensal;
	}

	public void setRenda_mensal(Renda_mensal renda_mensal) {
		this.renda_mensal = renda_mensal;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Tipo_Moradia getTipo_moradia() {
		return tipo_moradia;
	}

	public void setTipo_moradia(Tipo_Moradia tipo_moradia) {
		this.tipo_moradia = tipo_moradia;
	}

	public Estado_civil getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(Estado_civil estado_civil) {
		this.estado_civil = estado_civil;
	}

	public void setProfs(Set<Profissao> profs) {
		this.profs = profs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id_usuario == other.id_usuario;
	}

}