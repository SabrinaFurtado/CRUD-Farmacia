package com.generation.webdev.pharmacysystem.controller;


import com.generation.webdev.pharmacysystem.model.Categoria;
import com.generation.webdev.pharmacysystem.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {


    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listasTodasCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaId(@PathVariable Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok(novaCategoria);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atulizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoria.setId(id);
            Categoria categoriaAtualizada = categoriaRepository.save(categoria);
            return ResponseEntity.ok(categoriaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoriaId(@PathVariable Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCategorias() {
        categoriaRepository.deleteAll();
        return ResponseEntity.ok("Todas as categorias foram excluídas com sucesso.");
    }
}
