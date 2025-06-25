package com.uisrael.service.impl;

import com.uisrael.entity.Producto;

import com.uisrael.repository.ProductoRepository;
import com.uisrael.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService{
	
	   @Autowired
	    private ProductoRepository productoRepository;

	    @Override
	    public List<Producto> obtenerTodos() {
	        return productoRepository.findAll();
	    }

	    @Override
	    public Producto guardar(Producto producto) {
	        return productoRepository.save(producto);
	    }

	    public List<Producto> productosConStockMayorA10() { return productoRepository.productosConStockMayorA10(); }
	    public List<Producto> productosOrdenadosPorPrecio() { return productoRepository.productosOrdenadosPorPrecio(); }
	    public List<Producto> buscarPorNombre(String nombre) { return productoRepository.buscarPorNombre(nombre); }
	    public List<Producto> buscarPorCategoria(String categoria) { return productoRepository.buscarPorCategoria(categoria); }
	    public List<Producto> buscarPorProveedor(String proveedor) { return productoRepository.buscarPorProveedor(proveedor); }
	    public List<Producto> buscarPorRangoPrecio(double min, double max) { return productoRepository.buscarPorRangoPrecio(min, max); }

}
