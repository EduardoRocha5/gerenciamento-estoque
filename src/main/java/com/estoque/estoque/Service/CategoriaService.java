package com.estoque.estoque.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.estoque.model.Categoria;
import com.estoque.estoque.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> exibirCategorias() {

        return categoriaRepository.findAll();

    }

    public void salvar(Categoria categoria) {

        validarCategoria(categoria);
        categoriaRepository.save(categoria);

    }

    private void validarCategoria(Categoria categoria) {

        if (categoriaRepository.existsByNome(categoria.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com este nome!");
        }

    }

}
