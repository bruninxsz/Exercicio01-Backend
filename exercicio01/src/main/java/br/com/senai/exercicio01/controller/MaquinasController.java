package br.com.senai.exercicio01.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.senai.exercicio01.dto.MaquinasDTO;
import br.com.senai.exercicio01.model.Maquinas;
import br.com.senai.exercicio01.repository.MaquinasRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/maquinas")
public class MaquinasController {
    private final MaquinasRepository repository;

    public MaquinasController(MaquinasRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<MaquinasDTO> cadastrar(@Valid @RequestBody MaquinasDTO dto) {
        Maquinas maquina = new Maquinas();
        maquina.setNome(dto.getNome());
        maquina.setTipo(dto.getTipo());
        maquina.setSetor(dto.getSetor());
        maquina.setStatus(dto.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(repository.save(maquina)));
    }

    @GetMapping
    public List<MaquinasDTO> listar() {
        return repository.findAll().stream().map(MaquinasController::toDto).toList();
    }

    static MaquinasDTO toDto(Maquinas maquina) {
        MaquinasDTO dto = new MaquinasDTO();
        dto.setId(maquina.getId());
        dto.setNome(maquina.getNome());
        dto.setTipo(maquina.getTipo());
        dto.setSetor(maquina.getSetor());
        dto.setStatus(maquina.getStatus());
        return dto;
    }
}
