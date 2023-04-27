package br.edu.atitus.pooavancado.cadusuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario) throws Exception;
	Usuario findById(long id) throws Exception;
	Page<Usuario> findByNome(String nome, Pageable pageable) throws Exception;
	void deleteById(long id) throws Exception;
	void alteraStatus(@Param(value = "id") long id) throws Exception;
}