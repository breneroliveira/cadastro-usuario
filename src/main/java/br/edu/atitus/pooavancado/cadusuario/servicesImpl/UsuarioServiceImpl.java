package br.edu.atitus.pooavancado.cadusuario.servicesImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.cadusuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.cadusuario.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	final UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioRepository getRepository() {
		return usuarioRepository;
	}

	@Override
	@Transactional
	public void alteraStatus(Long id) throws Exception {
		if(!usuarioRepository.existsById(id))
			throw new Exception("Não existe usuário com o ID " + id);
			
		usuarioRepository.alteraStatus(id);
	}	
}