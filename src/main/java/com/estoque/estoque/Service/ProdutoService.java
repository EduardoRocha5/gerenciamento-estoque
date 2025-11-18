package com.estoque.estoque.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.estoque.estoque.model.Produto;
import com.estoque.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void salvar(Produto produto) throws IllegalAccessException {
        validarPreco(produto);
        produtoRepository.save(produto);

    }

    private void validarPreco(Produto produto) {

        if (produto.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que ZERO");
        }
    }

    public List<Produto> exibirProdutos() {

        return produtoRepository.findAll();

    }

    public void exluirProduto(@PathVariable Long id) {

        produtoRepository.deleteById(id);

       
    }

}
