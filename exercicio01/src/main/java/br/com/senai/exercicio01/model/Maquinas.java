package br.com.senai.exercicio01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Maquinas")
public class Maquinas{
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

    @OneToMany(mappedBy = "maquina")
    private java.util.List<Dados> dados = new java.util.ArrayList<>();

    public Maquinas(){
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



