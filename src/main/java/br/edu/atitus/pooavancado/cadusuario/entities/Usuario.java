package br.edu.atitus.pooavancado.cadusuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends GenericEntity {
	
	@Column(length = 150, nullable = true)
	private String email;
	
	@Column(nullable = false)
	private boolean status;

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}	
}