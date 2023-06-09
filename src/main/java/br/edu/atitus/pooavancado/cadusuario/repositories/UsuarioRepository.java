package br.edu.atitus.pooavancado.cadusuario.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends GenericRepository<Usuario> {
	
	@Query(value = "update tb_usuario set status = NOT status where id = :id", nativeQuery = true)
	@Modifying
	void alteraStatus(@Param(value = "id") Long id);
	boolean existsByEmailAndIdNot(String email, Long id);
	Optional<Usuario> findByEmail(String email);
}