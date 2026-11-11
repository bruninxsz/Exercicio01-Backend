package br.com.senai.exercicio01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.senai.exercicio01.model.Dados;

public interface DadosRepository extends JpaRepository <Dados, Long> {
    java.util.List<Dados> findByMaquina_Id(Long maquinaId);
}
