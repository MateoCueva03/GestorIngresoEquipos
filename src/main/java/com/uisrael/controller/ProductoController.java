package com.uisrael.controller;

import com.uisrael.entity.Producto;
import com.uisrael.service.CategoriaService;
import com.uisrael.service.ProductoService;
import com.uisrael.service.ProveedorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	 @Autowired
	    private ProductoService productoService;
	 
	 @Autowired
	 private CategoriaService categoriaService;

	 @Autowired
	 private ProveedorService proveedorService;

	    @GetMapping
	    public String listarProductos(Model model) {
	        List<Producto> productos = productoService.obtenerTodos();
	        model.addAttribute("productos", productos);
	        return "listarProductos";
	    }

	    @GetMapping("/nuevo")
	    public String nuevoProducto(Model model) {
	        model.addAttribute("producto", new Producto());
	        model.addAttribute("categorias", categoriaService.listar());
	        model.addAttribute("proveedores", proveedorService.listar());
	        return "formularioProducto";
	    }

	    @PostMapping("/guardar")
	    public String guardarProducto(@ModelAttribute Producto producto) {
	    	productoService.guardar(producto);
	        return "redirect:/productos";
	    }
	    
	    
	    //Consultas integradas
	    @GetMapping("/consultas")
	    public String mostrarConsultas(Model model) {
	        model.addAttribute("stockMayorA10", productoService.productosConStockMayorA10());
	        model.addAttribute("ordenadosPrecio", productoService.productosOrdenadosPorPrecio());
	        return "producto/consultas";
	    }

	    @GetMapping("/consultas/nombre")
	    public String consultaPorNombre(@RequestParam String nombre, Model model) {
	        model.addAttribute("stockMayorA10", productoService.productosConStockMayorA10());
	        model.addAttribute("ordenadosPrecio", productoService.productosOrdenadosPorPrecio());
	        model.addAttribute("resultado", productoService.buscarPorNombre(nombre));
	        model.addAttribute("titulo", "Resultado por Nombre");
	        return "producto/consultas";
	    }

	    @GetMapping("/consultas/categoria")
	    public String consultaPorCategoria(@RequestParam String categoria, Model model) {
	        model.addAttribute("stockMayorA10", productoService.productosConStockMayorA10());
	        model.addAttribute("ordenadosPrecio", productoService.productosOrdenadosPorPrecio());
	        model.addAttribute("resultado", productoService.buscarPorCategoria(categoria));
	        model.addAttribute("titulo", "Resultado por Categoría");
	        return "producto/consultas";
	    }

	    @GetMapping("/consultas/proveedor")
	    public String consultaPorProveedor(@RequestParam String proveedor, Model model) {
	        model.addAttribute("stockMayorA10", productoService.productosConStockMayorA10());
	        model.addAttribute("ordenadosPrecio", productoService.productosOrdenadosPorPrecio());
	        model.addAttribute("resultado", productoService.buscarPorProveedor(proveedor));
	        model.addAttribute("titulo", "Resultado por Proveedor");
	        return "producto/consultas";
	    }

	    @GetMapping("/consultas/rango")
	    public String consultaPorRango(@RequestParam double min, @RequestParam double max, Model model) {
	        model.addAttribute("stockMayorA10", productoService.productosConStockMayorA10());
	        model.addAttribute("ordenadosPrecio", productoService.productosOrdenadosPorPrecio());
	        model.addAttribute("resultado", productoService.buscarPorRangoPrecio(min, max));
	        model.addAttribute("titulo", "Resultado por Rango de Precio");
	        return "producto/consultas";
	    }
}
