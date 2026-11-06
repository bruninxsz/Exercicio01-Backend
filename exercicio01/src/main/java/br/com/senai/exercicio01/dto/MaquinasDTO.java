package br.com.senai.exercicio01.dto;

import br.com.senai.exercicio01.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaquinasDTO {

    private Long id;

    @NotBlank(message = "O nome da máquina é obrigatório")
    private String nome;

    @NotBlank(message = "O tipo da máquina é obrigatório")
    private String tipo;

    private String setor;

    @NotNull(message = "O status da máquina é obrigatório")
    private Status status;
}
