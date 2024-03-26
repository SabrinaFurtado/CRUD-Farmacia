package com.generation.webdev.pharmacysystem.repository;


import com.generation.webdev.pharmacysystem.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
