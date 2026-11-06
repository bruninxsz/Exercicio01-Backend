package br.com.senai.exercicio01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.senai.exercicio01.model.Maquinas;

public interface MaquinasRepository extends JpaRepository <Maquinas, Long> {
    
}
