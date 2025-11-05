package com.estoque.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class EstoqueRepository {


    public interface CategoriaRepository extends JpaRepository<Categoria ,Long> {
    
        
    }

    public interface ProdutoRepository extends JpaRepository<Produto ,Long> {
    
        
    }

}
