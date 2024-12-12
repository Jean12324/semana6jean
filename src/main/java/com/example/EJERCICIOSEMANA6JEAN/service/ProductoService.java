/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EJERCICIOSEMANA6JEAN.service;

import com.example.EJERCICIOSEMANA6JEAN.model.Producto;
import com.example.EJERCICIOSEMANA6JEAN.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jeanc
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Producto producto) {
        repository.save(producto);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
