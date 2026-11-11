package br.com.senai.exercicio01.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/")
    public Map<String, String> inicio() {
        return Map.of("mensagem", "Aplicacao de monitoramento de maquinas");
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of("status", "online", "mensagem", "Aplicacao de monitoramento em execucao");
    }

    @GetMapping("/versao")
    public Map<String, String> versao() {
        return Map.of("versao", "1.0.0");
    }
}
