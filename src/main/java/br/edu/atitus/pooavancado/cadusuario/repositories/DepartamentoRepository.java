package br.edu.atitus.pooavancado.cadusuario.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.atitus.pooavancado.cadusuario.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	Page<Departamento> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	boolean existsByNomeAndIdNot(String nome, long id);
}