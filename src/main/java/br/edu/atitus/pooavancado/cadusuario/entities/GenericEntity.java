package br.edu.atitus.pooavancado.cadusuario.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 200, nullable = false)
	private String nome;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}