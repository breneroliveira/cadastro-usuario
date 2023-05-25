package br.edu.atitus.pooavancado.cadusuario.services;

import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;
import org.springframework.data.repository.query.Param;

public interface UsuarioService extends GenericService<Usuario> {
	
	void alteraStatus(@Param(value = "id") Long id) throws Exception;
}