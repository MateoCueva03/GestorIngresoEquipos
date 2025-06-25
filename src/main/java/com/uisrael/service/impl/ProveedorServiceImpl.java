package com.uisrael.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.entity.Proveedor;
import com.uisrael.repository.ProveedorRepository;
import com.uisrael.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	 @Autowired private ProveedorRepository repo;
	    public Proveedor guardar(Proveedor p) { return repo.save(p); }
	    public List<Proveedor> listar() { return repo.findAll(); }
}
