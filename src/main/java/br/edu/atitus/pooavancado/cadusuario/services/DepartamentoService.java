package br.edu.atitus.pooavancado.cadusuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.cadusuario.entities.Departamento;

public interface DepartamentoService {

	Departamento save(Departamento departamento) throws Exception;
	Departamento findById(long id) throws Exception;
	Page<Departamento> findByNome(String nome, Pageable pageable) throws Exception;
	void deleteById(long id) throws Exception;
}