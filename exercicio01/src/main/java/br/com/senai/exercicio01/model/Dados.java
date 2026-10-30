package br.com.senai.exercicio01.model;

import jakarta.persistence.*;

@Entity
@Table(name="dados")
public class Dados {

    @Id
    @OneToOne 
    @MapsId
    @JoinColumn(name="maquinaId")
    private Long maquina_id;

    @Column(name="consumoKw")
    private double consumoKw;

    @Column(name="")
}
