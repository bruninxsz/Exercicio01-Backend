package br.com.senai.exercicio01.dto;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosDTO {

    @NotNull(message = "O identificador da máquina é obrigatório")
    private Long maquinaId;

    private Long id;

    private double consumoKw;

    private LocalTime horarioAcionamento;

    private int pecasProduzidas;
}
