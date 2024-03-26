package com.generation.webdev.pharmacysystem.repository;

import com.generation.webdev.pharmacysystem.model.Produto; // Importe a classe de entidade Produto
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
