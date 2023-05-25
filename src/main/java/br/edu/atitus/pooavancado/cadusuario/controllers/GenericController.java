package br.edu.atitus.pooavancado.cadusuario.controllers;

import br.edu.atitus.pooavancado.cadusuario.entities.GenericEntity;
import br.edu.atitus.pooavancado.cadusuario.services.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class GenericController<TEntity extends GenericEntity> {

    abstract GenericService<TEntity> getService();

    @PostMapping
    public ResponseEntity<Object> postRegistro(@RequestBody TEntity objeto) {
        try {
            getService().save(objeto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(objeto);
    }

    @GetMapping
    public ResponseEntity<Object> getRegistros(@PageableDefault(page = 0, size = 10,
            sort = "id", direction = Sort.Direction.ASC) Pageable paginacao,
                                              @RequestParam(required = false) String nome,
                                              @RequestParam(required = false) String email) {
        Page<TEntity> lista;

        try {
            lista = getService().findByNome(nome, paginacao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRegistroById(@PathVariable Long id) {
        TEntity objeto;

        try {
            objeto = this.getService().findById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(objeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putRegistro(@RequestBody TEntity objeto, @PathVariable Long id) {
        objeto.setId(id);

        try {
            getService().save(objeto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRegistro(@PathVariable Long id) {
        try {
            getService().deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso.");
    }
}