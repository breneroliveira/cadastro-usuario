package br.edu.atitus.pooavancado.cadusuario.servicesImpl;

import br.edu.atitus.pooavancado.cadusuario.repositories.ProdutoRepository;
import br.edu.atitus.pooavancado.cadusuario.services.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoRepository getRepository() {
        return produtoRepository;
    }
}