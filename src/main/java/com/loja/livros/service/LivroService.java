package com.loja.livros.service;

import com.loja.livros.dto.LivroDto;
import com.loja.livros.entity.Livro;
import com.loja.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public void saveLivro(Livro livro) {
        repository.save(livro);
    }

    public Livro createLivro(LivroDto livroDto) throws Exception {
        if (repository.existsByTitulo(livroDto.titulo())) {
            throw new Exception("Esta obra já está cadastrada.");
        }

        if (livroDto.ano_lancamento() < 0) {
            throw new Exception("O ano de publicação não pode ser anterior a 0.");
        }

        if (livroDto.avaliacao() < 1 || livroDto.avaliacao() > 5) {
            throw new Exception("A avaliação só pode ir de 1 a 5 estrelas.");
        }

        if (livroDto.preco() < 0) {
            throw new Exception("O preço de um livro não pode ser inferior a 0.");
        }

        Livro newLivro = new Livro(livroDto);
        saveLivro(newLivro);
        return newLivro;
    }

    public List<Livro> getAll() throws Exception {
        if (!repository.findAll().isEmpty()) {
            return repository.findAll();
        }
        else {
            throw new Exception(String.valueOf(HttpStatus.NOT_FOUND) + " - Nenhuma obra foi registrada ainda.");
        }
    }

    public Livro getLivroById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Esta obra não foi encontrada."));
    }

    public Livro updateLivroById(Long id, LivroDto livroDto) throws Exception {
        Livro livro = repository.findById(id).orElseThrow(() -> new Exception("Esta obra não foi encontrada."));

        if (livroDto.ano_lancamento() < 0) {
            throw new Exception("O ano de publicação não pode ser anterior a 0.");
        }

        if (livroDto.avaliacao() < 1 || livroDto.avaliacao() > 5) {
            throw new Exception("A avaliação só pode ir de 1 a 5 estrelas.");
        }

        if (livroDto.preco() < 0) {
            throw new Exception("O preço de um livro não pode ser inferior a 0.");
        }

        livro.setTitulo(livroDto.titulo());
        livro.setAutores(livroDto.autores());
        livro.setAno_lancamento(livroDto.ano_lancamento());
        livro.setGenero(livroDto.genero());
        livro.setSinopse(livroDto.sinopse());
        livro.setAvaliacao(livroDto.avaliacao());
        livro.setPreco(livroDto.preco());
        livro.setImagem_capa(livroDto.imagem_capa());

        saveLivro(livro);
        return livro;
    }

    public void deleteLivroById(Long id) throws Exception {
        Livro livro = repository.findById(id).orElseThrow(() -> new Exception("Esta obra não foi encontrada."));
        repository.delete(livro);
    }
}
