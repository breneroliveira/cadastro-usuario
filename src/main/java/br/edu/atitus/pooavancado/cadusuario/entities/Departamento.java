package br.edu.atitus.pooavancado.cadusuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_departamento")
public class Departamento extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Integer ramal;
	
	@Column(length = 150, nullable = true)
	private String email;
	

	public Integer getRamal() {
		return ramal;
	}
	
	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}