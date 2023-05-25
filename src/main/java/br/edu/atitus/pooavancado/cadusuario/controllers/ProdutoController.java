package br.edu.atitus.pooavancado.cadusuario.controllers;

import br.edu.atitus.pooavancado.cadusuario.entities.Produto;
import br.edu.atitus.pooavancado.cadusuario.services.GenericService;
import br.edu.atitus.pooavancado.cadusuario.services.ProdutoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController extends GenericController<Produto> {

    final private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    GenericService<Produto> getService() {
        return produtoService;
    }
}