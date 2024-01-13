package com.loja.livros.entity;

import com.loja.livros.dto.LivroDto;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "livros")
@Table(name = "livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String autores;

    private Integer ano_lancamento;

    @Column(columnDefinition = "TEXT")
    private String genero;

    @Column(columnDefinition = "TEXT", length = 500)
    private String sinopse;

    private Double avaliacao;

    private Double preco;

    @Column(columnDefinition = "TEXT")
    private String imagem_capa;

    public Livro(LivroDto dto) {
        this.titulo = dto.titulo();
        this.autores = dto.autores();
        this.ano_lancamento = dto.ano_lancamento();
        this.genero = dto.genero();
        this.sinopse = dto.sinopse();
        this.avaliacao = dto.avaliacao();
        this.preco = dto.preco();
        this.imagem_capa = dto.imagem_capa();
    }
}
