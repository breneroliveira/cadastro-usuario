package br.edu.atitus.pooavancado.cadusuario.servicesImpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.cadusuario.repositories.DepartamentoRepository;
import br.edu.atitus.pooavancado.cadusuario.services.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	final DepartamentoRepository departamentoRepository;
	
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public DepartamentoRepository getRepository() {
		return departamentoRepository;
	}
}