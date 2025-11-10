package com.estoque.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.estoque.estoque.model.Categoria;
import com.estoque.estoque.repository.CategoriaRepository;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Exibe o formulário e a lista de categorias
    @GetMapping("/categorias")
    public String mostrarCategorias(Model model) {
        model.addAttribute("novaCategoria", new Categoria());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categorias"; // nome do arquivo HTML (categorias.html)
    }

    // Adiciona uma nova categoria
    @PostMapping("/categorias/adicionar")
    public String adicionarCategoria(@ModelAttribute Categoria novaCategoria) {
        categoriaRepository.save(novaCategoria);
        return "redirect:/categorias";
    }
}
