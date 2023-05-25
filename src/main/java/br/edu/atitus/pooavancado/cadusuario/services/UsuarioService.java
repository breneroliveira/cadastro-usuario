package br.edu.atitus.pooavancado.cadusuario.services;

import org.springframework.data.repository.query.Param;

import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;
import br.edu.atitus.pooavancado.cadusuario.repositories.UsuarioRepository;

public interface UsuarioService extends GenericService<Usuario, UsuarioRepository>{
	
	void alteraStatus(@Param(value = "id") long id) throws Exception;
}