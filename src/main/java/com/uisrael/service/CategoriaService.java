package com.uisrael.service;

import java.util.List;

import com.uisrael.entity.Categoria;

public interface CategoriaService {
	Categoria guardar(Categoria categoria);
    List<Categoria> listar();
}
