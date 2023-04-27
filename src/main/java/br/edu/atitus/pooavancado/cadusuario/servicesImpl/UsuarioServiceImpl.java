package br.edu.atitus.pooavancado.cadusuario.servicesImpl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;
import br.edu.atitus.pooavancado.cadusuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.cadusuario.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	final private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario save(Usuario usuario) throws Exception {
		if (usuarioRepository.existsByNomeAndIdNot(usuario.getNome(), usuario.getId())) {
			throw new Exception("Já existe usuário com este nome.");
		}
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findById(long id) throws Exception {
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isEmpty()) {
			throw new Exception("Não existe usuário com ID" + id);
		}
		return usuario.get();
	}

	@Override
	public Page<Usuario> findByNome(String nome, Pageable pageable) throws Exception {
		return this.usuarioRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}

	@Override
	public void deleteById(long id) throws Exception {
		if (!usuarioRepository.existsById(id)) {
			throw new Exception("Não existe usuário com ID" + id);
		}
		usuarioRepository.deleteById(id);
	}

	@Override
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id)) {
			throw new Exception("Não existe usuário com ID" + id);
		}
		usuarioRepository.alteraStatus(id);
	}
}