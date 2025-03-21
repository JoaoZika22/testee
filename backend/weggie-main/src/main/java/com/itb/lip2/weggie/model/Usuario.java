package com.itb.lip2.weggie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoUsuario", discriminatorType = DiscriminatorType.STRING)
@EnableJpaAuditing
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoUsuario")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Cliente.class, name = "Cliente"),
		@JsonSubTypes.Type(value = Funcionario.class, name = "Funcionario")
})
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Incremento
	protected Long id;
	protected String nome;
	protected String sobrenome;
	protected String email;
	protected String senha;
	protected String cpf;
	protected String telefone;
	protected String cep;
	protected String rua;
	protected String bairro;
	protected String cidade;
	protected String estado;
	protected String numero;
	protected String complemento;
	protected boolean codStatusUsuario;
	protected LocalDate dataNascimento;
	@JsonIgnore
	@Column(insertable = false, updatable = false)
	protected String tipoUsuario;


	// FetchType.EAGER  -> Traz todos os registros relacionados
	// FetchType.LAZY   -> Não traz os registros relacionados

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)   // M: N
	@JoinTable(
			name="usuarios_papeis",
			joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="papel_id", referencedColumnName = "id")
	)
	private Collection<Papel> papeis;

	public Usuario() {

	}

	public Usuario(Long id, String nome,String email, String senha, String tipoUsuario, Collection<Papel> papeis) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.papeis = papeis;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf; }
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isCodStatusUsuario() {
		return codStatusUsuario;
	}
	public void setCodStatusUsuario(boolean codStatusUsuario) {
		this.codStatusUsuario = codStatusUsuario;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Collection<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(Collection<Papel> papeis) {
		this.papeis = papeis;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(id, usuario.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}



