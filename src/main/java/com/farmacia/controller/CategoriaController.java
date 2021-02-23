package com.farmacia.controller;

import com.farmacia.models.Categoria;
import com.farmacia.models.Produto;
import com.farmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @GetMapping
public ResponseEntity<List<Categoria>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria>GetById(@PathVariable long id){
        return repository.findById(id).map(resp ->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Categoria>> GetByDescricao(@PathVariable String descricao){
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
    }
    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }


}
