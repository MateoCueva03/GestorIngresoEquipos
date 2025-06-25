package com.uisrael.service;

import java.util.List;

import com.uisrael.entity.Producto;

public interface ProductoService {
	List<Producto> obtenerTodos();
    Producto guardar(Producto producto);
    
    
    List<Producto> productosConStockMayorA10();
    List<Producto> productosOrdenadosPorPrecio();
    List<Producto> buscarPorNombre(String nombre);
    List<Producto> buscarPorCategoria(String categoria);
    List<Producto> buscarPorProveedor(String proveedor);
    List<Producto> buscarPorRangoPrecio(double min, double max);
}
