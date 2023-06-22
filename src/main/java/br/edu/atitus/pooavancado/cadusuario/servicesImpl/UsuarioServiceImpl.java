package br.edu.atitus.pooavancado.cadusuario.servicesImpl;

import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;
import br.edu.atitus.pooavancado.cadusuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.cadusuario.services.UsuarioService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	final UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void validateSave(Usuario objeto) throws Exception {
		UsuarioService.super.validateSave(objeto);
		if (objeto.getEmail() == null || objeto.getEmail().isEmpty())
			throw new Exception("É necessário informar o email válido.");
		if(getRepository().existsByEmailAndIdNot(objeto.getEmail(), objeto.getId()))
			throw new Exception("Já existe usuário com este email.");
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com este email."));

		return usuario;
	}
}