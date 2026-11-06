package br.com.senai.exercicio01.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosDTO {

    @NotNull(message = "O identificador da máquina é obrigatório")
    private Long maquinaId;

    private double consumoKw;

    private LocalDateTime horarioAcionamento;

    private int pecasProduzidas;
}
