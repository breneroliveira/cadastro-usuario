package br.edu.atitus.pooavancado.cadusuario.servicesImpl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.cadusuario.entities.Departamento;
import br.edu.atitus.pooavancado.cadusuario.repositories.DepartamentoRepository;
import br.edu.atitus.pooavancado.cadusuario.services.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	final private DepartamentoRepository departamentoRepository;

	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public Departamento save(Departamento departamento) throws Exception {
		if (departamentoRepository.existsByNomeAndIdNot(departamento.getNome(), departamento.getId())) {
			throw new Exception("Já existe departamento com este nome.");
		}
		return departamentoRepository.save(departamento);
	}

	@Override
	public Departamento findById(long id) throws Exception {
		Optional<Departamento> departamento = this.departamentoRepository.findById(id);
		if (departamento.isEmpty()) {
			throw new Exception("Não existe departamento com ID" + id);
		}
		return departamento.get();
	}

	@Override
	public Page<Departamento> findByNome(String nome, Pageable pageable) throws Exception {
		return this.departamentoRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}

	@Override
	public void deleteById(long id) throws Exception {
		if (!departamentoRepository.existsById(id)) {
			throw new Exception("Não existe departamento com ID" + id);
		}
		departamentoRepository.deleteById(id);
	}
}