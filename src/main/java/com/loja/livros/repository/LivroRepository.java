package com.loja.livros.repository;

import com.loja.livros.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    boolean existsByTitulo(String titulo);
}
