package br.com.senai.exercicio02.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.senai.exercicio02.model.Livro;
import br.com.senai.exercicio02.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository repository;

    public LivroController(LivroRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Livro> listar() { return repository.findAll(); }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Livro livro) {
        livro.setId(null);
        if (livro.getTitulo() == null || livro.getTitulo().isBlank() || livro.getAutor() == null || livro.getAutor().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("erro", "Titulo e autor sao obrigatorios"));
        }
        if (livro.getStatus() == null || livro.getStatus().isBlank()) livro.setStatus("Dispon\u00edvel");
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(livro));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody Livro dados) {
        return repository.findById(id).<ResponseEntity<?>>map(livro -> {
            if (dados.getTitulo() == null || dados.getTitulo().isBlank() || dados.getAutor() == null || dados.getAutor().isBlank()) {
                return ResponseEntity.badRequest().body(Map.of("erro", "Titulo e autor sao obrigatorios"));
            }
            livro.setTitulo(dados.getTitulo());
            livro.setAutor(dados.getAutor());
            livro.setEditora(dados.getEditora());
            livro.setAno(dados.getAno());
            livro.setCategoria(dados.getCategoria());
            livro.setStatus(dados.getStatus() == null || dados.getStatus().isBlank() ? "Dispon\u00edvel" : dados.getStatus());
            return ResponseEntity.ok(repository.save(livro));
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", "Livro nao encontrado")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        return repository.findById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", "Livro nao encontrado")));
    }
}
