package br.com.senai.exercicio01.model;

import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name="dados")
public class Dados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="maquinaId", nullable = false)
    private Maquinas maquina;

    @Column(name="consumoKw")
    private double consumoKw;

    @Column(name="horarioAcionamento")
    private LocalTime horarioAcionamento;

    @Column(name="pecasProduzidas")
    private int pecasProduzidas;

    public Dados(){
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Maquinas getMaquina(){
        return maquina;
    }

    public void setMaquina(Maquinas maquina){
        this.maquina = maquina;
    }

    public double getConsumoKw(){
        return consumoKw;
    }

    public void setConsumoKw(double consumoKw){
        this.consumoKw = consumoKw;
    }

    public LocalTime getHorarioAcionamento(){
        return horarioAcionamento;
    }

    public void setHorarioAcionamento(LocalTime horarioAcionamento){
        this.horarioAcionamento = horarioAcionamento;
    }

    public int getPecasProduzidas(){
        return pecasProduzidas;
    }

    public void setPecasProduzidas(int pecasProduzidas){
        this.pecasProduzidas = pecasProduzidas;
    }
}
