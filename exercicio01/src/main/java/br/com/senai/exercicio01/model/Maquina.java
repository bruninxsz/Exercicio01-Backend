package br.com.senai.exercicio01.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Maquina")
public class Maquina {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="tipo", nullable=false)
    private String tipo;

    @Column(name="setor")
    private String setor;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    private Status status;

    @OneToOne(mappedBy = "maquina")
    @PrimaryKeyJoinColumn 
    private Dados dados;

    public Maquina(){
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getSetor(){
        return setor;
    }

    public void setSetor(String setor){
        this.setor = setor;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}



