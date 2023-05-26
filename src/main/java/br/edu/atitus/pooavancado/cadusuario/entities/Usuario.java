package br.edu.atitus.pooavancado.cadusuario.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends GenericEntity {
	
	@Column(length = 150, nullable = true)
	private String email;
	
	@Column(nullable = false)
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "id_departamento", nullable = false)
	private Departamento departamento;

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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}