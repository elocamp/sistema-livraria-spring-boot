package com.loja.livros.dto;

public record LivroDto(
        String titulo,
        String autores,
        Integer ano_lancamento,
        String genero,
        String sinopse,
        Double avaliacao,
        Double preco,
        String imagem_capa
) {
}
