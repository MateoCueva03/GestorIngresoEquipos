package com.uisrael.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	  
	//SIN PARÁMETROS

	// 1. Mostrar productos con stock mayor a 10 y ordenados por nombre ascendente
	@Query("SELECT p FROM Producto p WHERE p.stock > 10 ORDER BY p.nombre ASC")
	List<Producto> productosConStockMayorA10();

	// 2. Mostrar productos ordenados por precio descendente
	@Query("SELECT p FROM Producto p ORDER BY p.precio DESC")
	List<Producto> productosOrdenadosPorPrecio();

	//CON PARÁMETROS

	// 3. Buscar productos por nombre (contiene una palabra clave)
	@Query("SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
	List<Producto> buscarPorNombre(@Param("nombre") String nombre);

	// 4. Buscar productos por nombre de la categoría
	@Query("SELECT p FROM Producto p WHERE p.categoria.nombre = :nombreCategoria")
	List<Producto> buscarPorCategoria(@Param("nombreCategoria") String categoria);

	// 5. Buscar productos por nombre del proveedor
	@Query("SELECT p FROM Producto p WHERE p.proveedor.nombre = :nombreProveedor")
	List<Producto> buscarPorProveedor(@Param("nombreProveedor") String proveedor);

	// 6. Buscar productos por un rango de precios
	@Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :min AND :max")
	List<Producto> buscarPorRangoPrecio(@Param("min") double min, @Param("max") double max);





}