package com.loja.livros.controller;

import com.loja.livros.dto.LivroDto;
import com.loja.livros.entity.Livro;
import com.loja.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    @CrossOrigin("https://sistema-livraria-react-ts.vercel.app/")
    public ResponseEntity<Livro> createLivro(
            @RequestBody LivroDto livroDto) throws Exception {
        Livro newLivro = service.createLivro(livroDto);
        return new ResponseEntity<>(newLivro, HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin("https://sistema-livraria-react-ts.vercel.app/")
    public ResponseEntity<List<Livro>> getAll() throws Exception {
        var livros = service.getAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin("https://sistema-livraria-react-ts.vercel.app/")
    public ResponseEntity<Object> getLivroById(
            @PathVariable(value = "id") Long id) throws Exception {
        var livros = service.getAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @CrossOrigin("https://sistema-livraria-react-ts.vercel.app/")
    public ResponseEntity<String> updateLivroById(
            @PathVariable(value = "id") Long id,
            @RequestBody LivroDto livroDto) throws Exception {
        service.updateLivroById(id, livroDto);
        return ResponseEntity.status(HttpStatus.OK).body("As informações da obra foram atualizadas com sucesso.");
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("https://sistema-livraria-react-ts.vercel.app/")
    public ResponseEntity<String> deleteLivroById(
            @PathVariable(value = "id") Long id) throws Exception {
        service.deleteLivroById(id);
        return ResponseEntity.status(HttpStatus.OK).body("A obra foi excluída com sucesso.");
    }
}
