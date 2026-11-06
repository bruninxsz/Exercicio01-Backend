package br.com.senai.exercicio01.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="dados")
public class Dados {

    @Id
    @Column(name = "maquinaId")
    private Long maquinaId;

    @OneToOne
    @MapsId
    @JoinColumn(name="maquinaId")
    private Maquinas maquina;

    @Column(name="consumoKw")
    private double consumoKw;

    @Column(name="horarioAcionamento")
    private LocalDateTime horarioAcionamento;

    @Column(name="pecasProduzidas")
    private int pecasProduzidas;

    public Dados(){
    }

    public Long getMaquinaId(){
        return maquinaId;
    }

    public void setMaquinaId(Long maquinaId){
        this.maquinaId = maquinaId;
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

    public LocalDateTime getHorarioAcionamento(){
        return horarioAcionamento;
    }

    public void setHorarioAcionamento(LocalDateTime horarioAcionamento){
        this.horarioAcionamento = horarioAcionamento;
    }

    public int getPecasProduzidas(){
        return pecasProduzidas;
    }

    public void setPecasProduzidas(int pecasProduzidas){
        this.pecasProduzidas = pecasProduzidas;
    }
}
