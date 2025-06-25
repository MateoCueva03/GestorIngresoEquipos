package com.uisrael.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.uisrael.entity.Categoria;
import com.uisrael.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	
	 @Autowired private CategoriaService service;

	    @GetMapping
	    public String listar(Model model) {
	        model.addAttribute("categorias", service.listar());
	        return "categoria/listar";
	    }

	    @GetMapping("/nuevo")
	    public String nuevo(Model model) {
	        model.addAttribute("categoria", new Categoria());
	        return "categoria/formulario";
	    }

	    @PostMapping("/guardar")
	    public String guardar(@ModelAttribute Categoria categoria) {
	        service.guardar(categoria);
	        return "redirect:/categorias";
	    }
}
