package br.com.senai.exercicio01.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.senai.exercicio01.dto.DadosDTO;
import br.com.senai.exercicio01.model.Dados;
import br.com.senai.exercicio01.model.Maquinas;
import br.com.senai.exercicio01.repository.DadosRepository;
import br.com.senai.exercicio01.repository.MaquinasRepository;

@RestController
@RequestMapping("/producao")
public class DadosController {
    private final DadosRepository dadosRepository;
    private final MaquinasRepository maquinasRepository;

    public DadosController(DadosRepository dadosRepository, MaquinasRepository maquinasRepository) {
        this.dadosRepository = dadosRepository;
        this.maquinasRepository = maquinasRepository;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody DadosDTO dto) {
        Maquinas maquina = maquinasRepository.findById(dto.getMaquinaId()).orElse(null);
        if (maquina == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(java.util.Map.of("erro", "Máquina não encontrada"));
        }
        Dados dado = new Dados();
        dado.setMaquina(maquina);
        dado.setConsumoKw(dto.getConsumoKw());
        dado.setHorarioAcionamento(dto.getHorarioAcionamento());
        dado.setPecasProduzidas(dto.getPecasProduzidas());
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(dadosRepository.save(dado)));
    }

    @GetMapping
    public List<DadosDTO> consultar(@RequestParam(required = false) Long maquinaId) {
        List<Dados> dados = maquinaId == null ? dadosRepository.findAll() : dadosRepository.findByMaquina_Id(maquinaId);
        return dados.stream().map(DadosController::toDto).toList();
    }

    private static DadosDTO toDto(Dados dado) {
        DadosDTO dto = new DadosDTO();
        dto.setId(dado.getId());
        dto.setMaquinaId(dado.getMaquina().getId());
        dto.setConsumoKw(dado.getConsumoKw());
        dto.setHorarioAcionamento(dado.getHorarioAcionamento());
        dto.setPecasProduzidas(dado.getPecasProduzidas());
        return dto;
    }
}
