package br.com.senai.exercicio02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.senai.exercicio02.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
