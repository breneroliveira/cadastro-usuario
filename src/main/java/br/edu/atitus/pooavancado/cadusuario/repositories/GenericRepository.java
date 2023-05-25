package br.edu.atitus.pooavancado.cadusuario.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.edu.atitus.pooavancado.cadusuario.entities.GenericEntity;

@NoRepositoryBean
public interface GenericRepository<TGeneric extends GenericEntity> extends JpaRepository<TGeneric, Long> {

	Page<TGeneric> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	boolean existsByNomeAndIdNot(String nome, long id);	
	Page<TGeneric> findByNome(String nome, Pageable pageable);
}