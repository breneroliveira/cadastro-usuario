package br.edu.atitus.pooavancado.cadusuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.cadusuario.entities.GenericEntity;
import br.edu.atitus.pooavancado.cadusuario.repositories.GenericRepository;

public interface GenericService<TEntity extends GenericEntity> {

	GenericRepository<TEntity> getRepository();

	default void validateSave(TEntity objeto) throws Exception {
		if (objeto.getNome() == null || objeto.getNome().isEmpty())
			throw new Exception("É necessário informar o nome válido.");
		if(getRepository().existsByNomeAndIdNot(objeto.getNome(), objeto.getId()))
			throw new Exception("Já existe registro com este nome.");
	}
	
	default TEntity save(TEntity objeto) throws Exception {
		this.validateSave(objeto);
		return this.getRepository().save(objeto);
	}
	
	default TEntity findById(Long id) throws Exception {
		var objeto = this.getRepository().findById(id);
		
		if(objeto.isEmpty())
			throw new Exception("Não existe cadastro com o ID " + id);
		
		return objeto.get();
	}
	
	default Page<TEntity> findByNome(String nome, Pageable pageable) throws Exception {
		return this.getRepository().findByNomeContainingIgnoreCase(nome, pageable);
	}
	
	default void deleteById(Long id) throws Exception {
		if(!getRepository().existsById(id))
			throw new Exception("Não existe cadastro com o ID " + id);
			
		getRepository().deleteById(id);
	}	
}