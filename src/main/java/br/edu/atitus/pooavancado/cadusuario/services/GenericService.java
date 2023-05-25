package br.edu.atitus.pooavancado.cadusuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.cadusuario.entities.GenericEntity;
import br.edu.atitus.pooavancado.cadusuario.repositories.GenericRepository;

public interface GenericService<TGeneric extends GenericEntity, TRepository extends GenericRepository<TGeneric>> {

	TRepository getRepository();
	
	default TGeneric save(TGeneric objeto) throws Exception{
		if(getRepository().existsByNomeAndIdNot(objeto.getNome(), objeto.getId()))
			throw new Exception("Já existe cadastro com este nome");
		
		return this.getRepository().save(objeto);
	}
	
	default TGeneric findById(Long id) throws Exception{
		var objeto = this.getRepository().findById(id);
		
		if(objeto.isEmpty())
			throw new Exception("Não existe cadastro com o ID: " + id);
		
		return objeto.get();
	}
	
	default Page<TGeneric> findByNome(String nome, Pageable pageable) throws Exception{
		return this.getRepository().findByNomeContainingIgnoreCase(nome, pageable);
	}
	
	default void deleteById(Long id) throws Exception{
		if(!getRepository().existsById(id))
			throw new Exception("Não existe cadastro com o ID: " + id);
			
		getRepository().deleteById(id);
	}	
}