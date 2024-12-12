/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EJERCICIOSEMANA6JEAN.controller;

import com.example.EJERCICIOSEMANA6JEAN.model.Producto;
import com.example.EJERCICIOSEMANA6JEAN.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jeanc
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", service.listarTodos());
        return "productos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario_producto";
    }

    @PostMapping
    public String guardarProducto(@ModelAttribute Producto producto) {
        service.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Producto producto = service.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("producto", producto);
        return "formulario_producto";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/productos";
    }
}
