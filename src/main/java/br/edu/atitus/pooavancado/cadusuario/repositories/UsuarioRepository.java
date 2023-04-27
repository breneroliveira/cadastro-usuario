package br.edu.atitus.pooavancado.cadusuario.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	boolean existsByNomeAndIdNot(String nome, long id);
	
	@Query(value = "update tb_usuario set status = not status where id = :id", nativeQuery = true)
	@Modifying
	@Transactional
	void alteraStatus(@Param(value = "id") long id);
}