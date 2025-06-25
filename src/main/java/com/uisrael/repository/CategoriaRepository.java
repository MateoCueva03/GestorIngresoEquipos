package com.uisrael.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
