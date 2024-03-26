package com.generation.webdev.pharmacysystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.generation.webdev.pharmacysystem.model.Produto;
import com.generation.webdev.pharmacysystem.repository.ProdutoRepository;


import java.util.List;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository produtoRepository;


    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }


    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return (Produto) produtoRepository.save(produto);
    }


    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return (Produto) produtoRepository.findById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {


        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return (Produto) produtoRepository.save(produto);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllProdutos() {
        produtoRepository.deleteAll();
        return ResponseEntity.ok("Todos os produtos foram excluídos com sucesso.");
    }
}
