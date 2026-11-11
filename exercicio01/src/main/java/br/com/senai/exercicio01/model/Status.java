package br.com.senai.exercicio01.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    em_operacao("em opera\u00e7\u00e3o"),
    desligada("desligada"),
    desativada("desativada");

    private final String descricao;
    Status(String descricao) { this.descricao = descricao; }

    @JsonValue
    public String getDescricao() { return descricao; }

    @JsonCreator
    public static Status fromJson(String valor) {
        if (valor == null) return null;
        String normalizado = valor.trim().toLowerCase()
                .replace("\u00f3", "o").replace("\u00e3", "a")
                .replace("\u00e7", "c").replace(' ', '_');
        return switch (normalizado) {
            case "em_operacao" -> em_operacao;
            case "desligada" -> desligada;
            case "desativada" -> desativada;
            default -> throw new IllegalArgumentException("Invalid status: " + valor);
        };
    }
}
