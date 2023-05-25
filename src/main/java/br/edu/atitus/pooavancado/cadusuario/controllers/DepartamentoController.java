package br.edu.atitus.pooavancado.cadusuario.controllers;

import br.edu.atitus.pooavancado.cadusuario.entities.Departamento;
import br.edu.atitus.pooavancado.cadusuario.services.DepartamentoService;
import br.edu.atitus.pooavancado.cadusuario.services.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController extends GenericController<Departamento> {
		
	final private DepartamentoService departamentoService;

	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@Override
	GenericService<Departamento> getService() {
		return departamentoService;
	}
}