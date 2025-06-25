package com.uisrael.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.entity.Proveedor;
import com.uisrael.service.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

	  @Autowired private ProveedorService service;

	    @GetMapping
	    public String listar(Model model) {
	        model.addAttribute("proveedores", service.listar());
	        return "proveedor/listar";
	    }

	    @GetMapping("/nuevo")
	    public String nuevo(Model model) {
	        model.addAttribute("proveedor", new Proveedor());
	        return "proveedor/formulario";
	    }

	    @PostMapping("/guardar")
	    public String guardar(@ModelAttribute Proveedor proveedor) {
	        service.guardar(proveedor);
	        return "redirect:/proveedores";
	    }
}
