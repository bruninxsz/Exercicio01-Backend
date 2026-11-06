package br.com.senai.exercicio01.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import br.com.senai.exercicio01.model.Maquinas;
import br.com.senai.exercicio01.dto.MaquinasDTO;
import br.com.senai.exercicio01.repository.MaquinasRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController   
@RequestMapping("/api/maquinas")
public class MaquinasController {

    private final MaquinasRepository maquinasRepository;

    public MaquinasController(MaquinasRepository maquinasRepository){
        this.maquinasRepository = maquinasRepository;
    }

    @PostMapping("/new")
    public String postMethodName(@RequestBody String entity) {
        
        return entity;
    }

    @GetMapping("/list")
    public List<Maquinas> listar() {
        return maquinasRepository.findAll();
    }
    
    
}
