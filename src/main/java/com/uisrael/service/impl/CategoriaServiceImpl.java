package com.uisrael.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.entity.Categoria;
import com.uisrael.repository.CategoriaRepository;
import com.uisrael.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired private CategoriaRepository repo;
    public Categoria guardar(Categoria c) { return repo.save(c); }
    public List<Categoria> listar() { return repo.findAll(); }
    
}
