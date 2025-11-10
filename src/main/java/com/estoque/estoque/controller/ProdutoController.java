package com.estoque.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estoque.estoque.model.Categoria;
import com.estoque.estoque.model.Produto;
import com.estoque.estoque.repository.CategoriaRepository;
import com.estoque.estoque.repository.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("paginaCategoria", categoriaRepository.findAll());
        model.addAttribute("paginaProduto", produtoRepository.findAll());


        model.addAttribute("novaCategoria", new Categoria());
        model.addAttribute("novoProduto", new Produto());

        return "index";

    }

    @GetMapping("/produtos")
    public String cadastroProduto(Model model) {
        model.addAttribute("novoProduto", new Produto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "produtos";
    }

    @PostMapping("/adicionar")
    public String adicionarProduto(@ModelAttribute Produto novoProduto) {
        produtoRepository.save(novoProduto);
        return "redirect:/";
    }

}
