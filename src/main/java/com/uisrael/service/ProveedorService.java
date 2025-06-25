package com.uisrael.service;

import java.util.List;

import com.uisrael.entity.Proveedor;

public interface ProveedorService {
	
	Proveedor guardar(Proveedor proveedor);
    List<Proveedor> listar();

}
